package com.track.union.presentation.dialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.track.union.R
import com.track.union.utils.SpacerHeight

@Composable
fun RideConfirmationDialog(showDialog: Boolean, onDismiss: () -> Unit) {
    if (showDialog){
        Dialog(onDismissRequest = onDismiss) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = Color.White
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.cross_icon),
                            contentDescription = null,
                            modifier = Modifier
                                .size(30.dp)
                                .align(Alignment.End).clickable{
                                onDismiss()
                                }
                        )
                        SpacerHeight(10.dp)
                        Row(
                            modifier = Modifier,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Estimated Fare",
                                fontSize = 18.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                color = colorResource(R.color.heading_color)
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Text(
                                text = "UGX5,300",
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                                color = colorResource(R.color.card_text_color)
                            )
                        }
                        SpacerHeight(10.dp)
                        Row(
                            modifier = Modifier,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Coupon Code:",
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                color = colorResource(R.color.coupon_code_text_color)
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Text(
                                text = "WALLET600",
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                                color = colorResource(R.color.card_text_color)
                            )
                        }
                        SpacerHeight(10.dp)
                        Row(
                            modifier = Modifier,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Coupon Benefit:",
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                color = colorResource(R.color.sub_text_color)
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Text(
                                text = "UGX600",
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                                color = colorResource(R.color.coupon_code_text_color)
                            )
                        }
                        SpacerHeight(10.dp)
                        Text(
                            text = "The fare shown is an estimate and may change  based on actual route, time, and demand conditions. Final fare will be calculated at the end of the trip.",
                            fontSize = 10.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            color = colorResource(R.color.heading_color)
                        )
                        SpacerHeight(10.dp)
                        Card (modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(16.dp)){
                            Column (modifier = Modifier.padding(10.dp)){
                                Row(
                                    modifier = Modifier,
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "Base Fare",
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                        color = colorResource(R.color.card_text_color)
                                    )
                                    Spacer(modifier = Modifier.weight(1f))
                                    Text(
                                        text = "UGX5,300",
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                        color = colorResource(R.color.heading_color)
                                    )
                                }
                                SpacerHeight(10.dp)
                                Row(
                                    modifier = Modifier,
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "Rate per km",
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                        color = colorResource(R.color.card_text_color)
                                    )
                                    Spacer(modifier = Modifier.weight(1f))
                                    Text(
                                        text = "UGX200",
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                        color = colorResource(R.color.heading_color)
                                    )
                                }
                                SpacerHeight(10.dp)
                                Row(
                                    modifier = Modifier,
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "Ride time charge per min",
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                        color = colorResource(R.color.card_text_color)
                                    )
                                    Spacer(modifier = Modifier.weight(1f))
                                    Text(
                                        text = "UGX100",
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                        color = colorResource(R.color.heading_color)
                                    )
                                }



                            }

                        }
                        SpacerHeight(20.dp)
                        Button(
                            onClick = onDismiss,
                            modifier = Modifier.fillMaxWidth().height(55.dp),
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.button_bg_color))
                        ) {
                            Text(
                                text = "Done",
                                color = colorResource(R.color.white),
                                fontSize = 16.sp, fontFamily = FontFamily(Font(R.font.poppins_medium))
                            )
                        }
                    }
                }
            }
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun RideConfirmationDialogPrev(modifier: Modifier = Modifier) {
    RideConfirmationDialog(showDialog = true, onDismiss = {})
}