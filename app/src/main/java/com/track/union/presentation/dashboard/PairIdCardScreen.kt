package com.track.union.presentation.dashboard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.track.union.R
import com.track.union.utils.SpacerHeight

@Composable
fun PairIdCardScreen(modifier: Modifier = Modifier) {
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
            SpacerHeight(15.dp)
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
                        "Enter Rider ID",
                        color = colorResource(R.color.hint_color),
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_regular))
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    cursorColor = colorResource(R.color.hint_color),
                    unfocusedBorderColor = colorResource(R.color.hint_color),
                    focusedBorderColor = colorResource(R.color.primary_color)
                )
            )
            SpacerHeight(30.dp)
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
                    "Pair Now",
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
fun PairIdCardScreenPrev(modifier: Modifier = Modifier) {
    PairIdCardScreen()
}