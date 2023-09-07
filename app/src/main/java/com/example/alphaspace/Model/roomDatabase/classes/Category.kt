package com.example.alphaspace.Model.roomDatabase.classes

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Categories")
data class Category (
    @PrimaryKey(autoGenerate = true)
    val id   : Int = 0 ,
    val name : String ,
    val type : String ,
    val icon  : Int
    )