package com.example.animation.shapes

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
private fun RectangleUsingDefaultFunction() {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        val rectSize = 100.dp.toPx()
        drawRect(
            color = Color.White,
            size = Size(rectSize, rectSize)
        )
    }
}

@Composable
private fun RectangleUsingPathFunction() {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        val centerX = size.width / 2
        val centerY = size.height / 2
        val path = Path().apply {
            moveTo(centerX, centerY)
            lineTo(centerX, centerY + 100.dp.toPx())
            lineTo(centerX + 100.dp.toPx(), centerY + 100.dp.toPx())
            lineTo(centerX + 100.dp.toPx(), centerY)
        }
        drawPath(
            path = path,
            color = Color.White
        )
    }
}


@Preview
@Composable
fun ShapesPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        RectangleUsingPathFunction()
    }
}
