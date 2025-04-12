package com.vodafone.core.components

import androidx.annotation.RawRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.vodafone.core.R


@Composable
fun AnimatedPreloader(modifier: Modifier = Modifier,@RawRes icon:Int=R.raw.ic_weather) {
    val preloaderLottieComposition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(
           icon
        )
    )

    val preloaderProgress by animateLottieCompositionAsState(
        preloaderLottieComposition ,
        iterations = LottieConstants.IterateForever ,
        isPlaying = true
    )


    LottieAnimation(
        composition = preloaderLottieComposition,
        progress = preloaderProgress,
        modifier = modifier
    )
}