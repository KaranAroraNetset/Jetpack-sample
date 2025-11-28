package com.track.union.presentation.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.track.union.R
import com.track.union.presentation.model.CancelRideModel
import com.track.union.utils.SpacerWidth

@Composable
fun CancelRideItem(item: CancelRideModel, isSelected:Boolean, onSelect:()->Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = isSelected,
            onClick = onSelect,
            modifier = Modifier.padding(start = 10.dp).align(Alignment.Top).clip(CircleShape),
            colors = RadioButtonColors(
                selectedColor = colorResource(R.color.primary_color),
                unselectedColor = colorResource(R.color.primary_color),
                disabledSelectedColor = colorResource(R.color.primary_color),
                disabledUnselectedColor = colorResource(R.color.primary_color)
            )
        )
        SpacerWidth(10.dp)
        Text(
            text = item.text,
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            color = colorResource(R.color.payment_subtext_color)
        )

    }
}
@Preview(showBackground = true)
@Composable
fun CancelRideItemPrev(modifier: Modifier = Modifier) {
    CancelRideItem(item = CancelRideModel("I don’t need this journey."),isSelected = true, onSelect = {})
}