package com.track.union.presentation.item

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.track.union.R
import com.track.union.presentation.model.ChoosePaymentModel
import com.track.union.utils.SpacerHeight
import com.track.union.utils.SpacerWidth

@Composable
fun PaymentMethodItem(item: ChoosePaymentModel, isSelected:Boolean,onSelect:()->Unit) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp), verticalAlignment = Alignment.Top) {
        SpacerWidth(10.dp)
        Image(
            painter = painterResource(item.img),
            contentDescription = null,
            modifier = Modifier.size(30.dp)
        )
        SpacerWidth(15.dp)
        Column() {
            Text(
                text = item.text,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                color = colorResource(R.color.heading_color)
            )
                Text(
                    text = item.subText,
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = colorResource(R.color.payment_subtext_color)
                )

            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Powered by",
                    color = colorResource(R.color.powered_color),
                    fontSize = 7.sp, fontFamily = FontFamily(Font(R.font.poppins_regular))
                )
                SpacerWidth(4.dp)
                Image(painter = painterResource(R.drawable.ka_cyber), contentDescription = null,modifier=Modifier.size(38.dp))

            }

            SpacerHeight(12.dp)

        }
        Spacer(modifier = Modifier.weight(1f))

                HollowCircleRadioButton(
            selected = isSelected,
            onClick = onSelect ,
            size = 25.dp,
            strokeWidth = 12.dp,
                    modifier = Modifier.padding(start = 15.dp)
        )
        SpacerWidth(10.dp)

//        RadioButton(
//
//            selected = isSelected,
//            onClick = onSelect,
//            modifier = Modifier.padding(start = 15.dp).align(Alignment.Top).clip(CircleShape),
//            colors = RadioButtonColors(
//
//                selectedColor = colorResource(R.color.primary_color),
//                unselectedColor = colorResource(R.color.primary_color),
//                disabledSelectedColor = colorResource(R.color.primary_color),
//                disabledUnselectedColor = colorResource(R.color.primary_color)
//
//            )
//        )

    }
}
@Preview(showBackground = true)
@Composable
fun PaymentMethodItemPrev(modifier: Modifier = Modifier) {
    PaymentMethodItem(item = ChoosePaymentModel(R.drawable.coupon_code_icon,"adj","jjj"), onSelect = {}, isSelected = true)
}
@Composable
fun HollowCircleRadioButton(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    size: Dp = 32.dp,
    strokeWidth: Dp = 4.dp,
    innerRadiusFraction: Float = 0.4f
) {
    val outerColor = colorResource(R.color.primary_color)
    val innerColor = colorResource(R.color.white)

    Box(
        modifier = modifier
            .size(size)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(
                color = outerColor,
                style = Stroke(width = strokeWidth.toPx())
            )

            if (selected) {
                drawCircle(
                    color = innerColor,
                    radius = size.toPx() * innerRadiusFraction
                )
            }
        }
    }
}




