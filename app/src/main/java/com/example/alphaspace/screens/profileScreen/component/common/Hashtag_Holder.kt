package com.example.alphaspace.screens.profileScreen.component.common

import android.graphics.Color.parseColor
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alphaspace.ui.theme.color4
import com.example.alphaspace.ui.theme.textColor_light

@Composable
fun HashtagHolder(
    modifier: Modifier = Modifier,
    text : String = "hashtag"
) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .drawBehind {
                drawRoundRect(
                    color = Color(parseColor("#FFCDCDCD")),
                    cornerRadius = CornerRadius(size.height),
                    style = Stroke(
                        width = 3.dp.toPx() ,
                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(5.dp.toPx(), 5.dp.toPx()))
                    )
                )
            }
    )
    {
        Text(
            text = "#${text}",
            color = textColor_light,
            modifier = Modifier
                .padding(horizontal = 8.dp , vertical = 6.dp)
        )
    }
}

@Preview
@Composable
fun HashtagHolder_preview() {
    Surface(
        color = color4
    ) {
        HashtagHolder()
    }
}

@Preview
@Composable
fun HashtagHolder_preview2() {
    Surface(
        color = color4
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            HashtagHolder()
        }
    }
}