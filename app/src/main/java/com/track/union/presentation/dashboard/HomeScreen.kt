package com.track.union.presentation.dashboard

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.location.Geocoder
import android.location.LocationManager
import android.os.Looper
import android.provider.Settings
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Circle
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.Polyline
import com.google.maps.android.compose.rememberCameraPositionState
import com.track.union.R
import com.track.union.navigation.Screen
import com.track.union.presentation.auth.AuthActivity
import com.track.union.presentation.dialog.LogoutConfirmationDialog
import com.track.union.presentation.item.RecentPlacesItem
import com.track.union.presentation.model.RecentPlacesModel
import com.track.union.utils.AppPermissions
import com.track.union.utils.SharedPrefsManager
import com.track.union.utils.SpacerHeight
import com.track.union.utils.SpacerWidth
import com.track.union.utils.clearFocusOnTap
import com.track.union.utils.noRippleClickable
import com.track.union.utils.showToast
import com.track.union.utils.visible
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import org.json.JSONObject
import java.time.format.TextStyle
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }
    val fusedLocationClient = remember {
        LocationServices.getFusedLocationProviderClient(context)
    }
    // Holds the current location and camera state
    var userLocation by remember { mutableStateOf<LatLng?>(null) }
    val cameraPositionState = rememberCameraPositionState()
    // 🔹 Request location permission (Accompanist Permissions)
    val locationPermissionState = rememberPermissionState(
        Manifest.permission.ACCESS_FINE_LOCATION
    )
    var fromText by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current
    val origin = userLocation
    val destination = LatLng(30.7466, 76.6866) // Kharar

    val googleApiKey = "AIzaSyA8FESApdFqas53CJfQQ1CP28PsKTPB1tQ"
    // Inside your composable
    var routePoints by remember { mutableStateOf<List<LatLng>>(emptyList()) }

    fun fetchCurrentLocation() {
        AppPermissions.checkLocationPermission(context) {
            val locationManager =
                context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            val isGpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
            val isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)

            if (!isGpsEnabled && !isNetworkEnabled) {
                context.startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
                return@checkLocationPermission
            }

            fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                if (location != null) {
                    try {
                        val geocoder = Geocoder(context, Locale.getDefault())
                        val addresses = geocoder.getFromLocation(location.latitude, location.longitude, 1)

                        userLocation = LatLng(location.latitude, location.longitude)

                        coroutineScope.launch {
                            cameraPositionState.animate(
                                CameraUpdateFactory.newLatLngZoom(userLocation!!, 16f)
                            )
                        }

                        fromText = if (!addresses.isNullOrEmpty()) {
                            addresses[0].getAddressLine(0) ?: ""
                        } else {
                            "Address not found"
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                        fromText = "Geocoder failed"
                    }
                } else {
                    val request = LocationRequest.Builder(
                        Priority.PRIORITY_HIGH_ACCURACY,
                        1000
                    ).setMinUpdateIntervalMillis(500).build()

                    fusedLocationClient.requestLocationUpdates(
                        request,
                        object : LocationCallback() {
                            override fun onLocationResult(result: LocationResult) {
                                fusedLocationClient.removeLocationUpdates(this)
                                val loc = result.lastLocation ?: return
                                val geocoder = Geocoder(context, Locale.getDefault())
                                val addresses = geocoder.getFromLocation(loc.latitude, loc.longitude, 1)

                                userLocation = LatLng(loc.latitude, loc.longitude)

                                coroutineScope.launch {
                                    cameraPositionState.animate(
                                        CameraUpdateFactory.newLatLngZoom(userLocation!!, 16f)
                                    )
                                }

                                fromText = if (!addresses.isNullOrEmpty()) {
                                    addresses[0].getAddressLine(0) ?: ""
                                } else {
                                    "Address not found"
                                }
                            }
                        },
                        Looper.getMainLooper()
                    )
                }
            }
        }
    }
// Decode Google polyline
    fun decodePolyline(encoded: String): List<LatLng> {
        val poly = mutableListOf<LatLng>()
        var index = 0
        val len = encoded.length
        var lat = 0
        var lng = 0

        while (index < len) {
            var b: Int
            var shift = 0
            var result = 0
            do {
                b = encoded[index++].code - 63
                result = result or (b and 0x1f shl shift)
                shift += 5
            } while (b >= 0x20)
            val dlat = if (result and 1 != 0) (result shr 1).inv() else result shr 1
            lat += dlat

            shift = 0
            result = 0
            do {
                b = encoded[index++].code - 63
                result = result or (b and 0x1f shl shift)
                shift += 5
            } while (b >= 0x20)
            val dlng = if (result and 1 != 0) (result shr 1).inv() else result shr 1
            lng += dlng

            poly.add(LatLng(lat / 1E5, lng / 1E5))
        }
        return poly
    }
// Helper function: Fetch and decode route
suspend fun fetchRoutePoints(origin: LatLng, destination: LatLng, apiKey: String): List<LatLng> {
    return withContext(Dispatchers.IO) {
        try {
            val url = "https://maps.googleapis.com/maps/api/directions/json?" +
                    "origin=${origin.latitude},${origin.longitude}" +
                    "&destination=${destination.latitude},${destination.longitude}" +
                    "&key=$apiKey"

            val client = OkHttpClient()
            val request = okhttp3.Request.Builder()
                .url(url)
                .build()

            val response = client.newCall(request).execute()
            val body = response.body?.string() ?: return@withContext emptyList()

            val json = JSONObject(body)
            val routes = json.getJSONArray("routes")
            if (routes.length() == 0) return@withContext emptyList()

            val overviewPolyline = routes.getJSONObject(0)
                .getJSONObject("overview_polyline")
                .getString("points")

            decodePolyline(overviewPolyline)
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}

    LaunchedEffect(origin, destination) {
        if (origin != null && destination != null) {
            try {
                routePoints = fetchRoutePoints(origin, destination, googleApiKey)
            } catch (e: Exception) {
                e.printStackTrace()
                routePoints = emptyList()
            }
        }
    }


    LaunchedEffect(locationPermissionState.status) {
        if (locationPermissionState.status.isGranted) {
            fetchCurrentLocation()
        } else {
            locationPermissionState.launchPermissionRequest()
        }
    }

    // 🔹 Fetch current location when permission is granted


//    var showBottomSheet by remember { mutableStateOf(true) }
//    val sheetState = rememberModalBottomSheetState(
//        skipPartiallyExpanded = true
//    )
//
//    LaunchedEffect(Unit) {
//        showBottomSheet=true
//    }
//        CancelRideCardScreen(
//            showSheet = showBottomSheet,
//            onDismiss = { }, sheetState = sheetState
//        )


    LogoutConfirmationDialog(
        showDialog = showDialog,
        onDismiss = {
            showDialog = false
        }, onPositiveButton = {
            showDialog = false
            SharedPrefsManager.setIsUserLoggedIn(false)
            context.startActivity(Intent(context, AuthActivity::class.java))
            if (context is Activity) {
                context.finish()
            }

        }
    )
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet (modifier=Modifier.width(280.dp)){
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .background(colorResource(R.color.def_bg_color))
                        .padding(horizontal = 20.dp)

                ) {
                    SpacerHeight(30.dp)
                    Image(
                        painter = painterResource(R.drawable.drawer_icon),
                        contentDescription = null,
                        modifier = Modifier.size(70.dp)
                    )
                    SpacerHeight(40.dp)
                    Text(
                        text = "John Smith",
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 20.sp,
                        color = colorResource(R.color.text_color),
                        modifier = Modifier
                    )
                    SpacerHeight(25.dp)

                    HorizontalDivider()
                    SpacerHeight(15.dp)
                    NavigationDrawerItem(
                        label = { Text("Home ") },
                        icon = {
                            Image(
                                painter = painterResource(R.drawable.drawer_home_icon),
                                contentDescription = null
                            )
                        },
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedTextColor = colorResource(R.color.heading_color),
                            selectedTextColor = colorResource(R.color.heading_color)
                        ),
                        selected = false,
                        onClick = {   scope.launch { drawerState.close() } }
                    )
                    NavigationDrawerItem(
                        label = { Text("History ") },
                        icon = {
                            Image(
                                painter = painterResource(R.drawable.drawer_history_icon),
                                contentDescription = null
                            )
                        },
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedTextColor = colorResource(R.color.heading_color),
                            selectedTextColor = colorResource(R.color.heading_color)
                        ),
                        selected = false,
                        onClick = {
                            scope.launch { drawerState.close() }
                            navController.navigate(Screen.HistoryScreen.route)
                            }
                    )
                    NavigationDrawerItem(
                        label = { Text("My Wallet ") },
                        icon = {
                            Image(
                                painter = painterResource(R.drawable.drawer_my_wallet_icon),
                                contentDescription = null
                            )
                        },
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedTextColor = colorResource(R.color.heading_color),
                            selectedTextColor = colorResource(R.color.heading_color)
                        ),
                        selected = false,
                        onClick = {
                            scope.launch { drawerState.close() }
                            navController.navigate(Screen.WalletScreen.route) }
                    )
                    NavigationDrawerItem(
                        label = { Text("Profile ") },
                        icon = {
                            Image(
                                painter = painterResource(R.drawable.drawer_profile_icon),
                                contentDescription = null
                            )
                        },
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedTextColor = colorResource(R.color.heading_color),
                            selectedTextColor = colorResource(R.color.heading_color)
                        ),
                        selected = false,
                        onClick = {
                            scope.launch { drawerState.close() }
                            navController.navigate(Screen.ProfileScreen.route) }
                    )
                    SpacerHeight(10.dp)

                    HorizontalDivider()
                    SpacerHeight(10.dp)
                    NavigationDrawerItem(
                        label = { Text("Logout ") },
                        icon = {
                            Image(
                                painter = painterResource(R.drawable.drawer_logout_icon),
                                contentDescription = null
                            )
                        },
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedTextColor = colorResource(R.color.heading_color),
                            selectedTextColor = colorResource(R.color.heading_color)
                        ),
                        selected = false,
                        onClick = {
                            scope.launch { drawerState.close() }
                            showDialog=true

                        }
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Powered by",
                            color = colorResource(R.color.powered_color),
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular))
                        )
                        SpacerWidth(8.dp)
                        Image(
                            painter = painterResource(R.drawable.ka_cyber),
                            contentDescription = null
                        )
                    }
                    SpacerHeight(10.dp)

                    Text(
                        text = "Version 1.5",
                        color = colorResource(R.color.powered_color),
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    SpacerHeight(40.dp)
                }
            }
        },
        drawerState = drawerState,
        gesturesEnabled = false
    ) {
        Scaffold(
            contentWindowInsets = WindowInsets(0, 0, 0, 0),
            topBar = {}
        ) { innerPadding ->
            // Main content of HomeScreen
            Box(modifier = modifier.fillMaxSize()) {
                GoogleMap(
                    modifier = modifier.matchParentSize(),
                    cameraPositionState = cameraPositionState,
                    properties = MapProperties(
                        isMyLocationEnabled = locationPermissionState.status.isGranted,

                        ),
                    uiSettings = MapUiSettings(
                        zoomControlsEnabled = false,
                        myLocationButtonEnabled = true
                    ),
                    onMapClick = { latLng ->
                        // Handle marker placement or clicks
                    }
                ) {
                    // Origin & destination markers
                    userLocation?.let { latLng ->
                            Circle(
                                center = latLng,
                                radius = 50.0,
                                fillColor = Color(0x5500FF00),
                                strokeColor = Color.Green,
                                strokeWidth = 2f
                            )
                        }
                    // Origin & destination markers
                    userLocation?.let { latLng ->
                        Marker(
                            state = MarkerState(position = latLng),
                            snippet = "Your Location"
                        )
                    }

                    Marker(
                        state = MarkerState(position = destination),
                        snippet = "Kharar"
                    )
                    // Route polyline
                    if (routePoints.isNotEmpty()) {
                        Polyline(
                            points = routePoints,
                            color = Color.Blue,
                            width = 8f
                        )
                    }
                }


                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(innerPadding)
                        .padding(
                            top = 44.dp,
                            // top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding() + 34.dp
                        )
                ) {
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(horizontal = 22.dp
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(R.drawable.drawer_menu_icon),
                            contentDescription = "Menu",
                            modifier = modifier
                                .size(35.dp)
                                .clickable {
                                    scope.launch { drawerState.open() }
                                }
                        )

                        Image(
                            painter = painterResource(R.drawable.notification_icon),
                            contentDescription = "Notifications",
                            modifier = modifier.padding(top = 20.dp).size(35.dp).noRippleClickable{
                                navController.navigate(Screen.NotificationScreen.route)
                            }
                        )
                    }
                    Spacer(modifier = modifier.weight(1f))
                    Card(
                        shape = RoundedCornerShape(topStart = 22.dp, topEnd = 22.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(colorResource(R.color.def_bg_color))
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            SpacerHeight(10.dp)
                            Image(
                                painter = painterResource(R.drawable.home_indicator),
                                contentDescription = null,
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            )
                            SpacerHeight(15.dp)

                            Text(
                                text = "Find Your Ride",
                                fontSize = 20.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                color = colorResource(R.color.card_text_color)
                            )
                            SpacerHeight(20.dp)
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
//                                        navController.navigate(Screen.SelectLocationScreen.route)
                                    }
                            ) {
                                OutlinedTextField(
                                    value = fromText,
                                    onValueChange = { newtext ->
                                        fromText = newtext
                                    },
                                    modifier = modifier.fillMaxWidth(),
                                    shape = RoundedCornerShape(10.dp),
                                    placeholder = {
                                        Text(
                                            "From",
                                            color = colorResource(R.color.hint_color),
                                            fontSize = 16.sp,
                                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                            maxLines = 1,
                                            overflow = TextOverflow.Ellipsis   // ✅ works here
                                        )
                                    },
                                    colors = OutlinedTextFieldDefaults.colors(
                                        cursorColor = colorResource(R.color.hint_color),
                                        unfocusedBorderColor = colorResource(R.color.hint_color),
                                        focusedBorderColor = colorResource(R.color.primary_color)
                                    ),
                                    trailingIcon = {
                                        Image(
                                            painter = painterResource(R.drawable.from_trailing_icon),
                                            contentDescription = null
                                        )
                                    },
                                    leadingIcon = {
                                        Image(
                                            painter = painterResource(R.drawable.from_leading_icon),
                                            contentDescription = null
                                        )
                                    },
                                    maxLines = 1,
                                    singleLine = true,
                                    textStyle = androidx.compose.ui.text.TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    )


                                )
                            }
                            SpacerHeight(10.dp)
                            var toText by remember { mutableStateOf("") }
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        //navController.navigate(Screen.SelectLocationScreen.route)
                                    }
                            ) {
                                OutlinedTextField(
                                    value = toText,
                                    onValueChange = { newtext ->
                                        toText = newtext
                                    },
                                    modifier = modifier.fillMaxWidth(),
                                    shape = RoundedCornerShape(10.dp),
                                    enabled = false,
                                    placeholder = {
                                        Text(
                                            "To",
                                            color = colorResource(R.color.hint_color),
                                            fontSize = 16.sp,
                                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                            maxLines = 1,
                                            overflow = TextOverflow.Ellipsis
                                        )
                                    },
                                    colors = OutlinedTextFieldDefaults.colors(
                                        cursorColor = colorResource(R.color.hint_color),
                                        unfocusedBorderColor = colorResource(R.color.hint_color),
                                        focusedBorderColor = colorResource(R.color.primary_color)
                                    ),
                                    leadingIcon = {
                                        Image(
                                            painter = painterResource(R.drawable.to_leading_icon),
                                            contentDescription = null
                                        )
                                    },
                                    maxLines = 1, singleLine = true,
                                    textStyle = androidx.compose.ui.text.TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily(Font(R.font.poppins_regular)),

                                        )
                                )
                            }
                            SpacerHeight(20.dp)
                            HorizontalDivider()
                            SpacerHeight(15.dp)
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
                                            toText = selectedText // update the OutlinedTextField
                                        }
                                    )
                                }
                            }
                            Spacer(Modifier.height(30.dp))
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun DashedLineExample() {
    val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)

    val lineColor = colorResource(id = R.color.def_dotted_bg_color)

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
    ) {
        drawLine(
            color = lineColor,
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
            strokeWidth = 3f,
            pathEffect = pathEffect
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPrev() {
    val navController = rememberNavController()
    HomeScreen(
        navController = navController

    )
}
