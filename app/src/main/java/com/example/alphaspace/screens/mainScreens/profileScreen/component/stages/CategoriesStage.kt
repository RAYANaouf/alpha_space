package com.example.alphaspace.screens.mainScreens.profileScreen.component.stages

import android.graphics.Color.parseColor
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alphaspace.Model.data.CategoriesDATA
import com.example.alphaspace.Model.types.Category
import com.example.alphaspace.R
import com.example.alphaspace.ui.theme.categoryIcons_background
import com.example.alphaspace.ui.theme.categoryIcons_border
import com.example.alphaspace.ui.theme.categoryIcons_content
import com.example.alphaspace.ui.theme.color3
import com.example.alphaspace.ui.theme.iconColor_border_p1
import com.example.alphaspace.ui.theme.iconColor_p2
import com.example.alphaspace.ui.theme.navigationRail_backgroundColor

@Composable
fun CategoriesStage(
    modifier: Modifier = Modifier,
    categories: List<Category> = CategoriesDATA.categories
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(80.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
        modifier = Modifier.height(350.dp).fillMaxWidth()
    ){
        items(categories){category->
            Category(category = category)
        }
    }
}


@Composable
fun Category(
    modifier: Modifier = Modifier,
    category: Category
) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .size(80.dp)
            .background(categoryIcons_background)
            .border(width = 2.dp, color = categoryIcons_border, shape = RoundedCornerShape(12.dp))
    ) {
        Icon(
            painter = painterResource(id = category.catIcon),
            contentDescription = "${category.categoryName} category",
            tint = categoryIcons_content,
            modifier = Modifier
                .size(50.dp)
        )
    }

}

@Preview
@Composable
fun CategoriesStage_preview() {
    CategoriesStage()
}

@Preview
@Composable
fun Category_preview() {
    Category(category = CategoriesDATA.categories[0])
}

