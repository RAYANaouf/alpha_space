package com.example.alphaspace.Model.data.storeTypes

import com.example.alphaspace.Model.room.entities.StoreType
import com.example.alphaspace.R

object allStoreTypes {

    val storeType : List<StoreType> = listOf(
        StoreType(img = R.drawable.shoes , txt = R.string.shoes_Store),
        StoreType(img = R.drawable.man_clothes , txt = R.string.man_clothes),
        StoreType(img = R.drawable.women_clothes , txt = R.string.women_clothes),
        StoreType(img = R.drawable.sport_clothes , txt = R.string.sport_clothes),
        StoreType(img = R.drawable.watch , txt = R.string.watch_store),
        StoreType(img = R.drawable.glasses , txt = R.string.glasses_store),


        )
}