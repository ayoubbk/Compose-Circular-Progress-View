package com.bks.circularporgressview

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bks.circularporgressview.ui.theme.blue
import com.bks.circularporgressview.ui.theme.light_blue

@Composable
fun drawDeterminateProgressView(
    modifier: Modifier = Modifier,
    progressColor: Color = blue,
    progressBackgroundColor: Color = light_blue,
    strokeWidth: Dp = 10.dp,
    strokeBackgroundWidth: Dp = 5.dp,
    progress: Float = 320f,
    progressDirection: AnimationDirection = AnimationDirection.RIGHT,
    roundedBorder: Boolean = true,
    durationInMilliSecond: Int = 2000,
    defaultDiameter: Dp = 140.dp
) {

    val stroke = with(LocalDensity.current) {
        Stroke(width = strokeWidth.toPx(), cap = if(roundedBorder) StrokeCap.Round else StrokeCap.Square)
    }

    val strokeBackground = with(LocalDensity.current) {
        Stroke(width = strokeBackgroundWidth.toPx())
    }

    val currentState = remember {
        MutableTransitionState(AnimatedArcState.START)
            .apply { targetState = AnimatedArcState.END }
    }
    val transition = updateTransition(currentState)

    val sweepAngle by transition.animateFloat(
        transitionSpec = {
            tween(
                durationMillis = durationInMilliSecond,
                easing = LinearEasing
            )
        }
    ) { state ->
        when (state) {
            AnimatedArcState.START -> 0f
            AnimatedArcState.END -> {
                when(progressDirection) {
                    AnimationDirection.RIGHT -> progress
                    AnimationDirection.LEFT -> -progress
                }
            }
        }
    }

    Canvas(
        modifier.size(defaultDiameter)
    ) {

        // tips to animated determinate progress bar : ProgressIndicatorDefaults.ProgressAnimationSpec

        val higherStrokeWidth =
            if (stroke.width > strokeBackground.width) stroke.width else strokeBackground.width
        val radius = (size.minDimension - higherStrokeWidth) / 2
        val halfSize = size / 2.0f
        val topLeft = Offset(
            halfSize.width - radius,
            halfSize.height - radius
        )
        val size = Size(radius * 2, radius * 2)

        drawArc(
            startAngle = 0f,
            sweepAngle = 360f,
            color = progressBackgroundColor,
            useCenter = false,
            topLeft = topLeft,
            size = size,
            style = strokeBackground
        )

        drawArc(
            color = progressColor,
            startAngle = 270f,
            sweepAngle = sweepAngle,
            useCenter = false,
            topLeft = topLeft,
            size = size,
            style = stroke
        )
    }

}

private enum class AnimatedArcState {
    START,
    END
}

enum class AnimationDirection {
    LEFT,
    RIGHT
}