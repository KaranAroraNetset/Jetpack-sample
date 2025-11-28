package com.track.union.presentation.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.track.union.R
import com.track.union.presentation.auth.CommonTopBar
import com.track.union.utils.SpacerHeight

@Composable
fun TermsConditionScreen(navController: NavController,modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.def_bg_color))
            .padding( vertical = 44.dp)
    ) {
        Column (modifier=Modifier.padding(horizontal = 22.dp)){
            CommonTopBar(
                title = "Terms & Conditions",
                onBackClick = {
                    navController.popBackStack()
                }
            )
            SpacerHeight(30.dp)
        }

        Column (modifier=Modifier.fillMaxWidth()) {


            Text(
                text = "Terms of services",
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                color = colorResource(R.color.heading_color),
                modifier = Modifier.fillMaxWidth()
                    .background(color = colorResource(R.color.terms_color)).padding(start = 15.dp)


            )
            SpacerHeight(10.dp)
            Text(
                text = "Lorem Ipsum is simply dummy text of the printing and\n" +
                        "typesetting industry. Lorem Ipsum has been the industry's\n" +
                        "standard dummy text ever since the 1500s, when an unknown\n" +
                        "printer took a galley of type and scrambled it to make a type\n" +
                        "specimen book.",
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                color = colorResource(R.color.heading_color),
                modifier = Modifier.padding(start = 15.dp)
            )
            Text(
                text = "Lorem Ipsum is simply dummy text of the printing and\n" +
                        "typesetting industry. Lorem Ipsum has been the industry's\n" +
                        "standard dummy text ever since the 1500s, when an unknown\n" +
                        "printer took a galley of type and scrambled it to make a type\n" +
                        "specimen book.",
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                color = colorResource(R.color.heading_color),
                modifier = Modifier.padding(start = 15.dp)
            )
            SpacerHeight(10.dp)
            Text(
                text = "Terms of services",
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                color = colorResource(R.color.heading_color),
                modifier = Modifier.fillMaxWidth().background(color = colorResource(R.color.terms_color)).padding(start = 15.dp)
            )

            SpacerHeight(10.dp)
            Text(
                text = "Lorem Ipsum is simply dummy text of the printing and\n" +
                        "typesetting industry. Lorem Ipsum has been the industry's\n" +
                        "standard dummy text ever since the 1500s, when an unknown\n" +
                        "printer took a galley of type and scrambled it to make a type\n" +
                        "specimen book.",
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                color = colorResource(R.color.heading_color),
                modifier = Modifier.padding(start = 15.dp)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun TermsConditionScreenPrev(modifier: Modifier = Modifier) {
    val navController= rememberNavController()
    TermsConditionScreen(navController=navController)
}