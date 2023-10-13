package com.example.alphaspace.screens.fullScreen.LoadingScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.alphaspace.R

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier
) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {

        loadingAnimation(
            Modifier
        )

    }
}


@Composable
fun loadingAnimation(
    modifier: Modifier = Modifier
) {
    /************ lottie composition ***************/
    val lottieComposition by
    rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.loading_animation)
    )

    var isPlaying by remember{
        mutableStateOf(true)
    }

    val progress by
    animateLottieCompositionAsState(
        composition = lottieComposition,
        isPlaying = isPlaying,
        iterations = Int.MAX_VALUE
    )


    /************************************************/

    LottieAnimation(
        composition = lottieComposition,
        progress = {
            progress
        },
        modifier = modifier
            .fillMaxSize(0.5f)
    )

}


@Preview(widthDp = 1200 , heightDp = 800)
@Composable
fun LoadingScreen_preview() {
    LoadingScreen()
}