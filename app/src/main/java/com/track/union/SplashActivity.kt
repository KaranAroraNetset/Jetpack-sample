package com.track.union

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.track.union.presentation.auth.AuthActivity
import com.track.union.presentation.auth.LoginScreen
import com.track.union.presentation.dashboard.DashboardActivity
import com.track.union.presentation.dashboard.HomeScreen
import com.track.union.ui.theme.UnionTheme
import com.track.union.utils.SharedPrefsManager
import com.track.union.utils.SpacerHeight
import com.track.union.utils.SpacerWidth
import com.track.union.utils.context
import kotlinx.coroutines.delay

class SplashActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnionTheme {
                SplashScreen()

            }
        }
    }
}

@Composable
fun SplashScreen(modifier: Modifier = Modifier) {
    val context= LocalContext.current
    LaunchedEffect(Unit) {
        delay(2000)

        val isLoggedIn = SharedPrefsManager.getIsUserLoggedIn()

        val intent = if (isLoggedIn == true) {
            Intent(context, DashboardActivity::class.java)
        } else {
            Intent(context, AuthActivity::class.java)
        }

        context.startActivity(intent)
        (context as? Activity)?.finish()
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(R.color.def_bg_color))
            .padding(22.dp)
    ) {
        SpacerHeight(100.dp)
        Image(
            painter = painterResource(R.drawable.union_app_icon),
            contentDescription = null,
            modifier = Modifier
                .size(180.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier=Modifier.weight(1f))
        Text(
            text = "Welcome to Union",
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            fontSize = 20.sp,
            color = colorResource(R.color.text_color)
        )
        SpacerHeight(20.dp)
        Image(painter = painterResource(R.drawable.unite_icon), contentDescription = null)
        Spacer(modifier=Modifier.weight(1f))
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

@Preview(showSystemUi = true)
@Composable
fun SplashScreenPrev(modifier: Modifier = Modifier) {
    SplashScreen()
}