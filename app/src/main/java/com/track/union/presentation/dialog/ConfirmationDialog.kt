package com.track.union.presentation.dialog

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.track.union.utils.SpacerHeight

@Composable
fun ConfirmationDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    onPositiveButton: () -> Unit,
    icon: Int,
    title: String,
    message: String,
    positiveButtonText: String = "Yes",
    negativeButtonText: String = "No"
) {
    if (showDialog) {
        Dialog(onDismissRequest = onDismiss) {
            Surface(shape = RoundedCornerShape(16.dp), color = Color.White) {
                Box(contentAlignment = Alignment.Center) {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(icon),
                            contentDescription = null,
                            modifier = Modifier.size(80.dp)
                        )
                        SpacerHeight(20.dp)
                        Text(
                            text =
                                title,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 21.sp,
                            color = colorResource(R.color.heading_color)
                        )
                        SpacerHeight(12.dp)
                        Text(
                            text = message,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 14.sp,
                            color = colorResource(R.color.heading_color),
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            textAlign = TextAlign.Center
                        )
                        SpacerHeight(20.dp)
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Button(
                                onClick = onDismiss,
                                modifier = Modifier
                                    .background(Color.White)
                                    .weight(1f)
                                    .height(55.dp)
                                    .padding(end = 15.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = colorResource(
                                        R.color.white
                                    )
                                ),
                                border = BorderStroke(
                                    width = 1.dp,
                                    color = colorResource(R.color.primary_color)
                                ),
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Text(
                                    negativeButtonText,
                                    fontSize = 16.sp,
                                    color = colorResource(R.color.text_color),
                                    fontFamily = FontFamily(Font(R.font.poppins_medium))
                                )
                            }
                            Button(
                                onClick =
                                    onPositiveButton,
                                modifier = Modifier
                                    .weight(1f)
                                    .height(55.dp)
                                    .padding(start = 15.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = colorResource(R.color.primary_color)
                                ),
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Text(
                                    positiveButtonText,
                                    fontSize = 16.sp,
                                    modifier = Modifier.padding(vertical = 6.dp),
                                    color = colorResource(R.color.white),
                                    fontFamily = FontFamily(Font(R.font.poppins_medium))
                                )
                            }
                        }
                    }
                }
            }
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun ConfirmationDialogPrev(modifier: Modifier = Modifier) {
    ConfirmationDialog(
        showDialog = true,
        onDismiss = {},
        onPositiveButton = {},
        icon = R.drawable.confirmed_icon,
        title = "Logout",
        message = "Are you sure you want to logout?",
        positiveButtonText = "Yes",
        negativeButtonText = "No"
    )
}