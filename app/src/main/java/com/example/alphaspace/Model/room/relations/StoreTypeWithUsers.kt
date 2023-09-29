package com.example.alphaspace.Model.room.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.alphaspace.Model.room.entities.StoreType
import com.example.alphaspace.Model.room.entities.User
import com.example.alphaspace.Model.room.entities.UserStoreTypeCrossRef


data class StoreTypeWithUsers (
    @Embedded val storeType: StoreType,
    @Relation(
        parentColumn = "storeType_id",
        entityColumn = "user_id",
        associateBy = Junction(UserStoreTypeCrossRef::class)
    )
    val users : List<User>
    )