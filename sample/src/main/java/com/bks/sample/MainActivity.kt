package com.bks.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bks.circularporgressview.AnimationDirection
import com.bks.circularporgressview.drawDeterminateProgressView
import com.bks.circularporgressview.drawInfiniteProgressView
import com.bks.circularporgressview.ui.theme.blue
import com.bks.circularporgressview.ui.theme.light_blue
import com.bks.sample.ui.theme.CircularProgressViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CircularProgressViewTheme {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                   infiniteProgressSample()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CircularProgressViewTheme {
        drawInfiniteProgressView(
            modifier = Modifier,
            progressColor = blue,
            progressBackgroundColor = light_blue,
            strokeWidth = 10.dp,
            strokeBackgroundWidth = 10.dp,
            progressDirection = AnimationDirection.RIGHT,
            roundedBorder = false,
            durationInMilliSecond = 1300,
            defaultDiameter = 80.dp
        )
    }
}

@Composable
fun infiniteProgressSample() {
    drawInfiniteProgressView(
        modifier = Modifier,
        progressColor = blue,
        progressBackgroundColor = light_blue,
        strokeWidth = 10.dp,
        strokeBackgroundWidth = 10.dp,
        progressDirection = AnimationDirection.RIGHT,
        roundedBorder = false,
        durationInMilliSecond = 1300,
        defaultDiameter = 180.dp
    )
}

@Composable
fun determinateProgressSample() {
    drawDeterminateProgressView(
        modifier = Modifier,
        progressColor = blue,
        progressBackgroundColor = light_blue,
        strokeWidth = 10.dp,
        strokeBackgroundWidth = 10.dp,
        progress = 60f,
        progressDirection = AnimationDirection.RIGHT,
        roundedBorder = false,
        durationInMilliSecond = 1300,
        defaultDiameter = 80.dp
    )
}