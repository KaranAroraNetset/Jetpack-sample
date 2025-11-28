package com.track.union.utils

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import java.io.File

//Extension Property for Context
val context: Context
    @Composable get() = LocalContext.current
//use it like--  context.showToast("Hello") // directly use context

// For raw text Toast
fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

// For string resources Toast
fun Context.showToast(@StringRes resId: Int) {
    Toast.makeText(this, getString(resId), Toast.LENGTH_SHORT).show()
}

// Click without Ripple Effect
fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier = composed {
    clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() },
        onClick = onClick
    )
}

//Hide Keyboard on Touch outside
//Added LocalFocusManager - Gets the focus manager to control focus
//Added pointerInput modifier - Detects tap gestures on the Column
//Added detectTapGestures - When user taps anywhere, it calls focusManager.clearFocus() to hide the keyboard

fun Modifier.clearFocusOnTap(focusManager: FocusManager): Modifier = this.pointerInput(Unit) {
    detectTapGestures(onTap = {
        focusManager.clearFocus()
    })
}


// Extension function for visibility
fun Modifier.visible(isVisible: Boolean): Modifier =
    if (isVisible) this else Modifier.size(0.dp)
//
// use it like
//Box(
//Modifier
//.visible(true) // or false to hide
//.background(Color.Red)
//.size(100.dp)
//)

/** Creates a vertical Spacer with the given [height] */
@Composable
fun SpacerHeight(height: Dp) {
    Spacer(modifier = Modifier.height(height))
}

/** Creates a horizontal Spacer with the given [width] */
@Composable
fun SpacerWidth(width: Dp) {
    Spacer(modifier = Modifier.width(width))
}
// use it like
//SpacerHeight(16.dp)  instead of Spacer(modifier = Modifier.height(16.dp))

//
fun uriToFile(context: Context, uri: Uri): File {
    val inputStream = context.contentResolver.openInputStream(uri)
    val tempFile = File.createTempFile("upload", ".jpg", context.cacheDir)
    inputStream?.use { input ->
        tempFile.outputStream().use { output ->
            input.copyTo(output)
        }
    }
    return tempFile
}
