package com.example.alphaspace.screens.mainScreens.profileScreen.component.sideCards.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alphaspace.screens.mainScreens.profileScreen.component.common.HashtagHolder

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BrandsCard(
    modifier: Modifier = Modifier
        .height(44.dp)
        .fillMaxWidth(0.8f),
    hashtags : List<String> = listOf("Nike" , "Lacoste" , "kapa" , "prada" , "puma","Nike" , "Lacoste" , "kapa" , "prada" , "puma","Nike" , "Lacoste" , "kapa" , "prada" , "puma")
) {
    LazyHorizontalStaggeredGrid(
        horizontalItemSpacing = 14.dp,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        rows = StaggeredGridCells.Fixed(2),
        modifier = modifier
    ){
        items(hashtags){hashtag->
            HashtagHolder(
                modifier = Modifier.paddingFromBaseline(top = 24.dp , bottom = 12.dp),
                text = "$hashtag"
            )
        }
    }
}

@Preview
@Composable
fun BrandsCard_preview() {
    TargetTypeCard()
}