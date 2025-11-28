package com.track.union.presentation.item

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.track.union.R
import com.track.union.presentation.model.WalletModel
import com.track.union.utils.SpacerHeight

@Composable
fun WalletItem(item: WalletModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .clickable { },
        colors = CardColors(
            containerColor = colorResource(R.color.def_bg_color),
            contentColor = colorResource(R.color.def_bg_color),
            disabledContainerColor = colorResource(R.color.def_bg_color),
            disabledContentColor = colorResource(R.color.def_bg_color)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .background(colorResource(R.color.def_bg_color))
        ) {
            Column() {
                Text(
                    text = "Date & Time",
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontSize = 13.sp,
                    color = colorResource(R.color.text_color)
                )
                SpacerHeight(5.dp)
                Row {
                    Text(
                        text = "12-12-24,",
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 11.sp,
                        color = colorResource(R.color.transaction_sub_text_color)
                    )
                    Text(
                        text = " 05:20 PM",
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 11.sp,
                        color = colorResource(R.color.transaction_sub_text_color)
                    )
                }
                SpacerHeight(5.dp)


                Text(
                    text = "Amount",
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontSize = 13.sp,
                    color = colorResource(R.color.text_color)
                )
                SpacerHeight(5.dp)

                Text(
                    text = "UGX 2,000",
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontSize = 11.sp,
                    color = colorResource(R.color.transaction_sub_text_color)
                )

            }
            Spacer(modifier = Modifier.weight(1f))
            Column {
                Text(
                    text = "MNO Ref. No",
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontSize = 13.sp,
                    color = colorResource(R.color.text_color)
                )
                SpacerHeight(5.dp)

                Text(
                    text = "VADE0B248932",
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontSize = 13.sp,
                    color = colorResource(R.color.transaction_sub_text_color)
                )
                SpacerHeight(5.dp)
                Text(
                    text = "Payment Method",
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontSize = 13.sp,
                    color = colorResource(R.color.text_color)
                )

                Text(
                    text = "Debit",
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontSize = 13.sp,
                    color = colorResource(R.color.alert_color)
                )
            }


        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun WalletItemPrev(modifier: Modifier = Modifier) {
    WalletItem(item = WalletModel("12-12-24,", "05:20 PM", "UGX 2,000", "VADE0B248932"))
}