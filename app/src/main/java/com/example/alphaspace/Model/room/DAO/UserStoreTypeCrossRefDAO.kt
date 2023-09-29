package com.example.alphaspace.Model.room.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.alphaspace.Model.room.entities.UserStoreTypeCrossRef


@Dao
interface  UserStoreTypeCrossRefDAO {

    @Insert
    suspend fun insertUserStoreTypeCrossRef(userStoreTypeCrossRef: UserStoreTypeCrossRef):Long

    @Update
    suspend fun upDateUserStoreTypeCrossRef(userStoreTypeCrossRef: UserStoreTypeCrossRef):Int

    @Delete
    suspend fun deleteUserStoreTypeCrossRef(userStoreTypeCrossRef: UserStoreTypeCrossRef):Int

}