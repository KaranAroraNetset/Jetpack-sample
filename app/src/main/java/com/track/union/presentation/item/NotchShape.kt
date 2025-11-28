package com.track.union.presentation.item

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class NotchShape(
    private val notchWidth: Float = 30f,
    private val notchHeight: Float = 20f,
    private val notchCenterX: Float? = null
) : Shape {
    override fun createOutline(size: Size, layoutDirection: LayoutDirection, density: Density): Outline {
        val centerX = notchCenterX ?: size.width / 2f

        val path = Path().apply {
            moveTo(0f, 0f)
            lineTo(size.width, 0f)
            lineTo(size.width, size.height - notchHeight)
            lineTo(centerX + notchWidth / 2, size.height - notchHeight)
            lineTo(centerX, size.height) // tip
            lineTo(centerX - notchWidth / 2, size.height - notchHeight)
            lineTo(0f, size.height - notchHeight)
            close()
        }
        return Outline.Generic(path)
    }
}
