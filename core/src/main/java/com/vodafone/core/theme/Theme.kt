package com.vodafone.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

private val LightColorScheme = lightColorScheme(
    primary = Colors().blue,
    secondary = Colors().gray,
    tertiary = Colors().blue,
    background = Colors().white,

    )

@Composable
fun WeatherNowLaterTheme(
    darkTheme: Boolean = isSystemInDarkTheme() ,
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true ,
    content: @Composable () -> Unit
) {
    val colorScheme = LightColorScheme

    CompositionLocalProvider(
        LocalLabels provides Labels(),
        LocalColors provides Colors()
    ) {
        MaterialTheme(
            shapes = customShapes,
            content = content,
            colorScheme = colorScheme
        )
    }

}