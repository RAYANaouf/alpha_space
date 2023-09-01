package com.example.alphaspace.screens.statisticsScreen.sections

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BestCommentBox(
    modifier: Modifier = Modifier,
) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        
    ) {
        Box(
            modifier = modifier
        ) {

        }
    }
}

@Preview
@Composable
fun BestCommentBox_preview() {
    BestCommentBox()
}