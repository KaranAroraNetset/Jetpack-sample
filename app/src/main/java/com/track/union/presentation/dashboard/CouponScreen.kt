package com.track.union.presentation.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.track.union.R
import com.track.union.presentation.auth.CommonTopBar
import com.track.union.presentation.dialog.AppSingleButtonDialog
import com.track.union.presentation.item.CouponItem
import com.track.union.presentation.model.CouponModel
import com.track.union.utils.SpacerHeight

@Composable
fun CouponScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.def_bg_color))
            .padding(horizontal = 22.dp, vertical = 44.dp)
    ) {

        //Successfully Applied Coupon Dialog

        CommonTopBar(
            title = "Coupons",
            onBackClick = {
               // showCouponAppliedDialog=true
            }
        )
        SpacerHeight(25.dp)
        val couponList = listOf(
            CouponModel(
                "20% OFF upto UGX600 for first time user",
                "Save UGX600 with this code",
                "Valid Till: 24/02/25"
            ),
            CouponModel(
                "20% OFF upto UGX600 for first time user",
                "Save UGX600 with this code",
                "Valid Till: 24/02/25"
            )
        )
        var selectedIndex by remember { mutableStateOf(0) }
        LazyColumn {
            itemsIndexed(couponList) {index, item ->
                CouponItem(
                    item = item,
                    isSelected = selectedIndex == index,
                    onSelect = { selectedIndex = index
                    }
                )
            }
        }



    }
}

@Preview(showSystemUi = true)
@Composable
fun CouponScreenPrev(modifier: Modifier = Modifier) {
    CouponScreen()
}