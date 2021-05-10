# Compose-Circular-Progress-View

[![](https://jitpack.io/v/ayoubbk/Compose-Circular-Progress-View.svg)](https://jitpack.io/#ayoubbk/Compose-Circular-Progress-View)

CircularProgressView is an Android library that helps you to easily create a custom CircularProgressView.

<img src="/preview/infinite_progress_view_preview.gif" width="260" >&emsp;<img src="/preview/determinate-progress.gif" width="260" >&emsp;<img src="/preview/wave_animation.gif" width="260" >

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
- Infinite or Determinate progress view
- Custom color for progress and background
- Configure progress width
- Configure progress background width
- Set animation duration
- Set start delay for determinate progress view
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

**Ayoub Ben Khemis**

[![Follow me](https://img.shields.io/badge/-twitter-white?logo=twitter)](https://twitter.com/AyoubBenKhemis)
[![Medium](https://img.shields.io/badge/-medium-grey?logo=medium)](https://ayoubbenkhemis.medium.com/)

### License
    Copyright 2021 Ayoub Ben Khemis

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.