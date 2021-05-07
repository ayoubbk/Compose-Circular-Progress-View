package com.bks.circularporgressview

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bks.circularporgressview.ui.theme.blue
import com.bks.circularporgressview.ui.theme.light_blue

/**
 * A determinate circular progress that represents progress by drawing an arc from 0.0
 * to 360.0 degrees
 *
 * @param progressColor The color of the progress
 * @param progressBackgroundColor The background color of the progress
 * @param strokeWidth The progress stroke width
 * @param strokeBackgroundWidth The progress background stroke width
 * @param progress The progress value, float range from 0.0 to 100.0
 * @param progressDirection The progress direction
 * @param roundedBorder Determine whether the progress border is rounded or squared
 *
 */
@Composable
fun drawDeterminateProgressView(
    modifier: Modifier = Modifier,
    progressColor: Color = blue,
    progressBackgroundColor: Color = light_blue,
    strokeWidth: Dp = 10.dp,
    strokeBackgroundWidth: Dp = 5.dp,
    progress: Float = 90f,
    progressDirection: AnimationDirection = AnimationDirection.RIGHT,
    roundedBorder: Boolean = true,
    durationInMilliSecond: Int = 2000,
    startDelay: Int = 1000,
    radius: Dp = 80.dp
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

    val progress by transition.animateFloat(
        transitionSpec = {
            tween(
                durationMillis = durationInMilliSecond,
                easing = LinearEasing,
                delayMillis = startDelay
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


    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(radius * 2)
    ) {
        Canvas(
            modifier.size(radius * 2)
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
            val sweep = progress * 360 / 100

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
                sweepAngle = sweep,
                useCenter = false,
                topLeft = topLeft,
                size = size,
                style = stroke
            )
        }
        
        Text(
            text = progress.toInt().toString(),
            color = progressColor,
            fontSize = radius.value.sp / 2,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Monospace,
            style = typography.subtitle1
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