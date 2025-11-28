package com.track.union.presentation.dashboard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.track.union.R
import com.track.union.navigation.Screen
import com.track.union.presentation.auth.CommonTopBar
import com.track.union.presentation.item.WalletItem
import com.track.union.presentation.model.WalletModel
import com.track.union.utils.SpacerHeight
import com.track.union.utils.SpacerWidth
import com.track.union.utils.noRippleClickable

@Composable
fun WalletScreen(navController: NavController,modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize().verticalScroll(rememberScrollState())
            .background(colorResource(R.color.def_bg_color))
            .padding(horizontal = 22.dp, vertical = 44.dp)
    ) {
        CommonTopBar(
            title = "Wallets",
            onBackClick = {navController.popBackStack()}
        )
        SpacerHeight(20.dp)
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(R.color.def_wallet_bg_color)
            ),
            border = BorderStroke(color = colorResource(R.color.white), width = 2.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column() {
                    Text(
                        text = "Available Amount",
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        color = colorResource(R.color.heading_color),
                        modifier = Modifier
                    )
                    SpacerHeight(8.dp)
                    Text(
                        text = "UGX 8,000",
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        color = colorResource(R.color.heading_color),
                        modifier = Modifier
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(
                            color = colorResource(R.color.primary_color),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(horizontal = 10.dp, vertical = 3.dp).noRippleClickable {
                            navController.navigate(Screen.DepositMoneyScreen.route)
                        }
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_add_circle),
                        contentDescription = null,
                        modifier = Modifier
                            .size(15.dp)
                            .clip(CircleShape)
                    )
                    SpacerWidth(5.dp)
                    Text(
                        text = "Add Deposit",
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        color = colorResource(R.color.white),
                        modifier = Modifier
                    )
                }
            }

        }
        SpacerHeight(20.dp)
        Text(
            text = "Transaction Details",
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.poppins_medium)),
            color = colorResource(R.color.card_text_color),
            modifier = Modifier
        )
        SpacerHeight(15.dp)
        val walletList = listOf(
             WalletModel("12-12-24,", "05:20 PM", "UGX 2,000", "VADE0B248932"),
            WalletModel("12-12-24,", "05:20 PM", "UGX 2,000", "VADE0B248932"),
            WalletModel("12-12-24,", "05:20 PM", "UGX 2,000", "VADE0B248932"),

        )
        LazyColumn (modifier=Modifier.weight(1f)){
            items(walletList){item->
                WalletItem(item=item)
            }
        }
        SpacerHeight(30.dp)
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 40.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Powered by",
                color = colorResource(R.color.powered_color),
                fontSize = 12.sp, fontFamily = FontFamily(Font(R.font.poppins_regular))
            )
            SpacerWidth(8.dp)
            Image(painter = painterResource(R.drawable.ka_cyber), contentDescription = null)

        }

    }
}
@Composable
fun NoWalletScreen(modifier: Modifier = Modifier) {
    Column (modifier=Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(R.drawable.wallet_icon),
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
        )
        SpacerHeight(10.dp)
        Text(
            text = "No Funds in Wallet",
            fontSize = 21.sp,
            fontFamily = FontFamily(Font(R.font.poppins_medium)),
            color = colorResource(R.color.heading_color),
            modifier = Modifier
        )
        SpacerHeight(10.dp)
        Text(
            text = "Top Up and Ride!!!",
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            color = colorResource(R.color.heading_color),
            modifier = Modifier
        )
        Spacer(modifier = Modifier.weight(1f))
    }

}
@Preview(showSystemUi = true)
@Composable
fun WalletScreenPrev(modifier: Modifier = Modifier) {
    val navController= rememberNavController()
    WalletScreen(navController=navController)
    //NoWalletScreen()
}