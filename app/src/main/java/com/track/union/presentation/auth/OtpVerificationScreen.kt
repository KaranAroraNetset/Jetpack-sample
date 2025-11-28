package com.track.union.presentation.auth

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mukeshsolanki.OTP_VIEW_TYPE_BORDER
import com.mukeshsolanki.OtpView
import com.track.union.R
import com.track.union.presentation.dashboard.DashboardActivity
import com.track.union.presentation.dialog.OtpVerificationDialog
import com.track.union.utils.SharedPrefsManager
import com.track.union.utils.SpacerHeight
import com.track.union.utils.SpacerWidth
import com.track.union.utils.clearFocusOnTap
import com.track.union.utils.showToast

@Composable
fun OtpVerificationScreen(navController: NavController, modifier: Modifier = Modifier) {
    var showDialog by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize().imePadding().verticalScroll(rememberScrollState()).clearFocusOnTap(focusManager)
            .background(colorResource(R.color.def_bg_color))
            .padding(horizontal = 22.dp, vertical = 44.dp)
    ) {
        CommonTopBar(
            title = "Enter 6- digit OTP",
            onBackClick = { navController.popBackStack() }
        )
        SpacerHeight(30.dp)
        Text(
            text = "Phone verification",
            fontFamily = FontFamily(Font(R.font.poppins_medium)),
            fontSize = 24.sp,
            color = colorResource(R.color.text_color),
            modifier = modifier.align(Alignment.CenterHorizontally)

        )
        SpacerHeight(15.dp)
        Text(
            text = "Enter your OTP code",
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            fontSize = 16.sp,
            color = colorResource(R.color.sub_text_color),
            modifier = modifier.align(Alignment.CenterHorizontally)

        )
        SpacerHeight(40.dp)
        var otpValue by remember { mutableStateOf("") }
        OtpView(
            otpText = otpValue,
            onOtpTextChange = {
                otpValue = it
                Log.d("Actual Value", otpValue)
            },
            type = OTP_VIEW_TYPE_BORDER,
            password = true,
            otpCount = 6,
            containerSize = 50.dp,
            containerRadius = 10.dp,
            containerColor = colorResource(R.color.hint_color),
            passwordChar = "●",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = modifier.align(Alignment.CenterHorizontally)
        )
        SpacerHeight(25.dp)
        ResendText()
        Spacer(modifier = modifier.weight(1f))
        OtpVerificationDialog(
            showDialog = showDialog,
            onDismiss = {
                showDialog = false

                SharedPrefsManager.setIsUserLoggedIn(true)
                context.startActivity(Intent(context, DashboardActivity::class.java))
                if (context is Activity) {
                    context.finish()
                }
            }
        )
        Button(
            onClick = {
                showDialog = true
            },
            modifier = modifier
                .fillMaxWidth()
                .height(55.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.button_bg_color))
        ) {
            Text(
                text = "Verify",
                color = colorResource(R.color.white),
                fontSize = 16.sp, fontFamily = FontFamily(Font(R.font.poppins_medium))
            )
        }
        SpacerHeight(25.dp)
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 40.dp),
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

@Composable
fun ResendText() {
    val headingColor = colorResource(R.color.primary_color)
    val subheadingColor = colorResource(R.color.proceeding_color)
    val context = LocalContext.current
    val annotatedString = buildAnnotatedString {
        append("Didn’t receive the OTP? ")

        pushStringAnnotation(tag = "RESEND", annotation = "resend")

        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Bold,
                color = headingColor
            )
        ) {
            append("Resend again")
        }

        pop()
    }
    ClickableText(
        text = annotatedString,
        style = androidx.compose.ui.text.TextStyle(
            fontSize = 15.sp,
            fontFamily = FontFamily(Font(R.font.poppins_medium)),
            color = subheadingColor,
            textAlign = TextAlign.Center
        ),
        modifier = Modifier.fillMaxWidth(),
        onClick = { offset ->
            annotatedString
                .getStringAnnotations(tag = "RESEND", start = offset, end = offset)
                .firstOrNull()?.let {
                    context.showToast("Resend Clicked")
                }
        }
    )
}

@Preview(showSystemUi = true)
@Composable
fun OtpVerificationScreenPrev(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    OtpVerificationScreen(navController = navController)
}