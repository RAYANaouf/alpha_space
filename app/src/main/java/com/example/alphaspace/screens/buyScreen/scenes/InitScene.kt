package com.example.alphaspace.screens.buyScreen.scenes

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun InitScene() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxSize()
    ) {
        
    }
}

@Composable
fun InitSceneItem() {
    
}

@Preview(widthDp = 1200 , heightDp = 800)
@Composable
fun InitScene_preview() {
    InitScene()
}

@Preview
@Composable
fun InitSceneItem_preview() {
    InitSceneItem()
}

