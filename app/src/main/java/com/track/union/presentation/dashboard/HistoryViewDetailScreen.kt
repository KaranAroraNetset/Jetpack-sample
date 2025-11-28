package com.track.union.presentation.dashboard

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarStyle
import com.track.union.R
import com.track.union.presentation.auth.CommonTopBar
import com.track.union.utils.SpacerHeight
import com.track.union.utils.SpacerWidth

@Composable
fun HistoryViewDetailScreen(navController: NavController,modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.def_bg_color))
            .padding(horizontal = 22.dp, vertical = 44.dp)
    ) {
        CommonTopBar(
            title = "View Detail",
            onBackClick = {navController.popBackStack()}
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            SpacerHeight(20.dp)
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(0.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.profile_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp)
                        .align(Alignment.CenterVertically), alignment = Alignment.Center

                )
                SpacerWidth(10.dp)
                Column(modifier = modifier.weight(1f)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Fred",
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                            color = colorResource(R.color.rateTrip_text_color)
                        )

                        Text(
                            text = "CTRLZ89",
                            fontSize = 15.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                            color = colorResource(R.color.rateTrip_text_color),
                            modifier = modifier.padding(start = 8.dp)
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "ID: U-000052",
                                fontSize = 10.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                color = colorResource(R.color.primary_color)
                            )
                            SpacerWidth(5.dp)
                            Image(
                                painter = painterResource(R.drawable.copt_text_icon),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(12.dp)
                                    .align(Alignment.CenterVertically)
                            )


                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(R.drawable.scooty),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(18.dp)

                            )

                            Text(
                                text = "Silver Altima",
                                fontSize = 10.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                color = colorResource(R.color.sub_text_color),
                                modifier = modifier.padding(start = 5.dp)
                            )


                        }
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(R.drawable.star_icon),
                            contentDescription = null,
                            modifier = Modifier
                                .size(12.dp)
                                .align(Alignment.CenterVertically)

                        )
                        SpacerWidth(5.dp)
                        Text(
                            text = "4.9",
                            fontSize = 9.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            color = colorResource(R.color.rating_text_color)
                        )
                    }
                }

            }
            SpacerHeight(15.dp)
            Text(
                text = "How was your trip?",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                color = colorResource(R.color.rateTrip_text_color),
                modifier = modifier.align(Alignment.CenterHorizontally)
            )
            SpacerHeight(10.dp)
            var rating: Float by remember { mutableStateOf(3.0f) }
            RatingBar(
                value = rating,
                style = RatingBarStyle.Stroke(),
                onValueChange = { newRating ->
                    rating = newRating
                },
                onRatingChanged = {
                    Log.d("TAG", "onRatingChanged: $it")
                },
                modifier = Modifier.align(Alignment.CenterHorizontally),
                size = 30.dp,
                spaceBetween = 5.dp
            )
            SpacerHeight(10.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Trip Detail",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = colorResource(R.color.rateTrip_text_color)
                )

                Text(
                    text = "Date:12-12-24",
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    color = colorResource(R.color.rateTrip_text_color),
                    modifier = modifier
                )
            }
            SpacerHeight(10.dp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Distance",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = colorResource(R.color.heading_color)
                )

                Text(
                    text = "2.5km",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = colorResource(R.color.payment_subtext_color),
                    modifier = modifier
                )
            }
            SpacerHeight(3.dp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Trip Duration",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = colorResource(R.color.heading_color)
                )

                Text(
                    text = "15mins",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = colorResource(R.color.payment_subtext_color),
                    modifier = modifier
                )
            }
            SpacerHeight(10.dp)
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                colors = CardColors(
                    containerColor = colorResource(R.color.def_location_bg_color),
                    contentColor = colorResource(R.color.def_location_bg_color),
                    disabledContainerColor = colorResource(R.color.def_location_bg_color),
                    disabledContentColor = colorResource(R.color.def_location_bg_color)
                ),
                border = BorderStroke(width = 1.dp, color = colorResource(R.color.def_pick_notes_bg_color)), shape = RectangleShape
            ) {

                Column(modifier = Modifier.padding(5.dp)) {

                    Row(
                        modifier = modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        SpacerWidth(5.dp)
                        Text(
                            text = "11:03 AM",
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 12.sp,
                            color = colorResource(R.color.heading_color)
                        )
                        SpacerWidth(5.dp)
                        Image(
                            painter = painterResource(R.drawable.destination_location_icon),
                            contentDescription = null,
                            modifier = modifier.size(25.dp)
                        )
                        SpacerWidth(5.dp)
                        Text(
                            text = "Sarah Nankinga, George Street 14, \n" +
                                    "Kampala 25601, Uganda",
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 12.sp,
                            color = colorResource(R.color.heading_color)
                        )
                    }

                    Row {
                        Spacer(modifier = Modifier.width(70.dp))
                        DottedLine(
                            modifier = Modifier.height(20.dp),
                            color = Color.Blue.copy(alpha = 0.5f)
                        )
                    }

                    Row(
                        modifier = modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        SpacerWidth(5.dp)
                        Text(
                            text = "11:03 AM",
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 12.sp,
                            color = colorResource(R.color.heading_color)
                        )
                        SpacerWidth(5.dp)
                        Image(
                            painter = painterResource(R.drawable.source_location_icon),
                            contentDescription = null,
                            modifier = modifier.size(25.dp)
                        )
                        SpacerWidth(5.dp)
                        Text(
                            text = "Musa Kiggundu, Village of Kisekka, Masaka 12345, Uganda ",
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 12.sp,
                            color = colorResource(R.color.heading_color)
                        )


                    }
                }
            }
            SpacerHeight(25.dp)
            Text(
                text = "Pricing Breakdown",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                color = colorResource(R.color.rateTrip_text_color),
                modifier = modifier
            )
            SpacerHeight(20.dp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Base Fare",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = colorResource(R.color.heading_color)
                )

                Text(
                    text = "UGX500",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = colorResource(R.color.heading_color),
                    modifier = modifier
                )
            }
            SpacerHeight(8.dp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Distance Charges",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = colorResource(R.color.heading_color)
                )

                Text(
                    text = "UGX4,120",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = colorResource(R.color.heading_color),
                    modifier = modifier
                )
            }
            SpacerHeight(8.dp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Duration Charges",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = colorResource(R.color.heading_color)
                )

                Text(
                    text = "UGX1,000",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = colorResource(R.color.heading_color),
                    modifier = modifier
                )
            }
            SpacerHeight(10.dp)
            DashedLineExample()
            SpacerHeight(10.dp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Platform Fee",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = colorResource(R.color.heading_color)
                )

                Text(
                    text = "UGX5,620",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = colorResource(R.color.heading_color),
                    modifier = modifier
                )
            }

            SpacerHeight(8.dp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Sub Total",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = colorResource(R.color.heading_color)
                )

                Text(
                    text = "UGX5,620",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = colorResource(R.color.heading_color),
                    modifier = modifier
                )
            }

            SpacerHeight(12.dp)
            DashedLineExample()
            SpacerHeight(12.dp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Adjustment to Min Fare",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = colorResource(R.color.heading_color)
                )

                Text(
                    text = "UGX500",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = colorResource(R.color.heading_color),
                    modifier = modifier
                )
            }
            SpacerHeight(12.dp)
            DashedLineExample()
            SpacerHeight(12.dp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Total Fare ( Round - off) ",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = colorResource(R.color.heading_color)
                )

                Text(
                    text = "UGX5,600",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = colorResource(R.color.heading_color),
                    modifier = modifier
                )
            }
            SpacerHeight(20.dp)
            Text(
                text = "Payment Details",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                color = colorResource(R.color.rateTrip_text_color),
                modifier = modifier
            )
            SpacerHeight(10.dp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Refer No:",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = colorResource(R.color.heading_color)
                )

                Text(
                    text = "2313342sfssfsf4q44",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = colorResource(R.color.heading_color),
                    modifier = modifier
                )
            }
            SpacerHeight(8.dp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Payment Method",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = colorResource(R.color.heading_color)
                )

                Text(
                    text = "Wallet",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = colorResource(R.color.heading_color),
                    modifier = modifier
                )
            }
            SpacerHeight(8.dp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Transaction ID:",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = colorResource(R.color.heading_color)
                )

                Text(
                    text = "KHSDVJ5645676453",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = colorResource(R.color.heading_color),
                    modifier = modifier
                )
            }

            SpacerHeight(40.dp)
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun HistoryViewDetailScreenPrev(modifier: Modifier = Modifier) {
    val navController= rememberNavController()
    HistoryViewDetailScreen(navController=navController)
}