package com.track.union.presentation.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.arpitkatiyarprojects.countrypicker.CountryPickerOutlinedTextField
import com.track.union.R
import com.track.union.presentation.auth.CommonTopBar
import com.track.union.utils.SpacerHeight
import com.track.union.utils.SpacerWidth

@Composable
fun PaymentScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize().verticalScroll(rememberScrollState())
            .background(colorResource(R.color.def_bg_color))
            .padding(horizontal = 22.dp, vertical = 44.dp)
    ) {
        CommonTopBar(
            title = "Payment",
            onBackClick = { }
        )
        SpacerHeight(25.dp)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = colorResource(R.color.def_pick_notes_bg_color),
                    shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
                )
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Ride Fare",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                color = colorResource(R.color.heading_color)
            )
            SpacerWidth(5.dp)
            Text(
                text = "UGX 4,500",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                color = colorResource(R.color.heading_color)
            )

        }
        SpacerHeight(10.dp)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(R.color.def_pick_notes_bg_color)
            )
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 3.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Enter mobile money number",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = colorResource(R.color.heading_color),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(10.dp),
                    textAlign = TextAlign.Center
                )
                var mobileNumber by remember { mutableStateOf("") }
                var selectedCountryCode by remember { mutableStateOf("UG") }
                CountryPickerOutlinedTextField(
                    mobileNumber = mobileNumber,
                    onMobileNumberChange = { newText ->
                        mobileNumber = newText
                    },
                    onCountrySelected = { countryCode ->
                        selectedCountryCode = countryCode.toString()
                    },
                    placeholder = {
                        Text(
                            text = "Your mobile number",
                            color = colorResource(R.color.hint_color),
                            fontSize = 16.sp, fontFamily = FontFamily(Font(R.font.poppins_medium))
                        )
                    },
                    defaultCountryCode = "UG",
                    defaultPaddingValues = PaddingValues(8.dp),
                    modifier = Modifier.fillMaxWidth().background(color = Color.White),
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        cursorColor =colorResource(R.color.hint_color) ,
                        unfocusedBorderColor = colorResource(R.color.white),
                        focusedBorderColor = colorResource(R.color.white))
                )
            }

        }
        Spacer(modifier=modifier.weight(1f))
        Button(
            onClick = {
            },
            modifier = modifier.fillMaxWidth().height(55.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.button_bg_color))
        ) {
            Text(
                text = "Pay",
                color = colorResource(R.color.white),
                fontSize = 16.sp, fontFamily = FontFamily(Font(R.font.poppins_medium))
            )
        }
        SpacerHeight(40.dp)

    }
}

@Preview(showSystemUi = true)
@Composable
fun PaymentScreenPrev(modifier: Modifier = Modifier) {
    PaymentScreen()
}