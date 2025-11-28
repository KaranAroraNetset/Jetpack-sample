package com.track.union.presentation.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.track.union.presentation.auth.CommonTopBar
import com.track.union.presentation.item.RecentPlacesItem
import com.track.union.presentation.model.RecentPlacesModel
import com.track.union.utils.SpacerHeight

@Composable
fun SelectLocationScreen(navController: NavController, modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier
            .fillMaxSize().background(colorResource(R.color.def_bg_color))
            .padding(horizontal = 22.dp, vertical = 44.dp)
    ) {
        CommonTopBar(
            title = "Search PickUp Location",
            onBackClick = { navController.popBackStack() }
        )
        SpacerHeight(30.dp)
        var text by remember { mutableStateOf("") }
        OutlinedTextField(
            value = text,
            onValueChange = { newtext ->
                text = newtext
            },
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            placeholder = {
                Text(
                    "Search Your Location",
                    color = colorResource(R.color.hint_color),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular))
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                cursorColor = colorResource(R.color.hint_color),
                unfocusedBorderColor = colorResource(R.color.hint_color),
                focusedBorderColor = colorResource(R.color.primary_color)
            ),
            maxLines = 1
        )
        SpacerHeight(25.dp)
        Text(
            text = "Recent places",
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.poppins_medium)),
            color = colorResource(R.color.card_text_color),
            modifier = modifier.align(Alignment.Start)
        )
        SpacerHeight(10.dp)
        val recentPlacesList = listOf(
            RecentPlacesModel("Office"),
            RecentPlacesModel("Home")
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(recentPlacesList) { item ->
                RecentPlacesItem(
                    item = item,
                    onItemClick = { selectedText ->
                        text = selectedText // update the OutlinedTextField
                    }
                )
            }
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun SelectLocationPrev(modifier: Modifier = Modifier) {
    val navController= rememberNavController()
    SelectLocationScreen(navController=navController)

}