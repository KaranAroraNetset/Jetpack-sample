package com.track.union.presentation.dashboard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.track.union.R
import com.track.union.utils.SpacerHeight

@Composable
fun SearchingRiderConfirmationCardScreen(modifier: Modifier = Modifier) {
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
                text = "No rider available right now. \n" +
                        "Please try again later.",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                color = colorResource(R.color.card_text_color),
                textAlign = TextAlign.Center,
            )
            SpacerHeight(20.dp)
            Image(
                painter = painterResource(R.drawable.retry_scooter_icon),
                contentDescription = null,
                modifier = modifier.size(100.dp)
            )
            SpacerHeight(20.dp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                    },
                    modifier = Modifier
                        .background(Color.White)
                        .weight(1f)
                        .height(55.dp)
                        .padding(end = 15.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.white)
                    ), border = BorderStroke(
                        width = 1.dp,
                        color = colorResource(R.color.primary_color)
                    ),

                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        "Cancel",
                        fontSize = 16.sp,
                        modifier = Modifier.padding(6.dp),
                        color = colorResource(R.color.heading_color),
                        fontFamily = FontFamily(Font(R.font.poppins_medium))
                    )
                }
                Button(
                    onClick = {},
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
                        "Retry",
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
@Preview(showSystemUi = true)
@Composable
fun SearchingRiderConformationCardScreenPrev(modifier: Modifier = Modifier) {
    SearchingRiderConfirmationCardScreen()
}