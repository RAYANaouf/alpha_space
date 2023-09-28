package com.example.alphaspace.Model.room.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.alphaspace.Model.room.entities.Category
import com.example.alphaspace.Model.room.entities.User
import com.example.alphaspace.Model.room.entities.UserCategoryCrossRef


data class UserWithCategories (
    @Embedded val user : User,
    @Relation(
        parentColumn = "user_id" ,
        entityColumn = "cat_id" ,
        associateBy = Junction(UserCategoryCrossRef::class)
    )
    val categories : List<Category>
)