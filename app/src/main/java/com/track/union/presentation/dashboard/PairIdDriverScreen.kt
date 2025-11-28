package com.track.union.presentation.dashboard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.track.union.R
import com.track.union.utils.SpacerHeight
import com.track.union.utils.SpacerWidth

@Composable
fun PairIdDriverScreen(modifier: Modifier = Modifier) {
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
            Row(modifier = modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(R.drawable.home_indicator),
                    contentDescription = null,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(R.drawable.cross_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(25.dp)

                )
            }
            SpacerHeight(10.dp)
            Row (modifier=modifier.fillMaxWidth()){
                Image(
                    painter = painterResource(R.drawable.profile_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)

                )
                Column (){
                    Row (){
                        SpacerWidth(8.dp)
                        Text(
                            text = "Fred",
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_medium)),
                            color = colorResource(R.color.heading_color)
                        )
                        SpacerWidth(5.dp)
                        Image(
                            painter = painterResource(R.drawable.star_icon),
                            contentDescription = null,
                            modifier = Modifier
                                .size(13.dp).align(Alignment.CenterVertically)

                        )
                        SpacerWidth(3.dp)
                        Text(
                            text = "4.9",
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            color = colorResource(R.color.rating_text_color)
                        )
                    }
                    Text(
                        text = "ID: U-000052",
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        color = colorResource(R.color.rider_id_text_color),modifier=modifier.padding(start = 8.dp)
                    )
                    SpacerHeight(15.dp)
                    Text(
                        text = "CTRLZ89",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        color = colorResource(R.color.heading_color),modifier=modifier.padding(start = 8.dp)
                    )


                }
                Spacer(modifier=modifier.weight(1f))
                Column (verticalArrangement = Arrangement.SpaceBetween){
                    Text(
                        text = "UGX 500",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        color = colorResource(R.color.heading_color),modifier=modifier.padding(start = 8.dp)
                    )

                        SpacerHeight(35.dp)
                    Row ( verticalAlignment = Alignment.CenterVertically){
                        Image(
                            painter = painterResource(R.drawable.scooty),
                            contentDescription = null,
                            modifier = Modifier
                                .size(15.dp).align(Alignment.CenterVertically)
                        )
                        Text(
                            text = "Silver Altima",
                            fontSize = 10.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_medium)),
                            color = colorResource(R.color.sub_text_color),modifier=modifier.padding(start = 8.dp)
                        )

                    }

                }



            }
            SpacerHeight(20.dp)
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.white)
                ),
                border = BorderStroke(
                    width = 1.dp,
                    color = colorResource(R.color.primary_color)
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    "Continue",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(vertical = 6.dp),
                    color = colorResource(R.color.text_color),
                    fontFamily = FontFamily(Font(R.font.poppins_medium))
                )
            }


        }
        }
}

@Preview(showSystemUi = true)
@Composable
fun PairIdDriverScreenPrev(modifier: Modifier = Modifier) {
    PairIdDriverScreen()
}