package com.track.union.presentation.dashboard

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.track.union.R
import com.track.union.presentation.dialog.RideConfirmationDialog
import com.track.union.presentation.item.VehicleTypeItem
import com.track.union.utils.SpacerHeight
import com.track.union.utils.SpacerWidth
import com.track.union.utils.VehicleModel
import com.track.union.utils.noRippleClickable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RideConfirmationCardScreen(
    modifier: Modifier = Modifier, showSheet: Boolean,
    onDismiss: () -> Unit, sheetState: SheetState
) {
    var showDialog by remember { mutableStateOf(false) }
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

                Text(
                    text = "Estimated Fare",
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    color = colorResource(R.color.card_text_color)
                )
                SpacerHeight(20.dp)
                var selectedIndex by remember { mutableIntStateOf(0) }
                val vehicleList = listOf(
                    VehicleModel(R.drawable.scooty, "Union Boda", "10 mins ", "UGX5,300- 8,000"),
                    VehicleModel(
                        R.drawable.scooty_icon,
                        "Electric Boda",
                        "12 mins ",
                        "UGX5,300- 5,000"
                    ),
                    VehicleModel(R.drawable.car_icon, "Union Car", "14 mins ", "UGX5,300- 9,000")
                )
                LazyColumn {
                    itemsIndexed(vehicleList) { index, item ->
                        VehicleTypeItem(
                            item = item,
                            isSelected = index == selectedIndex,
                            onClick = { selectedIndex = index }
                        )
                    }
                }
                SpacerHeight(10.dp)
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
                            text = "Sarah Nankinga, George Street 14, \n" +
                                    "Kampala",
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 12.sp,
                            color = colorResource(R.color.card_text_color)
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
                            text = "Sarah Nankinga, George Street 14, \n" +
                                    "Kampala ",
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 12.sp,
                            color = colorResource(R.color.card_text_color)
                        )
                        Spacer(modifier = modifier.weight(1f))
                        Text(
                            text = "1.2 kms",
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 12.sp,
                            color = colorResource(R.color.card_text_color)
                        )

                    }
                }
                SpacerHeight(20.dp)

                Row(modifier = modifier.fillMaxWidth()) {
                    var expandedCash by remember { mutableStateOf(false) }
                    var expandedCoupon by remember { mutableStateOf(false) }
                    val arrowRotation by animateFloatAsState(targetValue = if (expandedCash) 180f else 0f)
                    val arrowRotationCoupon by animateFloatAsState(targetValue = if (expandedCoupon) 180f else 0f)
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .wrapContentHeight()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .background(
                                    color = colorResource(R.color.secondary_color),
                                    shape = RoundedCornerShape(10.dp)
                                )
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { expandedCash = !expandedCash }
                                    .padding(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.cash_icon),
                                    contentDescription = null,
                                    modifier = Modifier.size(25.dp)
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                Text(
                                    text = "Pay with Cash",
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    fontSize = 12.sp,
                                    color = colorResource(R.color.heading_color)
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                Image(
                                    painter = painterResource(R.drawable.down_arrow_icon),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(15.dp)
                                        .rotate(arrowRotation)
                                )
                                SpacerWidth(8.dp)
                            }

                            AnimatedVisibility(
                                visible = expandedCash,
                                enter = expandVertically(),
                                exit = shrinkVertically()
                            ) {
                                Text(
                                    text = "Pay Online",
                                    style = MaterialTheme.typography.bodyMedium,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 8.dp)
                                )
                            }
                        }
                    }

                    SpacerWidth(10.dp)
                    //coupon code
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .wrapContentHeight()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .background(
                                    color = colorResource(R.color.secondary_color),
                                    shape = RoundedCornerShape(10.dp)
                                )
                        ) {


                            Row(
                                modifier = modifier
                                    .background(
                                        colorResource(R.color.secondary_color),
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    .padding(5.dp)
                                    .noRippleClickable {
                                        expandedCoupon = !expandedCoupon
                                    },
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.coupon_icon),
                                    contentDescription = null,
                                    modifier = Modifier.size(25.dp)
                                )
                                Spacer(modifier = modifier.weight(1f))
                                Text(
                                    text = "No Coupon",
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    fontSize = 12.sp,
                                    color = colorResource(R.color.heading_color)
                                )
                                Spacer(modifier = modifier.weight(1f))
                                Image(
                                    painter = painterResource(R.drawable.down_arrow_icon),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(15.dp)
                                        .rotate(arrowRotationCoupon)
                                )
                                SpacerWidth(8.dp)

                            }
                            // Expandable section
                            AnimatedVisibility(
                                visible = expandedCoupon,
                                enter = expandVertically(),
                                exit = shrinkVertically()
                            ) {
                                Text(
                                    text = " No Coupon Found ",
                                    style = MaterialTheme.typography.bodyMedium,
                                    modifier = Modifier.padding(top = 8.dp)
                                )
                            }
                        }
                    }


                }
                SpacerHeight(20.dp)

                RideConfirmationDialog(
                    showDialog = showDialog,
                    onDismiss = {
                        showDialog = false
//                    context.startActivity(Intent(context, DashboardActivity::class.java))
//                    if (context is Activity) {
//                        context.finish()
//                    }
                    }
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {
                            showDialog = true
                        },
                        modifier = Modifier
                            .background(Color.White)
                            .weight(1f)
                            .height(55.dp)
                            .padding(end = 15.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.primary_color)
                        ),

                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            "Confirm",
                            fontSize = 16.sp,
                            modifier = Modifier,
                            color = colorResource(R.color.white),
                            fontFamily = FontFamily(Font(R.font.poppins_medium))
                        )
                    }


                    Button(
                        onClick = {

                        },
                        modifier = Modifier
                            .weight(1f)
                            .height(55.dp)
                            .padding(start = 15.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.white)
                        ),
                        border = BorderStroke(
                            width = 1.dp,
                            color = colorResource(R.color.primary_color)
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            "Pair",
                            fontSize = 16.sp,
                            modifier = Modifier,
                            color = colorResource(R.color.heading_color),
                            fontFamily = FontFamily(Font(R.font.poppins_medium))
                        )
                    }


                }
            }


        }
    }

}

@Composable
fun DottedLine(
    modifier: Modifier = Modifier,
    color: Color = Color.Blue,
    dotRadius: Dp = 1.dp,
    spacing: Dp = 2.dp
) {
    Canvas(
        modifier = modifier.width(2.dp)
    ) {
        val dotRadiusPx = dotRadius.toPx()
        val spacingPx = spacing.toPx()
        val totalDotHeight = dotRadiusPx * 2
        val totalSpaceHeight = totalDotHeight + spacingPx

        val dotsCount = (size.height / totalSpaceHeight).toInt()

        for (i in 0 until dotsCount) {
            val y = i * totalSpaceHeight + dotRadiusPx
            drawCircle(
                color = color,
                radius = dotRadiusPx,
                center = Offset(size.width / 2, y)
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
fun RideConfirmationCardScreenPrev(modifier: Modifier = Modifier) {
    val previewSheetState = remember {
        SheetState(
            skipPartiallyExpanded = true,
            density = androidx.compose.ui.unit.Density(1f),
            initialValue = SheetValue.Expanded,
            confirmValueChange = { true },
            skipHiddenState = false
        )
    }

    RideConfirmationCardScreen(
        showSheet = true, onDismiss = {},
        sheetState =previewSheetState
    )
}