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
import com.example.alphaspace.screens.mainScreens.profileScreen.component.slots.SideCard_Slot

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductTypeCard(
    modifier: Modifier = Modifier
        .height(80.dp)
        .fillMaxWidth(0.8f),
    hashtags : List<String> = listOf("woman" , "kids" , "home" , "woman" , "kids" , "home","woman" , "kids" , "home" , "woman" , "kids" , "home")
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




/***********************    previews      *****************************/
@Preview
@Composable
fun ProductType_preview() {
    ProductTypeCard()
}

@Preview
@Composable
fun ProductType_Card_preview() {
    SideCard_Slot(title = "Product type") {
        ProductTypeCard()
    }
}
/**********************************************************************/
