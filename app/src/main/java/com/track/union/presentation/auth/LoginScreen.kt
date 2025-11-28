package com.track.union.presentation.auth

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.arpitkatiyarprojects.countrypicker.CountryPickerOutlinedTextField
import com.track.union.R
import com.track.union.navigation.Screen
import com.track.union.utils.SpacerHeight
import com.track.union.utils.SpacerWidth
import com.track.union.utils.clearFocusOnTap
import com.track.union.utils.context
import com.track.union.utils.showToast
import com.track.union.utils.visible

@Composable
fun LoginScreen(navController: NavController, modifier: Modifier = Modifier) {
    var mobileNumber by remember { mutableStateOf("") }
    var selectedCountryCode by remember { mutableStateOf("UG") }
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.def_bg_color))
            .padding(horizontal = 22.dp, vertical = 44.dp)
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.back_arrow_icon),
                contentDescription = null,
                modifier = modifier
                    .size(20.dp)
                    .clickable { (navController.popBackStack()) }
            )
            Text(
                text = "Get Started",
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                fontSize = 18.sp,
                color = colorResource(R.color.heading_color)

            )
            Text(
                text = "en",
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                fontSize = 18.sp,
                color = colorResource(R.color.heading_color),
                modifier = modifier.visible(false)

            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()).clearFocusOnTap(focusManager)
        ) {
            SpacerHeight(30.dp)
            Text(
                text = "Enter with your Mobile Number",
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                fontSize = 20.sp,
                color = colorResource(R.color.text_color)

            )
            SpacerHeight(25.dp)
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
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    cursorColor = colorResource(R.color.hint_color),
                    unfocusedBorderColor = colorResource(R.color.hint_color),
                    focusedBorderColor = colorResource(R.color.primary_color)
                )
            )
            SpacerHeight(40.dp)
            Button(
                onClick = {
                    navController.navigate(Screen.Verification.route)
                },
                modifier = modifier.fillMaxWidth().height(55.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.button_bg_color))
            ) {
                Text(
                    text = "Login",
                    color = colorResource(R.color.white),
                    fontSize = 16.sp, fontFamily = FontFamily(Font(R.font.poppins_medium))
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            TermsAndPolicyText(
                onTermsClick = {
                    context.showToast("Terms & Condition Clicked")
                },
                onPrivacyClick = {
                    context.showToast("Privacy policy Clicked")
                }
            )
            Row(
                modifier = modifier.fillMaxWidth().padding(bottom = 40.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Powered by",
                    color = colorResource(R.color.powered_color),
                    fontSize = 12.sp, fontFamily = FontFamily(Font(R.font.poppins_regular))
                )
                SpacerWidth(8.dp)
                Image(painter = painterResource(R.drawable.ka_cyber), contentDescription = null)

            }


        }

    }
    }
    @Composable
    fun TermsAndPolicyText(
        onTermsClick: () -> Unit,
        onPrivacyClick: () -> Unit
    ) {

        val headingColor = colorResource(R.color.primary_color)
        val subheadingColor = colorResource(R.color.proceeding_color)

        val annotatedString = buildAnnotatedString {
            append("By proceeding, I agree to the ")

            pushStringAnnotation(tag = "TERMS", annotation = "terms")
            withStyle(SpanStyle(color = headingColor, fontWeight = FontWeight.Bold)) {
                append("Terms & Conditions")
            }
            pop()

            append(" and\n")

            pushStringAnnotation(tag = "PRIVACY", annotation = "privacy")
            withStyle(SpanStyle(color = headingColor, fontWeight = FontWeight.Bold)) {
                append("Privacy Policy")
            }
            pop()

            append(".")
        }

        ClickableText(
            text = annotatedString,
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                color = subheadingColor,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp),
            onClick = { offset ->
                annotatedString.getStringAnnotations(start = offset, end = offset)
                    .firstOrNull()?.let { annotation ->
                        when (annotation.tag) {
                            "TERMS" -> onTermsClick()
                            "PRIVACY" -> onPrivacyClick()
                        }
                    }
            }
        )
    }

@Preview(showSystemUi = true)
@Composable
fun LoginScreenPrev(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    LoginScreen(navController = navController)
}