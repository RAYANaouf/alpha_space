package com.example.alphaspace.Model.room.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.alphaspace.Model.room.entities.User
import com.example.alphaspace.Model.room.relations.UserWithCategories
import com.example.alphaspace.Model.room.relations.UserWithStoreTypes

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user : User) : Long

    @Query("Select * from User ")
    suspend fun getAllUser():User

    @Query("Select * from User where google_account_id = :googleAccountId")
    suspend fun getUser(googleAccountId : String):User

    @Transaction
    @Query("Select * from User where user_id = :userId")
    suspend fun getUserWithStoreTypes(userId : Long):UserWithStoreTypes

    @Transaction
    @Query("Select * from User Where user_id = :userId")
    suspend fun getUser(userId : Int):UserWithCategories
}