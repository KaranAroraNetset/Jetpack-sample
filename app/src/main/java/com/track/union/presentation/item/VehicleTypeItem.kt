package com.track.union.presentation.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
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
import com.track.union.utils.SpacerWidth
import com.track.union.utils.VehicleModel

@Composable
fun VehicleTypeItem(
    item: VehicleModel, isSelected: Boolean,
    onClick: () -> Unit, modifier: Modifier = Modifier
) {

    val backgroundColor =
        if (isSelected) colorResource(R.color.primary_color) else colorResource(R.color.secondary_color)
    val textColor =
        if (isSelected) colorResource(R.color.white) else colorResource(R.color.heading_color)
    val image =
        if (isSelected) painterResource(R.drawable.error_icon) else painterResource(R.drawable.notification_icon)
    Card(modifier = modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)
        .clickable { onClick() }) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(backgroundColor)
                .padding(8.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(item.image),
                contentDescription = null,
                modifier = modifier.size(35.dp)
            )
            SpacerWidth(10.dp)
            Column() {
                Text(
                    text = item.text,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = textColor
                )
                Text(
                    text = item.time,
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = textColor
                )


            }
            SpacerWidth(10.dp)
            Image(
                painter = painterResource(R.drawable.arrow_icons),
                contentDescription = null,
                modifier = modifier.size(25.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = modifier.size(20.dp)
                )
                SpacerWidth(5.dp)
                Text(
                    text = item.price,
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = textColor
                )


            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun VehicleTypeItemPrev(modifier: Modifier = Modifier) {
    VehicleTypeItem(
        item = VehicleModel(
            R.drawable.scooty,
            "Union Boda",
            "12 mins ",
            "UGX2,160 - 4,100"
        ), isSelected = true, onClick = {})
}