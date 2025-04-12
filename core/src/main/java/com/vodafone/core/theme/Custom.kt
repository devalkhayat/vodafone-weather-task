package com.vodafone.core.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.vodafone.core.R

/**************************************************************/

data class Colors(
    val white: Color = Color(0xFFFFFFFF) ,
    val orange: Color = Color(0xFFFD9800) ,
    val black: Color = Color(0xFF000000) ,
    val gray: Color = Color(0xFFD0D5DD) ,
    val blue: Color = Color(0xFF2D4E81) ,
    val darkBlue: Color = Color(0xFF1A3662) ,

    )

val LocalColors= compositionLocalOf { Colors()  }

val MaterialTheme.colors: Colors
    @Composable @ReadOnlyComposable get() = LocalColors.current



/**************************************************************/

private val fonts= FontFamily(
    Font(R.font.inter_regular , weight = FontWeight.Normal) ,
    Font(R.font.inter_medium, weight = FontWeight.Medium) ,
    Font(R.font.inter_semibold, weight = FontWeight.SemiBold)
)

object FontSizes {

    val small: TextUnit = 14.sp
    val medium: TextUnit = 16.sp
    val large: TextUnit = 18.sp
    val xlarge: TextUnit = 28.sp
    val xxlarge: TextUnit = 58.sp
}

data class Labels(

    val degree: TextStyle = TextStyle(
        fontFamily = fonts ,
        fontWeight = FontWeight.SemiBold ,
        fontSize = FontSizes.xxlarge ,
        lineHeight = FontSizes.xxlarge ,
        letterSpacing = 0.5.sp ,
        color = Colors().white
    ),
    val status: TextStyle = TextStyle(
        fontFamily = fonts ,
        fontWeight = FontWeight.Medium ,
        fontSize = FontSizes.large ,
        lineHeight = FontSizes.large ,
        letterSpacing = 0.5.sp ,
        color = Colors().white
    ),
    val city: TextStyle = TextStyle(
        fontFamily = fonts ,
        fontWeight = FontWeight.Medium ,
        fontSize = FontSizes.medium ,
        lineHeight = FontSizes.medium ,
        letterSpacing = 0.5.sp ,
        color = Colors().white
    ),

    val header: TextStyle = TextStyle(
        fontFamily = fonts ,
        fontWeight = FontWeight.SemiBold ,
        fontSize = FontSizes.xlarge ,
        lineHeight = FontSizes.xlarge ,
        letterSpacing = 0.5.sp ,
        color = Colors().white
    ),
    val normal: TextStyle = TextStyle(
        fontFamily = fonts ,
        fontWeight = FontWeight.SemiBold ,
        fontSize = FontSizes.small ,
        lineHeight = FontSizes.small ,
        letterSpacing = 0.5.sp ,
        color = Colors().white
    )

     ,
    val formHeader: TextStyle = TextStyle(
        fontFamily = fonts ,
        fontWeight = FontWeight.SemiBold ,
        fontSize = FontSizes.xlarge ,
        lineHeight = FontSizes.xlarge ,
        letterSpacing = 0.5.sp ,
        color = Colors().orange
    ),
    val formDropDown:TextStyle =TextStyle(

        fontFamily = fonts,
        fontWeight = FontWeight.Normal,
        fontSize = FontSizes.medium,
        lineHeight = FontSizes.medium,
        letterSpacing = 0.5.sp,
        color = Colors().gray
    ),
    val formDropDownList:TextStyle =TextStyle(

        fontFamily = fonts,
        fontWeight = FontWeight.Normal,
        fontSize = FontSizes.medium,
        lineHeight = FontSizes.medium,
        letterSpacing = 0.5.sp,
        color = Colors().black
    ),
    val formButtonNormal:TextStyle =TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Normal,
        fontSize = FontSizes.large,
        lineHeight = FontSizes.large,
        letterSpacing = 0.5.sp,
        color = Colors().white
    )


)

val LocalLabels= compositionLocalOf { Labels()  }

val MaterialTheme.labels: Labels
    @Composable @ReadOnlyComposable get() = LocalLabels.current



