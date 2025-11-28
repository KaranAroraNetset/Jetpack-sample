package com.track.union.presentation.dialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun OtpVerificationDialog(showDialog: Boolean, onDismiss: () -> Unit) {
    if (showDialog) {
        Dialog(onDismissRequest = onDismiss) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = Color.White
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(R.drawable.confirmed_icon),
                            contentDescription = null, modifier = Modifier.size(80.dp)
                        )
                        SpacerHeight(20.dp)
                        Text(
                            text = "Successful !!!",
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 21.sp,
                            color = colorResource(R.color.heading_color)

                        )
                        SpacerHeight(12.dp)
                        Text(
                            text = "OTP verified successfully!",
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 14.sp,
                            color = colorResource(R.color.heading_color)

                        )
                        SpacerHeight(20.dp)
                        Button(
                            onClick = onDismiss,
                            modifier = Modifier.fillMaxWidth().height(55.dp)
                                .padding(horizontal = 80.dp),
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.button_bg_color))
                        ) {
                            Text(
                                text = "Ok",
                                color = colorResource(R.color.white),
                                fontSize = 16.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_medium))
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
fun OtpVerificationDialogPrev(modifier: Modifier = Modifier) {
    OtpVerificationDialog(showDialog = true, onDismiss = {})
}