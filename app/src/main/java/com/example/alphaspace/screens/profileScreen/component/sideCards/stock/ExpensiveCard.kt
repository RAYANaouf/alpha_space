package com.example.alphaspace.screens.profileScreen.component.sideCards.stock

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alphaspace.Model.types.Product
import com.example.alphaspace.R

@Composable
fun ExpensiveCard(
    modifier: Modifier = Modifier,
    ExpensiveItems : List<Product> = listOf(
        Product(),
        Product(),
        Product(),
    )
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(top = 0.dp , bottom = 6.dp),
        modifier = modifier.heightIn(max = 300.dp)
    ){
        items(ExpensiveItems){
            ExpensiveCardItem(

            )
        }
    }
}

@Composable
fun ExpensiveCardItem(modifier: Modifier = Modifier) {
    Surface(
        shadowElevation = 4.dp,
        shape = RoundedCornerShape(12.dp),
        color = Color.White,
        modifier = modifier
            .height(85.dp)
            .fillMaxWidth(1F)

    ) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.shoes2),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(130.dp)
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(6.dp)
            ) {
                Text(text = "price   :  9000DA")
                Text(text = "made in :  algeria")
            }
        }
    }
}

@Preview
@Composable
fun ExpensiveCard_preview() {
    ExpensiveCard()
}