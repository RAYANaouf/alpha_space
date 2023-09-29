package com.example.alphaspace.Model.room.entities

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StoreType (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "storeType_id")
    val storeTypeId : Long = 0,
    @DrawableRes
    val img : Int ,
    @StringRes
    val txt : Int
    )