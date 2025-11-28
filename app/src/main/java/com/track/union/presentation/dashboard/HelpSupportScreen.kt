package com.track.union.presentation.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.track.union.R
import com.track.union.presentation.auth.CommonTopBar
import com.track.union.presentation.dialog.AppSingleButtonDialog
import com.track.union.presentation.dialog.ConfirmationDialog
import com.track.union.utils.SpacerHeight

@Composable
fun HelpSupportScreen(navController: NavController,modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.def_bg_color))
            .padding(horizontal = 22.dp, vertical = 44.dp)
    ) {
 //       var showCouponAppliedDialog by remember { mutableStateOf(false) }
//        AppSingleButtonDialog(
//            showDialog = showCouponAppliedDialog,
//            onDismiss = { showCouponAppliedDialog = false },
//            icon = R.drawable.confirmed_icon,
//            title = "Successful Applied !!!",
//            message = "Coupon applied successfully. Enjoy savings!",
//            buttonText = "Ok"
//        )

        CommonTopBar(
            title = "Help & Support",
            onBackClick = {navController.popBackStack()}
        )

        SpacerHeight(30.dp)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(R.color.def_pick_notes_bg_color)
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 2.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Contact us (Toll Free )",
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        color = colorResource(R.color.heading_color),
                        modifier = Modifier,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(R.drawable.phone_image),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )

                }
                SpacerHeight(5.dp)
                var text by remember { mutableStateOf("") }
                TextField(
                    value = text,
                    onValueChange = { newtext ->
                        text = newtext
                    },
                    placeholder = {
                        Text(
                            text = "0800280025",
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 14.sp,
                            color = colorResource(R.color.heading_color), modifier = modifier,
                            textAlign = TextAlign.Center
                        )
                    },
                    shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp),
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
                    ),
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        errorIndicatorColor = Color.Transparent,
                        unfocusedContainerColor = colorResource(R.color.white),
                        focusedContainerColor = colorResource(R.color.white)
                    )
                )
            }

        }
        SpacerHeight(10.dp)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(R.color.def_pick_notes_bg_color)
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 2.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Email",
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        color = colorResource(R.color.heading_color),
                        modifier = Modifier,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(R.drawable.email_icon),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )

                }
                SpacerHeight(5.dp)
                var text by remember { mutableStateOf("") }
                TextField(
                    value = text,
                    onValueChange = { newtext ->
                        text = newtext
                    },
                    placeholder = {
                        Text(
                            text = "support@unionmobilityapp.com ",
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 14.sp,
                            color = colorResource(R.color.heading_color), modifier = modifier,
                            textAlign = TextAlign.Center
                        )
                    },
                    shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp),
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Email
                    ),
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        errorIndicatorColor = Color.Transparent,
                        unfocusedContainerColor = colorResource(R.color.white),
                        focusedContainerColor = colorResource(R.color.white)
                    )
                )
            }

        }
        SpacerHeight(10.dp)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(R.color.def_pick_notes_bg_color)
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 2.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Website",
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        color = colorResource(R.color.heading_color),
                        modifier = Modifier,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(R.drawable.website_icon),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )

                }
                SpacerHeight(5.dp)
                var text by remember { mutableStateOf("") }
                TextField(
                    value = text,
                    onValueChange = { newtext ->
                        text = newtext
                    },
                    placeholder = {
                        Text(
                            text = "www.unionmobility.com",
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 14.sp,
                            color = colorResource(R.color.heading_color), modifier = modifier,
                            textAlign = TextAlign.Center
                        )
                    },
                    shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp),
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text
                    ),
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        errorIndicatorColor = Color.Transparent,
                        unfocusedContainerColor = colorResource(R.color.white),
                        focusedContainerColor = colorResource(R.color.white)
                    )
                )
            }

        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HelpSupportScreenPrev(modifier: Modifier = Modifier) {
    val navController= rememberNavController()
    HelpSupportScreen(navController=navController)
}