package com.example.thinkincompose.animation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.thinkincompose.R
import com.example.thinkincompose.ui.theme.low

@Composable
private fun Test(
    size: Dp = 85.dp,
    offsetX: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    text: String,
    painter: Painter,
    onClick: () -> Unit = {}
) {
    val width = with(LocalDensity.current) { size.toPx() }
    val height = with(LocalDensity.current) { size.toPx() }
    val cornerRadius = 12f

    // Hexagon points
    val pointA = Offset(width / 2, 0f)
    val pointB = Offset(width, height / 4)
    val pointC = Offset(width, height * 3 / 4)
    val pointD = Offset(width / 2, height)
    val pointE = Offset(0f, height * 3 / 4)
    val pointF = Offset(0f, height / 4)


    // Animated offsets for rectangles
    val animatableOffsetAX = remember { Animatable(pointA.x) }
    val animatableOffsetAY = remember { Animatable(pointA.y) }
    val animatableOffsetEX = remember { Animatable(pointE.x) }
    val animatableOffsetEY = remember { Animatable(pointE.y) }
    val animatableOffsetCX = remember { Animatable(pointC.x) }
    val animatableOffsetCY = remember { Animatable(pointC.y) }

    val rectWidth = with(LocalDensity.current) { 3.dp.toPx() }
    val rectHeight = with(LocalDensity.current) { 16.dp.toPx() }

    // point C
    LaunchedEffect(key1 = Unit) {
        animatableOffsetCX.animateTo(
            targetValue = pointC.x - 60f, animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 500, easing = LinearEasing
                ), repeatMode = RepeatMode.Restart
            )
        )
        animatableOffsetCX.animateTo(
            targetValue = pointA.y - 20f, animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 500, easing = LinearEasing
                ), repeatMode = RepeatMode.Restart
            )
        )
    }

    val animateXDpAsState = animateDpAsState(
        targetValue = (pointC.x - 60F).dp,
        animationSpec = tween(durationMillis = 1000),
        label = ""
    )
    val animateYDpAsState = animateDpAsState(
        targetValue = (pointA.y - 20F).dp,
        animationSpec = tween(durationMillis = 1000),
        label = ""
    )


    Column(
        modifier = Modifier.clickable {
            onClick.invoke()
        },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.size(80.dp)
        ) {
            Canvas(
                modifier = Modifier
                    .size(size)
                    .align(Alignment.Center)
                    .offset(x = offsetX, y = offsetY)
            ) {
                val path = Path().apply {
                    moveTo(pointA.x, pointA.y)
                    lineTo(pointB.x, pointB.y)
                    lineTo(pointC.x, pointC.y)
                    lineTo(pointD.x, pointD.y)
                    lineTo(pointE.x, pointE.y)
                    lineTo(pointF.x, pointF.y)
                    close()
                }

                drawIntoCanvas { canvas ->
                    canvas.drawOutline(
                        outline = Outline.Generic(path),
                        paint = Paint().apply {
                            color = Color(0xFFFFE7D6)
                            pathEffect = PathEffect.cornerPathEffect(cornerRadius)

                        })
                }
                // Point C
                withTransform({
                    translate(left = animatableOffsetCX.value, top = animatableOffsetCY.value - 4f)
                    rotate(degrees = 120f, pivot = Offset.Zero)
                }) {
                    drawRect(
                        color = Color(0xFFF8B293),
                        size = Size(rectWidth, rectHeight),
                        topLeft = Offset.Zero
                    )
                }
            }
            Image(
                modifier = Modifier
                    .size(40.dp)
                    .align(Alignment.Center),
                painter = painter,
                contentDescription = ""
            )
        }
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = text,
            color = Color(0xFF28292D),
            style = MaterialTheme.typography.low,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun Hexagon2() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Test(
                size = 70.dp,
                text = stringResource(id = R.string.scan_pay),
                painter = painterResource(id = R.drawable.ic_scan_and_pay),
                onClick = {
                })
            Test(
                size = 70.dp,
                text = stringResource(id = R.string.scan_pay),
                painter = painterResource(id = R.drawable.ic_scan_and_pay),
                onClick = {
                }
            )
            Test(
                size = 70.dp,
                text = stringResource(id = R.string.scan_pay),
                painter = painterResource(id = R.drawable.ic_scan_and_pay),
                onClick = {
                }
            )
        }
    }
}
