package com.example.alphaspace.Model.data.categories

import com.example.alphaspace.Model.room.entities.Category
import com.example.alphaspace.R


class CategoriesDATA {
    companion object{
        val shoesStoreCategories = listOf(
            Category(name = "babies"          ,    icon = R.drawable.babies),
            Category(name = "sneakers"        ,    icon = R.drawable.sneakers),
            Category(name = "man flat_sneaker",    icon = R.drawable.flat_sneaker),
            Category(name = "man converse"    ,    icon =  R.drawable.converse),
            Category(name = "classic shoes"   ,    icon =  R.drawable.scratch_shoes),
            Category(name = "flip flops"      ,    icon =  R.drawable.flip_flops),
            Category(name = "flip flops"      ,    icon =  R.drawable.sandals),
            Category(name = "slippers"        ,    icon = R.drawable.woman_height_sandal),
            Category(name = "classic shoes"   ,    icon =  R.drawable.classic_shoes),
            Category(name = "sport shoes"     ,    icon = R.drawable.sport_sneakers),
            Category(name = "high sneakers"   ,    icon = R.drawable.high_sneakers),
            Category(name = "so high sneakers",    icon = R.drawable.so_high_sneakers),
            Category(name = "loafers"         ,    icon = R.drawable.loafers),
            Category(name = "mule"            ,    icon = R.drawable.mule)
        )

        val manClothesStoreCategories = listOf(
            Category(name = "man jeans"           ,    icon =  R.drawable.jeans_icon),
            Category(name = "man shirt"           ,    icon =  R.drawable.polo_shirt),
            Category(name = "man hawaiian_shirt"  ,    icon =  R.drawable.hawaiian_shirt),
            Category(name = "classic shoes"       ,    icon =  R.drawable.shorts),
            Category(name = "classic shoes"       ,    icon =  R.drawable.winter_gloves),
            Category(name = "man cloth"           ,    icon =  R.drawable.cloth),
            Category(name = "man hoodie"          ,    icon =  R.drawable.hoodie),
            Category(name = "man jacket"          ,    icon =  R.drawable.jacket),
            Category(name = "man tuxedo"          ,    icon =  R.drawable.tuxedo),
            Category(name = "man cap"             ,    icon =  R.drawable.cap),
            Category(name = "man belt"            ,    icon =  R.drawable.belt),
            Category(name = "man belt"            ,    icon =  R.drawable.winter_hat),
            Category(name = "man belt"            ,    icon =  R.drawable.scarf),
            Category(name = "classic shoes"       ,    icon =  R.drawable.clip),
            Category(name = "classic shoes"       ,    icon =  R.drawable.winter_gloves),
        )

    }
}