package com.example.alphaspace.Model.room.entities

import androidx.room.Entity


@Entity(primaryKeys = ["user_id","cat_id"])
data class UserCategoryCrossRef (
    val user_id : Int,
    val cat_id : Int
)