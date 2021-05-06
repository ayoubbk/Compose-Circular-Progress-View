# Compose-Circular-Progress-View

[![](https://jitpack.io/v/ayoubbk/Compose-Circular-Progress-View.svg)](https://jitpack.io/#ayoubbk/Compose-Circular-Progress-View)

CircularProgressView is an Android library that helps you to easily create a custom ProgressView.

<img src="/preview/infinite_progress_view_preview.mp4" width="260" >

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

- custom color for progress and background
- configure progress width
- configure progress background width
- Animation duration
- Round or Square border
- configure Progress direction: Left or Right


## Usage

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