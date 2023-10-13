package com.example.alphaspace.screens.mainScreens.profileScreen.component.common

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alphaspace.Model.data.categories.CategoriesDATA
import com.example.alphaspace.Model.room.entities.Category
import com.example.alphaspace.Model.room.entities.StoreType
import com.example.alphaspace.R
import com.example.alphaspace.screens.common.category.CategoryHolder
import com.example.alphaspace.screens.mainScreens.profileScreen.component.slots.stage2_slot

@Composable
fun CategoryStage( storeType : StoreType) {

    val categories : List<Category> = when(storeType.txt){

        R.string.shoes_Store   ->{ CategoriesDATA.shoesStoreCategories }
        R.string.man_clothes   ->{ CategoriesDATA.manClothesStoreCategories }
        R.string.women_clothes ->{ CategoriesDATA.shoesStoreCategories }
        R.string.glasses_store ->{ CategoriesDATA.shoesStoreCategories }
        R.string.sport_clothes ->{ CategoriesDATA.shoesStoreCategories }
        R.string.watch_store   ->{ CategoriesDATA.shoesStoreCategories }
        else -> { listOf() }
    }

    stage2_slot(img = storeType.img){
        LazyVerticalGrid(
            columns =  GridCells.Adaptive(80.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .heightIn(max = 300.dp)
        ){
            items(categories){category->
                CategoryHolder(category = category)
            }
        }
    }
}

@Preview
@Composable
fun CategoryStage_preview() {
    CategoryStage(
        StoreType(img = R.drawable.shoes , txt = R.string.shoes_Store )
    )
}