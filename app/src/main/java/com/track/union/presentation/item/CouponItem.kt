package com.track.union.presentation.item

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
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
import com.track.union.R
import com.track.union.presentation.model.CouponModel
import com.track.union.utils.SpacerHeight
import com.track.union.utils.SpacerWidth

@Composable
fun CouponItem(item: CouponModel,isSelected:Boolean,onSelect:()->Unit) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp), verticalAlignment = Alignment.Top) {
        Image(
            painter = painterResource(R.drawable.coupon_code_icon),
            contentDescription = null,
            modifier = Modifier.size(35.dp)
        )
        SpacerWidth(8.dp)
        Column() {
            Text(
                text = item.couponText,
                fontSize = 13.sp,
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                color = colorResource(R.color.heading_color)
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = item.couponCode,
                    fontSize = 9.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = colorResource(R.color.sub_text_color)
                )
                VerticalDivider(
                    modifier = Modifier.size(10.dp).padding(horizontal = 5.dp),
                    thickness = 1.dp,
                    color = colorResource(R.color.sub_text_color)
                )
                Text(
                    text = item.date,
                    fontSize = 9.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = colorResource(R.color.sub_text_color)
                )
            }
            SpacerHeight(12.dp)
            Card(
                modifier = Modifier.background(Color.White),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(
                    1.dp,
                    colorResource(R.color.sub_text_color)
                ), colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Text(
                    text = "WALLET600",
                    fontSize = 13.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = colorResource(R.color.heading_color), modifier = Modifier.padding(vertical = 6.dp, horizontal = 12.dp)
                )
            }

        }
        Spacer(modifier = Modifier.weight(1f))
        RadioButton(
            selected = isSelected,
            onClick = onSelect,
            modifier = Modifier.padding(start = 15.dp).align(Alignment.Top),
            colors = RadioButtonColors(
                selectedColor = colorResource(R.color.primary_color),
                unselectedColor = colorResource(R.color.primary_color),
                disabledSelectedColor =colorResource(R.color.primary_color),
                disabledUnselectedColor = colorResource(R.color.primary_color)
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CouponItemPrev(modifier: Modifier = Modifier) {
    CouponItem(
        item = CouponModel(
            "20% OFF upto UGX600 for first time user",
            "Save UGX600 with this code",
            "Valid Till: 24/02/25"
        ), isSelected = true, onSelect = {}
    )
}