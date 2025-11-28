package com.track.union.presentation.dashboard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.track.union.R
import com.track.union.presentation.item.CancelRideItem
import com.track.union.presentation.item.PaymentMethodItem
import com.track.union.presentation.model.CancelRideModel
import com.track.union.utils.SpacerHeight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CancelRideCardScreen(
    modifier: Modifier = Modifier, showSheet: Boolean,
    onDismiss: () -> Unit, sheetState: SheetState
) {
    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = {},
            sheetState = sheetState,
            shape = RoundedCornerShape(topStart = 22.dp, topEnd = 22.dp),
            dragHandle = null
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
                SpacerHeight(18.dp)

                Text(
                    text = "Cancel Ride",
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    color = colorResource(R.color.card_text_color)
                )
                SpacerHeight(20.dp)
                Text(
                    text = "Why do you want to cancel?  ",
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = colorResource(R.color.heading_color),
                    modifier = Modifier.align(Alignment.Start).padding(start = 15.dp)
                )
                SpacerHeight(18.dp)
                val cancelItemList = listOf(CancelRideModel("I don’t need this journey."),

                    CancelRideModel("I want to change the details of the\n" +
                            "journey."),
                    CancelRideModel("The driver took too long to be\n" +
                            "appointed."),
                    CancelRideModel("Other")
                    )
                var selectedIndex by remember { mutableStateOf(1) }
                LazyColumn {
                    itemsIndexed(cancelItemList) { index, item ->
                        CancelRideItem (
                            item = item,
                            isSelected = selectedIndex == index,
                            onSelect = {
                                selectedIndex = index
                            }
                        )
                    }
                }
                SpacerHeight(20.dp)
                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 7.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {
                        },
                        modifier = Modifier
                            .background(Color.White)
                            .weight(1f)
                            .height(55.dp)
                            .padding(end = 15.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.white)
                        ), border = BorderStroke(
                            width = 1.dp,
                            color = colorResource(R.color.primary_color)
                        ),

                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            "Cancel",
                            fontSize = 16.sp,
                            modifier = Modifier.padding(6.dp),
                            color = colorResource(R.color.heading_color),
                            fontFamily = FontFamily(Font(R.font.poppins_medium))
                        )
                    }
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .weight(1f)
                            .height(55.dp)
                            .padding(start = 15.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.primary_color)
                        ),

                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            "Confirm",
                            fontSize = 16.sp,
                            modifier = Modifier.padding(vertical = 6.dp),
                            color = colorResource(R.color.white),
                            fontFamily = FontFamily(Font(R.font.poppins_medium))
                        )
                    }

                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
fun CancelRideCardScreenPrev(modifier: Modifier = Modifier) {
    val previewSheetState = remember {
        SheetState(
            skipPartiallyExpanded = true,
            density = androidx.compose.ui.unit.Density(1f),
            initialValue = SheetValue.Expanded,
            confirmValueChange = { true },
            skipHiddenState = false
        )
    }

    CancelRideCardScreen(
        showSheet = true, onDismiss = {},
        sheetState = previewSheetState
    )
}