package com.example.thinkincompose.animation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
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
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.graphics.PathMeasure
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.rotate
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
fun AnimatedHexagonBorder(
    size: Dp = 85.dp,
    offsetX: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    color: Color,
) {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val progress by infiniteTransition.animateFloat(
        initialValue = 0f, targetValue = 1f, animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 4000, easing = LinearEasing
            ), repeatMode = RepeatMode.Restart
        ), label = ""
    )

    Canvas(
        modifier = Modifier
            .size(size)
            .offset(x = offsetX, y = offsetY)
    ) {
        val width = size.toPx()
        val height = size.toPx()

        val pointA = Offset(width / 2, 0f) // Top point
        val pointB = Offset(width, height / 4) // Top-right point
        val pointC = Offset(width, height * 3 / 4) // Bottom-right point
        val pointD = Offset(width / 2, height) // Bottom point
        val pointE = Offset(0f, height * 3 / 4) // Bottom-left point
        val pointF = Offset(0f, height / 4) // Top-left point
        val midpointAB =
            Offset((pointA.x + pointB.x) / 2, (pointA.y + pointB.y) / 2) // Midpoint of AB

        val initialPath = Path().apply {
            moveTo(pointD.x, pointD.y) // Line to point D
            lineTo(pointE.x, pointE.y) // Line to point E
            lineTo(pointF.x, pointF.y) // Line to point F
            lineTo(pointA.x, pointA.y) // Line to point A
            lineTo(midpointAB.x, midpointAB.y) // Line to midpoint AB
        }

        val pathMeasure = PathMeasure()
        pathMeasure.setPath(initialPath, false)
        val pathLength = pathMeasure.length

        val initialStrokeWidth = 0.1f
        val finalStrokeWidth = 4f
        val cornerRadius = 8f

        // Phase 1: Increase the stroke width
        val phase1EndProgress = 0.5f
        if (progress <= phase1EndProgress) {
            val phase1Progress = progress / phase1EndProgress
            val stop = pathLength * phase1Progress
            val animatedPath = Path()
            pathMeasure.getSegment(0f, stop, animatedPath, true)

            drawPath(
                path = animatedPath, color = color, style = Stroke(
                    width = lerp(initialStrokeWidth, finalStrokeWidth, phase1Progress),
                    cap = StrokeCap.Round,
                    join = StrokeJoin.Round,
                    pathEffect = PathEffect.cornerPathEffect(cornerRadius)
                )
            )
        } else {

            val phase2Progress = (progress - phase1EndProgress) / (1f - phase1EndProgress)
            val eraseLength = pathLength * phase2Progress
            val remainingPath = Path()
            pathMeasure.getSegment(eraseLength, pathLength, remainingPath, true)

            drawPath(
                path = remainingPath,
                color = color,
                style = Stroke(
                    width = finalStrokeWidth,
                    cap = StrokeCap.Round,
                    join = StrokeJoin.Round,
                    pathEffect = PathEffect.cornerPathEffect(cornerRadius)
                )
            )
            // Phase 3: Draw the hexagon based on phase2Progress
            val hexagonPath = Path().apply {
                moveTo(pointB.x, pointB.y)
                lineTo(pointC.x, pointC.y)
                lineTo(pointD.x, pointD.y)
                lineTo(pointE.x, pointE.y)
                lineTo(pointF.x, pointF.y)
                lineTo(pointA.x, pointA.y)
            }
            val hexagonMeasure = PathMeasure()
            hexagonMeasure.setPath(hexagonPath, false)
            val hexagonLength = hexagonMeasure.length
            val hexagonSegmentLength = hexagonLength * phase2Progress
            val animatedHexagonPath = Path()
            hexagonMeasure.getSegment(0f, hexagonSegmentLength, animatedHexagonPath, true)

            drawPath(
                path = animatedHexagonPath,
                color = color,
                style = Stroke(
                    width = finalStrokeWidth,
                    cap = StrokeCap.Round,
                    join = StrokeJoin.Round,
                    pathEffect = PathEffect.cornerPathEffect(cornerRadius)
                )
            )
        }
    }
}


@Composable
private fun HexagonAnimation(
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
    // point E
    LaunchedEffect(key1 = Unit) {
        animatableOffsetEX.animateTo(
            targetValue = pointE.x + 60f, animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 500, easing = LinearEasing
                ), repeatMode = RepeatMode.Restart
            )
        )

        animatableOffsetEY.animateTo(
            targetValue = pointE.y - 40f, animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 500, easing = LinearEasing
                ), repeatMode = RepeatMode.Restart
            )
        )
    }

    // point A
    LaunchedEffect(key1 = Unit) {
        animatableOffsetAY.animateTo(
            targetValue = pointA.y + 40f, animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 500, easing = LinearEasing
                ), repeatMode = RepeatMode.Restart
            )
        )
    }

    Column(
        modifier = Modifier.clickable {
            onClick.invoke()
        },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.size(80.dp)
        ) {
            AnimatedHexagonBorder(size = 80.dp, color = Color(0xFFF8B293))
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

                // point E
                withTransform({
                    translate(left = animatableOffsetEX.value + 4f, top = animatableOffsetEY.value)
                    rotate(degrees = -120f, pivot = Offset.Zero)
                }) {
                    drawRect(
                        color = Color(0xFFF8B293),
                        size = Size(rectWidth, rectHeight),
                        topLeft = Offset.Zero
                    )
                }
                // point A
                withTransform({
                    translate(left = animatableOffsetAX.value, top = animatableOffsetAY.value + 4f)
                    rotate(degrees = 0f, pivot = Offset.Zero)
                }) {
                    drawRect(
                        color = Color(0xFFF8B293),
                        size = Size(rectWidth, rectHeight),
                        topLeft = Offset.Zero
                    )
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
                modifier = androidx.compose.ui.Modifier
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

fun lerp(start: Float, stop: Float, fraction: Float): Float {
    return (start * (1 - fraction) + stop * fraction)
}



@Composable
fun ShootingStarAnimation() {
    val rectWidth = with(LocalDensity.current) { 3.dp.toPx() }
    val rectHeight = with(LocalDensity.current) { 16.dp.toPx() }
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val xOffset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 500f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 500, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ), label = ""
    )
    val yOffset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 500f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 500, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ), label = ""
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Canvas(modifier = Modifier.fillMaxSize().background(Color.Black)) {
//            drawCircle(
//                color = Color.Yellow,
//                radius = 100f,
//                center = Offset(xOffset, yOffset)
//            )

            rotate(degrees = 45F) {
                drawRect(
                    color = Color(0xFFF8B293),
                    size = Size(rectWidth, rectHeight),
                    topLeft = Offset(xOffset, yOffset)
                )
            }

        }
    }
}


@Preview
@Composable
fun Hexagon() {
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 24.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
//            HexagonAnimation(
//                size = 70.dp,
//                text = stringResource(id = R.string.scan_pay),
//                painter = painterResource(id = R.drawable.ic_scan_and_pay),
//                onClick = {
//                })
//            HexagonAnimation(
//                size = 70.dp,
//                text = stringResource(id = R.string.scan_pay),
//                painter = painterResource(id = R.drawable.ic_scan_and_pay),
//                onClick = {
//                }
//            )
//            HexagonAnimation(
//                size = 70.dp,
//                text = stringResource(id = R.string.scan_pay),
//                painter = painterResource(id = R.drawable.ic_scan_and_pay),
//                onClick = {
//                }
//            )

            ShootingStarAnimation()
        }
    }
}
