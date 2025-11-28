package com.track.union.presentation.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.track.union.R
import com.track.union.utils.noRippleClickable

@Composable
fun CommonTopBar(
    title: String,
    onBackClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
           ,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.back_arrow_icon),
            contentDescription = "Baccck",
            modifier = Modifier
                .size(20.dp)
                .clickable { onBackClick() }
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = title,
            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
            fontSize = 18.sp,
            color = colorResource(R.color.heading_color)
        )

        Spacer(modifier = Modifier.weight(1f))
    }
}
