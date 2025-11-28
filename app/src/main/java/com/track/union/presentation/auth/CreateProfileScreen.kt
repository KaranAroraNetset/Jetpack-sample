package com.track.union.presentation.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
import com.arpitkatiyarprojects.countrypicker.CountryPickerOutlinedTextField
import com.track.union.R
import com.track.union.navigation.Screen
import com.track.union.utils.SpacerHeight
import kotlinx.coroutines.launch

@Composable
fun CreateProfileScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.def_bg_color))
            .padding(horizontal = 22.dp, vertical = 44.dp)
    ) {
        CommonTopBar(
            title = "Create Your Profile",
            onBackClick = { navController.popBackStack() }
        )
        SpacerHeight(25.dp)
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter) {
            Box(
                contentAlignment = Alignment.BottomEnd,
                modifier = Modifier.size(120.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.profile_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                )

                Image(
                    painter = painterResource(R.drawable.image_edit_icon),
                    contentDescription = "Edit",
                    modifier = Modifier
                        .size(35.dp)
                        .clip(CircleShape)
                )
            }
        }
        SpacerHeight(25.dp)
        var name by remember { mutableStateOf("") }
        OutlinedTextField(
            value = name,
            onValueChange = { newtext ->
                name = newtext
            }, modifier = modifier.fillMaxWidth(), shape = RoundedCornerShape(10.dp),
            placeholder = {
                Text(
                    "Enter your Full Name",
                    color = colorResource(R.color.hint_color),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_medium))
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                cursorColor =colorResource(R.color.hint_color) ,
                unfocusedBorderColor = colorResource(R.color.hint_color),
                focusedBorderColor = colorResource(R.color.primary_color)
            ),
            trailingIcon = {
                Image(
                    painter = painterResource(R.drawable.name_placeholder_icon),
                    contentDescription = null
                )
            }

        )
        SpacerHeight(25.dp)
        var email by remember { mutableStateOf("") }
        OutlinedTextField(
            value = email,
            onValueChange = { emailText ->
                email = emailText
            }, modifier = modifier.fillMaxWidth(), shape = RoundedCornerShape(10.dp),
            placeholder = {
                Text(
                    "Enter your Email ( Optional)",
                    color = colorResource(R.color.hint_color),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_medium))
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                cursorColor =colorResource(R.color.hint_color) ,
                unfocusedBorderColor = colorResource(R.color.hint_color),
                focusedBorderColor = colorResource(R.color.primary_color)
            ),
            trailingIcon = {
                Image(
                    painter = painterResource(R.drawable.email_placeholder_icon),
                    contentDescription = null
                )
            }

        )
        SpacerHeight(25.dp)
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
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = colorResource(R.color.hint_color),
                focusedBorderColor = colorResource(R.color.primary_color))
        )
       Spacer(modifier=modifier.weight(1f))
        Button(
            onClick = {
                navController.navigate(Screen.CreateProfileScreen.route)
            },
            modifier = modifier.fillMaxWidth().height(55.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.button_bg_color))
        ) {
            Text(
                text = "Create an Account",
                color = colorResource(R.color.white),
                fontSize = 16.sp, fontFamily = FontFamily(Font(R.font.poppins_medium))
            )
        }
        SpacerHeight(40.dp)


    }
}

@Preview(showSystemUi = true)
@Composable
fun CreateProfileScreenPrev(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    CreateProfileScreen(navController = navController)

}