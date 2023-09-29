package com.example.alphaspace.Model.room.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.alphaspace.Model.room.entities.StoreType
import com.example.alphaspace.Model.room.entities.User
import com.example.alphaspace.Model.room.entities.UserStoreTypeCrossRef


data class UserWithStoreTypes (
    @Embedded val user : User ,
    @Relation(
        parentColumn = "user_id",
        entityColumn = "storeType_id",
        associateBy = Junction(UserStoreTypeCrossRef::class)
    )
    val storeTypes : List<StoreType>
)