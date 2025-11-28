package com.track.union.presentation.item

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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.maps.model.Circle
import com.track.union.R
import com.track.union.presentation.dashboard.DottedLine
import com.track.union.presentation.model.HistoryModel
import com.track.union.utils.SpacerHeight
import com.track.union.utils.SpacerWidth

@Composable
fun HistoryItem(item: HistoryModel, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .clickable { onClick() },
        colors = CardColors(
            containerColor = colorResource(R.color.def_bg_color),
            contentColor = colorResource(R.color.def_bg_color),
            disabledContainerColor = colorResource(R.color.def_bg_color),
            disabledContentColor = colorResource(R.color.def_bg_color)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .background(colorResource(R.color.def_bg_color))
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                SpacerWidth(5.dp)
                Image(
                    painter = painterResource(R.drawable.destination_location_icon),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp)
                )
                SpacerWidth(5.dp)
                Text(
                    text = "Sarah Nankinga, George Street 14, \n" +
                            "Kampala 25601, Uganda",
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontSize = 10.sp,
                    color = colorResource(R.color.heading_color)
                )
                Spacer(modifier = Modifier.weight(1f))
                Column(verticalArrangement = Arrangement.Center, modifier = Modifier) {
                    Text(
                        text = "12-12-2024",
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 12.sp,
                        color = colorResource(R.color.rateTrip_text_color)
                    )
                    Text(
                        text = "7:48 AM",
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 10.sp,
                        color = colorResource(R.color.sub_text_color), textAlign = TextAlign.End,
                        modifier = Modifier.align(Alignment.End)
                    )
                }

            }

            Row {
                Spacer(modifier = Modifier.width(18.dp))
                DottedLine(
                    modifier = Modifier.height(20.dp),
                    color = Color.Blue.copy(alpha = 0.5f)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SpacerWidth(5.dp)
                Image(
                    painter = painterResource(R.drawable.source_location_icon),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp)
                )
                SpacerWidth(5.dp)
                Text(
                    text = "Musa Kiggundu, Village of Kisekka,\n" + "Masaka 12345, Uganda",
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontSize = 10.sp,
                    color = colorResource(R.color.heading_color)
                )
                Spacer(modifier = Modifier.weight(1f))
                Box(modifier = Modifier) {
                    Box(
                        contentAlignment = Alignment.BottomEnd,
                        modifier = Modifier.size(50.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.chat_image),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(CircleShape)
                        )

                        Box(
                            modifier = Modifier
                                .size(20.dp) // fixed circle size
                                .clip(CircleShape)
                                .background(colorResource(R.color.def_location_bg_color)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "4.9",
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                fontSize = 7.sp,
                                color = colorResource(R.color.heading_color), modifier = Modifier
                            )
                        }

                    }
                }


            }
            SpacerHeight(10.dp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SpacerWidth(7.dp)
                Text(
                    text = "Status: Completed",
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontSize = 12.sp,
                    color = colorResource(R.color.heading_color)
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(R.drawable.scooty_icon),
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)

                )
                SpacerWidth(5.dp)
                Text(
                    text = "UGX 5,300",
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    fontSize = 12.sp,
                    color = colorResource(R.color.heading_color)
                )

            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun HistoryItemPrev(modifier: Modifier = Modifier) {
    HistoryItem(
        item = HistoryModel(
            "Sarah Nankinga, George Street 14, Kampala 25601, Uganda",
            "Musa Kiggundu, Village of Kisekka, Masaka 12345, Uganda",
            "12-12-2024",
            "7:48 AM",
            R.drawable.profile_icon,
            "4.5",
            status = "Status: Completed",
            "UGX 5,300"
        ), onClick = {})
}