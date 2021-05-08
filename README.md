# Compose-Circular-Progress-View

[![](https://jitpack.io/v/ayoubbk/Compose-Circular-Progress-View.svg)](https://jitpack.io/#ayoubbk/Compose-Circular-Progress-View)

CircularProgressView is an Android library that helps you to easily create a custom CircularProgressView.

<img src="/preview/infinite_progress_view_preview.gif" width="260" >&emsp;<img src="/preview/determinate-progress.gif" width="260" >

## Installation
Add the jitpack.io repository:

```groovy
allprojects {
 repositories {
    jcenter()
    maven { url "https://jitpack.io" }
 }
}
```

and the dependency

```groovy
dependencies {

    implementation "com.github.ayoubbk:Compose-Circular-Progress-View:$version"
}
```

## Feature

- Custom color for progress and background
- Configure progress width
- Configure progress background width
- Animation duration
- Round or Square border
- Configure Progress direction: Left or Right


## Usage

Infinite CircularProgressView
```kotlin
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
        defaultDiameter = 80.dp
    )
}
```

Determinate CircularProgressView
```kotlin
@Composable
fun determinateProgressSample() {
    drawDeterminateProgressView(
        modifier = Modifier,
        progressColor = blue,
        progressBackgroundColor = light_blue,
        strokeWidth = 10.dp,
        strokeBackgroundWidth = 10.dp,
        progress = 80f,
        progressDirection = AnimationDirection.RIGHT,
        roundedBorder = true,
        durationInMilliSecond = 5000,
        startDelay = 1000,
        radius = 80.dp
    )
}
```

## Developed By

[![Follow me](https://img.shields.io/badge/-twitter-white?logo=twitter)](https://twitter.com/AyoubBenKhemis)