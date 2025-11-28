package com.track.union.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import com.track.union.base.ui.theme.UnionTheme
import com.track.union.utils.clearFocusOnTap

abstract class BaseActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnionTheme {
                Content()
            }
        }
    }

    /**
     * Override this to provide your screen content
     */
    @Composable
    protected abstract fun Content()

    /**
     * Default scrollable column with focus clearing on tap
     * Override this in child activities to customize behavior
     */
    @Composable
    protected open fun ScrollableContent(
        modifier: Modifier,
        content: @Composable ColumnScope.() -> Unit
    ) {
        val focusManager = LocalFocusManager.current

        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .clearFocusOnTap(focusManager)
        ) {
            content()
        }
    }
}
