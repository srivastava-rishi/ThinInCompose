package com.example.thinkincompose.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.thinkincompose.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

// added my custom font
val blackFontFamily = FontFamily(
    Font(R.font.demo_black, FontWeight.Black),
    Font(R.font.demo_bold, FontWeight.Bold),
    Font(R.font.demo_extrabold, FontWeight.ExtraBold),
    Font(R.font.demo_extralight, FontWeight.ExtraLight),
    Font(R.font.demo_light, FontWeight.Light),
    Font(R.font.demo_regular, FontWeight.W400),
    Font(R.font.demo_medium, FontWeight.W500),
    Font(R.font.demo_semibold, FontWeight.W600),
    Font(R.font.demo_thin, FontWeight.Thin)
)

val Typography.paragraphLarge: TextStyle
    get() = TextStyle(
        fontFamily = blackFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp
    )


val Typography.paragraph: TextStyle
    get() = TextStyle(
        fontFamily = blackFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp
    )

val Typography.smallParagraph: TextStyle
    get() = TextStyle(
        fontFamily = blackFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 10.sp
    )