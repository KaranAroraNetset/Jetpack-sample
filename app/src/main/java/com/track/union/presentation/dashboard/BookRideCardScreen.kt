package com.track.union.presentation.dashboard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import com.track.union.R
import com.track.union.presentation.item.NotchShape
import com.track.union.utils.SpacerHeight
import com.track.union.utils.SpacerWidth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookRideCardScreen(
    modifier: Modifier = Modifier, showSheet: Boolean,
    onDismiss: () -> Unit, sheetState: SheetState
) {
    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = {},
            sheetState = sheetState,
            shape = RoundedCornerShape(topStart = 22.dp, topEnd = 22.dp),
            dragHandle = null // Remove default handle, using your custom image
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
                Card(
                    modifier = Modifier.background(Color.White),
                    shape = RoundedCornerShape(10.dp), colors = CardDefaults.cardColors(
                        containerColor = colorResource(R.color.def_otp_bg_color)
                    )
                ) {
                    Text(
                        text = "OTP: 9887",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        color = colorResource(R.color.white),
                        modifier = Modifier.padding(vertical = 6.dp, horizontal = 8.dp)
                    )
                }
                SpacerHeight(10.dp)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Fred is arriving soon",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        color = colorResource(R.color.heading_color),
                        modifier = Modifier
                    )
                    Text(
                        text = "1 min",
                        fontSize = 11.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        color = colorResource(R.color.white),
                        modifier = Modifier
                            .background(
                                colorResource(R.color.primary_color),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(8.dp)
                    )
                }
                SpacerHeight(20.dp)
                Row(modifier = modifier.fillMaxWidth()) {
                    Image(
                        painter = painterResource(R.drawable.profile_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)

                    )
                    SpacerWidth(10.dp)
                    Column() {
                        SpacerWidth(8.dp)
                        Text(
                            text = "Fred",
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_medium)),
                            color = colorResource(R.color.heading_color)
                        )

                        Row() {
                            Image(
                                painter = painterResource(R.drawable.star_icon),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(13.dp)
                                    .align(Alignment.CenterVertically)

                            )
                            SpacerWidth(5.dp)
                            Text(
                                text = "4.9",
                                fontSize = 16.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                color = colorResource(R.color.rating_text_color)
                            )
                        }


                    }
                    Spacer(modifier = modifier.weight(1f))
                    Image(
                        painter = painterResource(R.drawable.scooty),
                        contentDescription = null,
                        modifier = Modifier
                            .size(25.dp)
                            .align(Alignment.Bottom)
                            .padding(bottom = 5.dp, end = 5.dp)
                    )
                    Column(verticalArrangement = Arrangement.SpaceBetween) {
                        Text(
                            text = "CTRLZ89",
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_medium)),
                            color = colorResource(R.color.heading_color),
                            modifier = modifier.padding(start = 8.dp)
                        )

                        SpacerHeight(5.dp)

                        Text(
                            text = "Silver Altima",
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_medium)),
                            color = colorResource(R.color.sub_text_color),
                            modifier = modifier.padding(start = 8.dp)
                        )


                    }


                }
                SpacerHeight(15.dp)
                Column {

                    Row(
                        modifier = modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(R.drawable.source_location_icon),
                            contentDescription = null,
                            modifier = modifier.size(25.dp)
                        )
                        SpacerWidth(5.dp)
                        Text(
                            text = "SSarah Nankinga, George Street 14, \n" +
                                    "Kampala 25601, Uganda",
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 12.sp,
                            color = colorResource(R.color.heading_color)
                        )
                    }

                    Row {
                        Spacer(modifier = Modifier.width(12.5.dp))
                        DottedLine(
                            modifier = Modifier.height(20.dp),
                            color = Color.Blue.copy(alpha = 0.5f)
                        )
                    }

                    Row(
                        modifier = modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(R.drawable.destination_location_icon),
                            contentDescription = null,
                            modifier = modifier.size(25.dp)
                        )
                        SpacerWidth(5.dp)
                        Text(
                            text = "Musa Kiggundu, Village of Kisekka, Masaka \n" +
                                    "12345, Uganda",
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 12.sp,
                            color = colorResource(R.color.heading_color)
                        )
                        Spacer(modifier = modifier.weight(1f))


                    }
                }
                SpacerHeight(25.dp)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    var text by remember { mutableStateOf("") }
                    TextField(
                        value = text,
                        onValueChange = { newtext ->
                            text = newtext
                        }, placeholder = {
                            Text(
                                text = "Any pickup notes?",
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                fontSize = 13.sp,
                                color = colorResource(R.color.payment_subtext_color)
                            )
                        }, shape = RoundedCornerShape(10.dp), modifier = Modifier.weight(1f),
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            errorIndicatorColor = Color.Transparent,
                            unfocusedContainerColor = colorResource(R.color.def_pick_notes_bg_color),
                            focusedContainerColor = colorResource(R.color.def_pick_notes_bg_color)
                        )
                    )
                    SpacerWidth(10.dp)
                    Image(
                        painter = painterResource(R.drawable.phone_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(45.dp), alignment = Alignment.Center

                    )
                }
                SpacerHeight(20.dp)
                //Popup Menu
                val anchorBounds = remember { mutableStateOf<androidx.compose.ui.geometry.Rect?>(null) }

                var showPopup by remember { mutableStateOf(false) }
                if (showPopup && anchorBounds.value!=null){
                    val anchor=anchorBounds.value
                    if (anchor != null) {
                        Popup (
                            onDismissRequest = {showPopup=false},
                            properties = PopupProperties(focusable = false), offset = IntOffset(
                                x = anchor.center.x.toInt() - 125, // popup centered on icon (250dp width / 2)
                                y = anchor.top.toInt() - 10        // show popup ABOVE the icon (adjust -10 for spacing)
                            )

                        ){
                            Box(
                                modifier = Modifier
                                    .width(250.dp)
                                    .wrapContentHeight()
                                    .clip(NotchShape(notchCenterX = 125f ))
                                    .background(Color.Green)

                            ) {
                                Card (modifier=Modifier.size(250.dp).background(Color.White), shape = RoundedCornerShape(10.dp)){
                                    Column(modifier = Modifier.padding(8.dp)) {
                                        Text(
                                            text = "Popup Content",
                                            modifier = Modifier
                                                .clickable {

                                                    showPopup = false
                                                }
                                                .padding(8.dp)
                                        )

                                    }

                                }

                            }
                        }
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier
                            .background(
                                colorResource(R.color.def_pick_notes_bg_color),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(5.dp)
                    ) {
                        Text(
                            text = "Payment Method:",
                            fontSize = 11.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            color = colorResource(R.color.black),
                            modifier = Modifier
                                .padding(8.dp)
                        )
                        Image(
                            painter = painterResource(R.drawable.coupon_code_icon),
                            contentDescription = null,
                            modifier = Modifier
                                .size(15.dp)
                                .align(Alignment.CenterVertically),
                            alignment = Alignment.Center,

                            )
                        Text(
                            text = "Wallet",
                            fontSize = 11.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            color = colorResource(R.color.black),
                            modifier = Modifier
                                .padding(8.dp)
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(R.drawable.error_price_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp).clickable{
                            showPopup=true
                            }.onGloballyPositioned {
                                coords->
                                anchorBounds.value=coords.boundsInWindow()
                            }, alignment = Alignment.CenterEnd

                    )
                    SpacerWidth(12.dp)
                    Column() {
                        Text(
                            text = "Price",
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            color = colorResource(R.color.payment_subtext_color),
                            modifier = Modifier.align(Alignment.CenterHorizontally)

                        )
                        Text(
                            text = "UGX5,300",
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                            color = colorResource(R.color.heading_color),
                            modifier = Modifier

                        )


                    }
                }
                SpacerHeight(20.dp)

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
                        "Cancel",
                        fontSize = 16.sp,
                        modifier = Modifier.padding(vertical = 6.dp),
                        color = colorResource(R.color.text_color),
                        fontFamily = FontFamily(Font(R.font.poppins_medium))
                    )
                }

            }


        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun BookRideCardScreenPrev(modifier: Modifier = Modifier) {
    val previewSheetState = remember {
        SheetState(
            skipPartiallyExpanded = true,
            density = androidx.compose.ui.unit.Density(1f),
            initialValue = SheetValue.Expanded,
            confirmValueChange = { true },
            skipHiddenState = false
        )
    }
    BookRideCardScreen(showSheet = true, onDismiss = {}, sheetState = previewSheetState)
}