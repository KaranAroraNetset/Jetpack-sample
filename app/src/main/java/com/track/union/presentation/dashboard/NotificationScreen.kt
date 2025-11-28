package com.track.union.presentation.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.track.union.R
import com.track.union.presentation.item.NotificationItem
import com.track.union.presentation.model.NotificationModel
import com.track.union.utils.SpacerHeight
import com.track.union.utils.noRippleClickable

@Composable
fun NotificationScreen(navController: NavController,modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.white)).padding(vertical = 44.dp)

    ) {
        Row(
            modifier = modifier.fillMaxWidth().padding(horizontal = 22.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.back_arrow_icon),
                contentDescription = null,
                modifier = modifier
                    .size(20.dp)
                    .noRippleClickable { navController.popBackStack()}
            )
            Text(
                text = "Notification",
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                fontSize = 18.sp,
                color = colorResource(R.color.heading_color)

            )
            Text(
                text = "Clear all",
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                fontSize = 10.sp,
                color = colorResource(R.color.white),
                modifier = modifier.background(
                    color = colorResource(R.color.primary_color),
                    shape = RoundedCornerShape(10.dp)
                ).padding(horizontal = 10.dp, vertical = 1.dp)

            )
        }
        SpacerHeight(30.dp)
        val notificationList= listOf(
            NotificationModel(
            "Wallet Amount",
            "INR 60.0 debited successfully from wallet for \n" + "booking!",
            "11:03PM",
            "2023-08-23,"
        ),
            NotificationModel(
                "Wallet Amount",
                "INR 60.0 debited successfully from wallet for \n" +"booking!",
                "10:53AM",
                "2025-09-19,"
            ),NotificationModel(
                "Wallet Amount",
                "INR 60.0 debited successfully from wallet for \n" + "booking!",
                "04:53AM",
                "2018-03-05,"
            )
        )
        LazyColumn {
            items(notificationList){item->
                NotificationItem(item=item)

            }
        }
    }
}

@Composable
fun NoNotificationScreen(modifier: Modifier = Modifier) {
    Column (modifier=Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(R.drawable.no_trip_found_icon),
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
        )
        SpacerHeight(10.dp)
        Text(
            text = "No Notification Available Yet",
            fontSize = 21.sp,
            fontFamily = FontFamily(Font(R.font.poppins_medium)),
            color = colorResource(R.color.heading_color),
            modifier = Modifier
        )
        SpacerHeight(10.dp)
        Text(
            text = "Stay Updated, Ride On!!!",
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            color = colorResource(R.color.heading_color),
            modifier = Modifier
        )
        Spacer(modifier = Modifier.weight(1f))
    }


}
@Preview(showSystemUi = true)
@Composable
fun NotificationScreenPrev(modifier: Modifier = Modifier) {
    val navController= rememberNavController()
   NotificationScreen(navController=navController)
  //  NoNotificationScreen()
}