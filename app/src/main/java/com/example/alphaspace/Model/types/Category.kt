package com.example.alphaspace.Model.types

import androidx.annotation.DrawableRes


class Category {

    val categoryName : String

    @DrawableRes
    val  catIcon      : Int

    constructor(
    catName : String,
    @DrawableRes catIcon : Int
    ){
        this.categoryName = catName
        this.catIcon      = catIcon
    }
}
