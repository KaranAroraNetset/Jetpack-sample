package com.track.union.presentation.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.track.union.presentation.model.NotificationModel
import com.track.union.utils.SpacerHeight
import com.track.union.utils.SpacerWidth

@Composable
fun NotificationItem(item: NotificationModel, modifier: Modifier = Modifier) {
    Column(modifier = Modifier
        .fillMaxWidth().padding(vertical = 5.dp)
        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth().padding(horizontal = 8.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            SpacerWidth(15.dp)
            Image(
                painter = painterResource(R.drawable.coupon_code_icon),
                contentDescription = null,
                modifier = Modifier.size(25.dp)
            )
            SpacerWidth(15.dp)
            Column {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = item.text,
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        color = colorResource(R.color.heading_color)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = item.date,
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        color = colorResource(R.color.notification_text_color)
                    )
                    SpacerWidth(2.dp)
                    Text(
                        text = item.time,
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        color = colorResource(R.color.notification_text_color)
                    )
                }
                Text(
                    text = item.subText,
                    fontSize = 11.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = colorResource(R.color.sub_text_color)
                )


            }
        }
        SpacerHeight(25.dp)
        HorizontalDivider(thickness = 2.dp, color = colorResource(R.color.def_pick_notes_bg_color))
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationItemPrev(modifier: Modifier = Modifier) {
    NotificationItem(
        item = NotificationModel(
            "Wallet Amount",
            "INR 60.0 debited successfully from wallet for \\n\" + \"booking!",
            "11:53AM",
            "2023-06-23,"
        )
    )
}