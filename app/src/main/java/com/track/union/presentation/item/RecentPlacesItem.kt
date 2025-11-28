package com.track.union.presentation.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.track.union.presentation.dashboard.DashedLineExample
import com.track.union.presentation.model.RecentPlacesModel
import com.track.union.utils.SpacerHeight
import com.track.union.utils.SpacerWidth

@Composable
fun RecentPlacesItem(item: RecentPlacesModel, onItemClick: (String) -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = modifier.fillMaxWidth().clickable{
                onItemClick(item.text)
            },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.location_icon),
                contentDescription = null
            )
            SpacerWidth(10.dp)
            Text(
                text = item.text, fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                color = colorResource(R.color.card_text_color),
            )

        }
        SpacerHeight(12.dp)
        DashedLineExample()
        SpacerHeight(12.dp)
    }

}

@Preview(showBackground = true)
@Composable
fun RecentPlacesItemPrev(modifier: Modifier = Modifier) {
    val list = RecentPlacesModel("Office")
    //RecentPlacesItem(item = list)
}