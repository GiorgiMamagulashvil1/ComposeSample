package com.gm.composesample.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.unit.sp
import com.gm.composesample.R

val georgianFontFamily = FontFamily(
    listOf(
        Font(resId = R.font.avaza_mtavruli, weight = FontWeight.Medium),
        Font(resId = R.font.bpg_nino_mtavruli_bold_3, weight = FontWeight.Bold),
        Font(resId = R.font.bpg_nino_mtavruli_bold_3, weight = FontWeight.ExtraBold),
        Font(resId = R.font.bpg_nino_mtavruli_bold_3, weight = FontWeight.SemiBold),
        Font(resId = R.font.avaza_mtavruli, weight = FontWeight.Light),
        Font(resId = R.font.avaza_mtavruli, weight = FontWeight.Normal),
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 96.sp,
        letterSpacing = (-1.5).sp,
        fontFamily = georgianFontFamily,
        textAlign = TextAlign.Center,
        textMotion = TextMotion.Animated
    ),
    displayMedium = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 85.sp,
        letterSpacing = (-1).sp,
        fontFamily = georgianFontFamily,
        textIndent = TextIndent(
            firstLine = 10.sp,
            restLine = 20.sp
        )
    ),
    displaySmall = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 75.sp,
        letterSpacing = (-0.5).sp,
        fontFamily = georgianFontFamily
    ),
    headlineLarge = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 32.sp,
        letterSpacing = 0.sp,
        background = Color.Gray,
        fontFamily = georgianFontFamily
    ),
    bodyLarge = TextStyle(
        fontWeight = FontWeight.ExtraBold,
        fontSize = 28.sp,
        fontFamily = georgianFontFamily
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 21.sp,
        fontFamily = georgianFontFamily
    ),
    bodySmall = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 21.sp,
        fontFamily = georgianFontFamily
    )
)