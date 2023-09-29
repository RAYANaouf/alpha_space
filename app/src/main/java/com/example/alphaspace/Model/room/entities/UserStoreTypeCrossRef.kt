package com.example.alphaspace.Model.room.entities

import androidx.room.Entity


@Entity(primaryKeys = ["user_id" , "storeType_id"])
data class UserStoreTypeCrossRef (
    val user_id : Long ,
    val storeType_id : Long
    )