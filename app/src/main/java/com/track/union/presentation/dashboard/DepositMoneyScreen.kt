package com.track.union.presentation.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.arpitkatiyarprojects.countrypicker.CountryPickerOutlinedTextField
import com.track.union.R
import com.track.union.navigation.Screen
import com.track.union.presentation.auth.CommonTopBar
import com.track.union.utils.SpacerHeight

@Composable
fun DepositMoneyScreen(navController: NavController,modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.def_bg_color))
            .padding(horizontal = 22.dp, vertical = 44.dp)
    ) {
        CommonTopBar(
            title = "Deposit Money",
            onBackClick = {navController.popBackStack()}
        )
        SpacerHeight(30.dp)
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
                    text = "Input amount",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = colorResource(R.color.heading_color),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(10.dp),
                    textAlign = TextAlign.Center
                )
                var text by remember { mutableStateOf("") }
                TextField(
                    value = text,
                    onValueChange = { newtext ->
                        text = newtext
                    },
                    placeholder = {
                        Text(
                            text = "Enter Amount",
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 14.sp,
                            color = colorResource(R.color.heading_color),modifier=modifier,
                            textAlign = TextAlign.Center
                        )
                    },
                    shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp),
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
                    ),
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        errorIndicatorColor = Color.Transparent,
                        unfocusedContainerColor = colorResource(R.color.white),
                        focusedContainerColor = colorResource(R.color.white)
                    ),
                    leadingIcon = {
                        Text(
                            text = "UGX",
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_medium)),
                            color = colorResource(R.color.heading_color),
                            modifier = Modifier.align(Alignment.CenterHorizontally).padding(start = 80.dp, end = 15.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                )
            }

        }
        SpacerHeight(30.dp)
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
                            text = "Mobile number",
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
                text = "Top Up",
                color = colorResource(R.color.white),
                fontSize = 16.sp, fontFamily = FontFamily(Font(R.font.poppins_medium))
            )
        }
        SpacerHeight(40.dp)
    }
}

@Preview(showSystemUi = true)
@Composable
fun DepositMoneyScreenPrev(modifier: Modifier = Modifier) {
    val navController= rememberNavController()
    DepositMoneyScreen(navController=navController)
}