package com.example.alphaspace.Model.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Categories")
data class Category (
    @PrimaryKey(autoGenerate = true)
    val cat_id   : Int = 0 ,
    val name : String ,
    val type : String ,
    val icon  : Int ,
)