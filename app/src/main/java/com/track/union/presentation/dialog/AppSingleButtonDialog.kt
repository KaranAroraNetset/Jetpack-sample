package com.track.union.presentation.dialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.track.union.R

@Composable
fun AppSingleButtonDialog(showDialog: Boolean,
                          onDismiss: () -> Unit,
                          icon: Int,
                          title: String,
                          message: String,
                          buttonText: String,
                          modifier: Modifier = Modifier,
                          onButtonClick: (() -> Unit)? = null) {
    if (showDialog) {
        Dialog(onDismissRequest = onDismiss) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = Color.White
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Column(
                        modifier = modifier.padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(icon),
                            contentDescription = null,
                            modifier = Modifier.size(80.dp)
                        )
                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = title,
                            fontSize = 21.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            color = colorResource(R.color.heading_color)
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = message,
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            color = colorResource(R.color.heading_color),
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        Button(
                            onClick = {
                                onButtonClick?.invoke() ?: onDismiss()
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(55.dp)
                                .padding(horizontal = 80.dp),
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(R.color.button_bg_color)
                            )
                        ) {
                            Text(
                                text = buttonText,
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
fun AppSingleButtonPrev(modifier: Modifier = Modifier) {
    AppSingleButtonDialog(
        showDialog = true,
        onDismiss = {},
        icon = R.drawable.confirmed_icon,
        title = "Preview Title",
        message = "This is a sample preview message for the dialog.",
        buttonText = "OK",
        onButtonClick = {}
    )
}