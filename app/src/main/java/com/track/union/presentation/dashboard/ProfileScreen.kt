package com.track.union.presentation.dashboard

import android.Manifest
import android.net.Uri
import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.FileProvider
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.arpitkatiyarprojects.countrypicker.CountryPickerOutlinedTextField
import com.track.union.R
import com.track.union.navigation.Screen
import com.track.union.presentation.dialog.ConfirmationDialog
import com.track.union.utils.SpacerHeight
import com.track.union.utils.SpacerWidth
import com.track.union.utils.context
import com.track.union.utils.noRippleClickable
import com.track.union.utils.showToast
import com.track.union.utils.uriToFile
import java.io.File

@Composable
fun ProfileScreen(navController: NavController,modifier: Modifier = Modifier) {
    val context= LocalContext.current
    var showDialog by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf<String?>(null) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var tempCameraUri by remember { mutableStateOf<Uri?>(null) }
//    var userProfilePicture by remember { mutableStateOf() }


    Column(
        modifier = Modifier
            .fillMaxSize().verticalScroll(rememberScrollState())
            .background(colorResource(R.color.def_bg_color))
            .padding(horizontal = 22.dp, vertical = 44.dp)
    ) {
        val createImageUri: () -> Uri = {
            FileProvider.getUriForFile(
                context,
                "${context.packageName}.provider",
                File(context.cacheDir, "temp_photo.jpg")
            )
        }

        val cameraLauncher =
            rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) { success ->
                if (success) {
                    imageUri = tempCameraUri
                    imageUri?.let { uri ->
                        val file = uriToFile(context, uri)
//                        uploadProductImages(name = "", profilePicture = file)
                    }
                }
            }

        val galleryLauncher =
            rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
                if (uri != null) {
                    imageUri = uri
                    val file = uriToFile(context, uri)
//                    uploadProductImages(name = "", profilePicture = file)
                }
            }

        val cameraPermissions = arrayOf(Manifest.permission.CAMERA)

        val galleryPermissions = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arrayOf(Manifest.permission.READ_MEDIA_IMAGES)
        } else {
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
        }

        val permissionLauncher = rememberLauncherForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissionsMap ->
            val allGranted = permissionsMap.values.all { it }
            if (allGranted) {
                when (selectedOption) {
                    "camera" -> {
                        val uri = createImageUri()
                        tempCameraUri = uri
                        cameraLauncher.launch(uri)
                    }

                    "gallery" -> galleryLauncher.launch("image/*")
                }
            } else {
                Toast.makeText(context, "Give Permission to update Photo ", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        val permissions = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arrayOf(
                Manifest.permission.CAMERA,
                Manifest.permission.READ_MEDIA_IMAGES
            )
        } else {
            arrayOf(
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
        }

        var showDeleteAccount by remember { mutableStateOf(false) }
        ConfirmationDialog(
            showDialog = showDeleteAccount,
            onDismiss = { showDeleteAccount = false },
            onPositiveButton = {
                showDeleteAccount = false
                context.showToast("Account Deleted Successfully")
            },
            icon = R.drawable.confirmed_icon,
            title = "Delete Account",
            message = "Are you sure you want to delete the account",
            positiveButtonText = "Yes",
            negativeButtonText = "No"
        )
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
                    .clickable { navController.popBackStack() }
            )
            Text(
                text = "Profile",
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                fontSize = 18.sp,
                color = colorResource(R.color.heading_color)

            )
            Image(
                painter = painterResource(R.drawable.profile_edit_icon),
                contentDescription = null,
                modifier = modifier
                    .size(20.dp)
                    .clickable { }
            )
        }
        SpacerHeight(30.dp)
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter) {
            Box(
                contentAlignment = Alignment.BottomEnd,
                modifier = Modifier.size(120.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(  model = imageUri ?: R.drawable.profile_icon ),
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
                        .clip(CircleShape).clickable {
                            showDialog = true
                        }
                )
            }
        }
        SpacerHeight(15.dp)
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(R.drawable.star_icon),
                contentDescription = null,
                modifier = Modifier
                    .size(22.dp)
                    .align(Alignment.CenterVertically)

            )
            SpacerWidth(5.dp)
            Text(
                text = "4.9",
                fontSize = 22.sp,
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                color = colorResource(R.color.rating_text_color)
            )
        }
        SpacerHeight(15.dp)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = colorResource(R.color.terms_color),
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "John Smith",
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                color = colorResource(R.color.heading_color)
            )
            SpacerWidth(5.dp)
            Image(
                painter = painterResource(R.drawable.name_icon),
                contentDescription = null,
                modifier = Modifier
                    .size(22.dp)
                    .align(Alignment.CenterVertically)

            )

        }
        SpacerHeight(10.dp)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = colorResource(R.color.terms_color),
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "johnsmith@gmail.com",
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                color = colorResource(R.color.heading_color)
            )
            SpacerWidth(5.dp)
            Image(
                painter = painterResource(R.drawable.email_icon),
                contentDescription = null,
                modifier = Modifier
                    .size(22.dp)
                    .align(Alignment.CenterVertically)

            )

        }
        SpacerHeight(10.dp)
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
                    text = "657412300",
                    color = colorResource(R.color.heading_color),
                    fontSize = 12.sp, fontFamily = FontFamily(Font(R.font.poppins_semibold))
                )
            },
            defaultCountryCode = "UG",
            defaultPaddingValues = PaddingValues(8.dp),
            modifier = Modifier.fillMaxWidth().background(
                color = colorResource(R.color.terms_color),
                shape = RoundedCornerShape(10.dp)
            ),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                cursorColor = colorResource(R.color.hint_color),
                unfocusedBorderColor = colorResource(R.color.terms_color),
                focusedBorderColor = colorResource(R.color.terms_color)
            )
        )
        SpacerHeight(15.dp)
        Card(
            modifier = Modifier.fillMaxWidth().noRippleClickable {
                navController.navigate(Screen.PrivacyPolicy.route)
            }, colors = CardColors(
                containerColor = Color.White,
                contentColor = Color.White,
                disabledContainerColor = Color.White,
                disabledContentColor = Color.White
            ), border = BorderStroke(width = 1.dp, color = colorResource(R.color.hint_color))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 8.dp), verticalAlignment = Alignment.CenterVertically
            ) {
                SpacerWidth(10.dp)
                Image(
                    painter = painterResource(R.drawable.privacy_policy_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(42.dp)
                        .align(Alignment.CenterVertically)

                )
                SpacerWidth(15.dp)
                Text(
                    text = "Privacy policy",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    color = colorResource(R.color.heading_color)
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(R.drawable.right_arrow_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(22.dp)
                        .align(Alignment.CenterVertically)

                )
                SpacerWidth(10.dp)

            }
        }
        SpacerHeight(12.dp)
        Card(
            modifier = Modifier.fillMaxWidth().noRippleClickable {
                navController.navigate(Screen.TermsConditionScreen.route)
            }, colors = CardColors(
                containerColor = Color.White,
                contentColor = Color.White,
                disabledContainerColor = Color.White,
                disabledContentColor = Color.White
            ), border = BorderStroke(width = 1.dp, color = colorResource(R.color.hint_color))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 8.dp), verticalAlignment = Alignment.CenterVertically
            ) {
                SpacerWidth(10.dp)
                Image(
                    painter = painterResource(R.drawable.terms_service_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(42.dp)
                        .align(Alignment.CenterVertically)

                )
                SpacerWidth(15.dp)
                Text(
                    text = "Terms of services",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    color = colorResource(R.color.heading_color)
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(R.drawable.right_arrow_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(22.dp)
                        .align(Alignment.CenterVertically)

                )
                SpacerWidth(10.dp)

            }
        }
        SpacerHeight(12.dp)
        Card(
            modifier = Modifier.fillMaxWidth().noRippleClickable {
                navController.navigate(Screen.HelpSupportScreen.route)
            }, colors = CardColors(
                containerColor = Color.White,
                contentColor = Color.White,
                disabledContainerColor = Color.White,
                disabledContentColor = Color.White
            ), border = BorderStroke(width = 1.dp, color = colorResource(R.color.hint_color))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 8.dp), verticalAlignment = Alignment.CenterVertically
            ) {
                SpacerWidth(10.dp)
                Image(
                    painter = painterResource(R.drawable.help_support_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(42.dp)
                        .align(Alignment.CenterVertically)

                )
                SpacerWidth(15.dp)
                Text(
                    text = "Help & Support",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    color = colorResource(R.color.heading_color)
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(R.drawable.right_arrow_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(22.dp)
                        .align(Alignment.CenterVertically)

                )
                SpacerWidth(10.dp)

            }
        }
        SpacerHeight(12.dp)
        Card(
            modifier = Modifier.fillMaxWidth(), colors = CardColors(
                containerColor = Color.White,
                contentColor = Color.White,
                disabledContainerColor = Color.White,
                disabledContentColor = Color.White
            ), border = BorderStroke(width = 1.dp, color = colorResource(R.color.hint_color))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 8.dp), verticalAlignment = Alignment.CenterVertically
            ) {
                SpacerWidth(10.dp)
                Image(
                    painter = painterResource(R.drawable.change_language_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(42.dp)
                        .align(Alignment.CenterVertically)

                )
                SpacerWidth(15.dp)
                Text(
                    text = "Change Language",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    color = colorResource(R.color.heading_color)
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(R.drawable.right_arrow_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(22.dp)
                        .align(Alignment.CenterVertically)

                )
                SpacerWidth(10.dp)

            }
        }
        SpacerHeight(12.dp)
        Card(
            modifier = Modifier.fillMaxWidth().clickable {
                navController.navigate(Screen.PrivacyPolicy.route)
            }, colors = CardColors(
                containerColor = Color.White,
                contentColor = Color.White,
                disabledContainerColor = Color.White,
                disabledContentColor = Color.White
            ), border = BorderStroke(width = 1.dp, color = colorResource(R.color.hint_color))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 8.dp), verticalAlignment = Alignment.CenterVertically
            ) {
                SpacerWidth(10.dp)
                Image(
                    painter = painterResource(R.drawable.check_update_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(42.dp)
                        .align(Alignment.CenterVertically)

                )
                SpacerWidth(15.dp)
                Text(
                    text = "Check Update",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    color = colorResource(R.color.heading_color)
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "version 1.1",
                    fontSize = 11.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    color = colorResource(R.color.primary_color)
                )
                SpacerWidth(10.dp)

            }
        }
        SpacerHeight(12.dp)
        Card(
            modifier = Modifier.fillMaxWidth().noRippleClickable {
                showDeleteAccount = true
            }, colors = CardColors(
                containerColor = Color.White,
                contentColor = Color.White,
                disabledContainerColor = Color.White,
                disabledContentColor = Color.White
            ), border = BorderStroke(width = 1.dp, color = colorResource(R.color.hint_color))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 8.dp), verticalAlignment = Alignment.CenterVertically
            ) {
                SpacerWidth(10.dp)
                Image(
                    painter = painterResource(R.drawable.delete_account_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(42.dp)
                        .align(Alignment.CenterVertically)

                )
                SpacerWidth(15.dp)
                Text(
                    text = "Delete Account ",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    color = colorResource(R.color.alert_color)
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(R.drawable.right_arrow_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(22.dp)
                        .align(Alignment.CenterVertically)

                )
                SpacerWidth(10.dp)

            }
        }
        SpacerHeight(40.dp)

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Select Option") },
                text = {
                    Column {
                        Text(
                            "Open Camera", modifier = Modifier
                                .clickable {
                                    selectedOption = "camera"
                                    showDialog = false
                                    permissionLauncher.launch(cameraPermissions)
                                }
                                .padding(8.dp))
                        Text(
                            "Choose from gallery", modifier = Modifier
                                .clickable {
                                    selectedOption = "gallery"
                                    showDialog = false
                                    permissionLauncher.launch(galleryPermissions)
                                }
                                .padding(8.dp))
                    }
                },
                confirmButton = {
                },
                dismissButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("Cancel")
                    }
                }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ProfileScreenPrev(modifier: Modifier = Modifier) {
    val navController= rememberNavController()
    ProfileScreen(navController=navController)
}