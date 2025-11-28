package com.track.union.presentation.dashboard

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
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
import com.track.union.navigation.Screen
import com.track.union.presentation.auth.CommonTopBar
import com.track.union.presentation.item.HistoryItem
import com.track.union.presentation.model.HistoryModel
import com.track.union.utils.SpacerHeight

@Composable
fun TripHistoryScreen(navController: NavController,modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.def_bg_color))
            .padding(horizontal = 22.dp, vertical = 44.dp)
    ) {
        CommonTopBar(
            title = "Trip History",
            onBackClick = {navController.popBackStack()}
        )
        SpacerHeight(20.dp)
        val historyItemList = listOf(
            HistoryModel(
            "Sarah Nankinga, George Street 14, Kampala 25601, Uganda",
            "Musa Kiggundu, Village of Kisekka, Masaka 12345, Uganda",
            "12-12-2024",
            "7:48 AM",
            R.drawable.chat_image,
            "4.5",
            status = "Status: Completed",
            "UGX 5,300"
        ),
            HistoryModel(
                "Sarah Nankinga, George Street 14, Kampala 25601, Uganda",
                "Musa Kiggundu, Village of Kisekka, Masaka 12345, Uganda",
                "12-12-2024",
                "7:48 AM",
                R.drawable.profile_icon,
                "4.5",
                status = "Status: Completed",
                "UGX 5,300"
            ),
            HistoryModel(
                "Sarah Nankinga, George Street 14, Kampala 25601, Uganda",
                "Musa Kiggundu, Village of Kisekka, Masaka 12345, Uganda",
                "12-12-2024",
                "7:48 AM",
                R.drawable.profile_icon,
                "4.5",
                status = "Status: Completed",
                "UGX 5,300"
            )
        )
        LazyColumn {
            itemsIndexed(historyItemList){ index,item->
                HistoryItem(item=item, onClick = {
                    Log.d("TAG", "Clicked item at index $index")
                    navController.navigate(Screen.HistoryDetailScreen.route)
                })

            }
        }

    }
}

@Composable
fun NoTripHistoryScreen(modifier: Modifier = Modifier) {
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
            text = "No Trips Recorded Yet",
            fontSize = 21.sp,
            fontFamily = FontFamily(Font(R.font.poppins_medium)),
            color = colorResource(R.color.heading_color),
            modifier = Modifier
        )
        SpacerHeight(10.dp)
        Text(
            text = "Start Your Journey Today",
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
fun TripHistoryScreenPrev(modifier: Modifier = Modifier) {
    val navController= rememberNavController()
    TripHistoryScreen(navController=navController)
    //NoTripHistoryScreen()
}