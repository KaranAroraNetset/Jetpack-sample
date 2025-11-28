package com.track.union.presentation.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.track.union.R
import com.track.union.utils.SpacerHeight

@Composable
fun SearchingRiderCardScreen(modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(topStart = 22.dp, topEnd = 22.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(R.color.def_bg_color))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SpacerHeight(10.dp)
            Image(
                painter = painterResource(R.drawable.home_indicator),
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            SpacerHeight(15.dp)

            Text(
                text = "Searching Rider",
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                color = colorResource(R.color.card_text_color)
            )
            SpacerHeight(20.dp)
            Text(
                text = "We are looking for your rider. \n" +
                        "Please wait a while.",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                color = colorResource(R.color.card_text_color),
                textAlign = TextAlign.Center,
            )
            SpacerHeight(20.dp)
            Box(
                modifier = Modifier
                    .fillMaxWidth(), contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(140.dp)
                        .padding(16.dp),
                    color = colorResource(R.color.primary_color),
                    strokeWidth = 8.dp,
                    trackColor = colorResource(R.color.light_primary_color),
                    strokeCap = StrokeCap.Round
                )
                Image(
                    painter = painterResource(R.drawable.scooty),
                    contentDescription = null,
                    modifier = Modifier.size(110.dp).padding(16.dp)
                )
            }
            //CircularProgressIndicator()
            SpacerHeight(20.dp)
            Button(
                onClick = {
                },
                modifier = modifier
                    .fillMaxWidth()
                    .height(55.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.alert_color))
            ) {
                Text(
                    text = "Cancel",
                    color = colorResource(R.color.white),
                    fontSize = 16.sp, fontFamily = FontFamily(Font(R.font.poppins_medium))
                )
            }


        }
    }
}

@Composable
fun SimpleCircularProgressComponent() {


}

@Preview(showSystemUi = true)
@Composable
fun SearchingRiderCardScreenPrev(modifier: Modifier = Modifier) {
    SearchingRiderCardScreen()
}