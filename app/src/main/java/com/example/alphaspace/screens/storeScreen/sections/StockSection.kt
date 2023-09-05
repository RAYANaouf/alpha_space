package com.example.alphaspace.screens.storeScreen.sections

import android.content.ClipData.Item
import android.graphics.Color.parseColor
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alphaspace.Model.data.Categories
import com.example.alphaspace.Model.types.Category
import com.example.alphaspace.R
import com.example.alphaspace.ui.theme.CustomWhite_background
import com.example.alphaspace.ui.theme.categoryIcons_background
import com.example.alphaspace.ui.theme.categoryIcons_border
import com.example.alphaspace.ui.theme.categoryIcons_content
import com.example.alphaspace.ui.theme.color4
import com.example.alphaspace.ui.theme.color5
import com.example.alphaspace.ui.theme.iconColor_border_p1
import com.example.alphaspace.ui.theme.navigationRail_backgroundColor
import com.example.alphaspace.ui.theme.textColor1
import com.example.alphaspace.ui.theme.textColor2
import com.example.alphaspace.ui.theme.textColor3

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StockSection(
    modifier: Modifier = Modifier,
    categories : List<Category> = Categories.categories
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Surface(
            color = color4,
            shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
            border = BorderStroke(
                width = 1.dp,
                color = iconColor_border_p1,
            ),
            shadowElevation = 2.dp,
            modifier = Modifier
                .fillMaxSize(1f)
                .padding(end = 26.dp , bottom = 8.dp)
        ) {
            Column() {

                StockSectionHeader()

                LazyVerticalGrid(
                    GridCells.Adaptive(minSize = 90.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(12.dp)
                ){
                    items(categories){
                        StockSectionItem(it.catIcon)
                    }
                }

            }
        }
    }

}


@Composable
fun StockSectionHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(CustomWhite_background)
    ) {
        var search by remember {
            mutableStateOf("")
        }

        Spacer(modifier = Modifier.width(26.dp))

        Icon(
            painter = painterResource(id = R.drawable.search),
            contentDescription = "",
            tint = iconColor_border_p1,
            modifier = Modifier
                .size(25.dp)
        )

        Spacer(modifier = Modifier.width(26.dp))

        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier
                .weight(1f),
        ) {
            BasicTextField(
                value = search,
                onValueChange = { s -> search = s },
                textStyle = TextStyle(
                    color = textColor1,
                    fontSize = TextUnit(20f, TextUnitType.Sp),
                    fontWeight = FontWeight.W500
                ),
                modifier = Modifier,
                singleLine = true,
                maxLines = 1,
                cursorBrush = SolidColor(categoryIcons_content)
            )

            if (search ==""){
                Text(
                    text = "Search",
                    style = TextStyle(
                        color = textColor1,
                        fontSize = TextUnit(20f, TextUnitType.Sp),
                        fontWeight = FontWeight.W500
                    )
                )
            }

        }

        Icon(
            painter = painterResource(id = R.drawable.back),
            contentDescription = "",
            tint = iconColor_border_p1,
            modifier = Modifier
                .size(25.dp)
        )
        Spacer(modifier = Modifier.width(25.dp))
    }

    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp),
        color = iconColor_border_p1
    )

}

@Composable
fun StockSectionItem(
    @DrawableRes img : Int = R.drawable.sneakers
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(90.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(categoryIcons_background)
            .border(width = 1.dp, color = categoryIcons_border, shape = RoundedCornerShape(12.dp))
        ,
    ) {
        Image(
            painter = painterResource(id = img) ,
            contentDescription = "",
            modifier = Modifier.size(50.dp)
        )
    }
}

@Preview(widthDp = 1300 , heightDp = 700)
@Composable
fun StockSection_preview() {
    StockSection()
}

@Preview
@Composable
fun StockSectionItem_preview() {
    StockSectionItem()
}