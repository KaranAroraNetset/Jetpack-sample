package com.track.union.presentation.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.track.union.R
import com.track.union.navigation.Screen
import com.track.union.presentation.item.PaymentMethodItem
import com.track.union.presentation.model.ChoosePaymentModel
import com.track.union.utils.SpacerHeight

@Composable
fun PaymentMethodCardScreen(modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(topStart = 22.dp, topEnd = 22.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(R.color.def_bg_color))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SpacerHeight(10.dp)
            Row(modifier = modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(R.drawable.home_indicator),
                    contentDescription = null,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(R.drawable.cross_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(25.dp)

                )
            }
            SpacerHeight(10.dp)
            Text(
                text = "Choose Payment Method",
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                color = colorResource(R.color.card_text_color)
            )
            SpacerHeight(20.dp)
            val paymentDataList = listOf(
                ChoosePaymentModel(R.drawable.coupon_code_icon,"Union Wallet", "Balance : UGX.10,000"),
                ChoosePaymentModel(R.drawable.cash_money_icon,"Pay with Cash", "Prepare your cash"),
                ChoosePaymentModel(R.drawable.mobile_money_icon,"Mobile Money", "Pay with Mobile Money")
            )
            var selectedIndex by remember { mutableStateOf(0) }
            LazyColumn {
                itemsIndexed(paymentDataList) { index, item ->
                    PaymentMethodItem(
                        item = item,
                        isSelected = selectedIndex == index,
                        onSelect = {
                            selectedIndex = index
                        }
                    )
                }
            }
            SpacerHeight(20.dp)
            Button(
                onClick = {
//                    navController.navigate(Screen.Verification.route)
                },
                modifier = modifier.fillMaxWidth().height(55.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.button_bg_color))
            ) {
                Text(
                    text = "Submit",
                    color = colorResource(R.color.white),
                    fontSize = 16.sp, fontFamily = FontFamily(Font(R.font.poppins_medium))
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PaymentMethodCardScreenPrev(modifier: Modifier = Modifier) {
    PaymentMethodCardScreen()
}