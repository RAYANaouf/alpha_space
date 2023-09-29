package com.example.alphaspace.Model.room.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.alphaspace.Model.room.entities.StoreType


@Dao
interface StoreTypeDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addStoreType(storeType: StoreType) : Long

    @Delete
    suspend fun deleteStoreType(storeType: StoreType)

    @Update
    suspend fun updateStoreType(storeType: StoreType)

    @Query("Select * From StoreType ")
    suspend fun getAllStoreType() : List<StoreType>


    @Query("Select * From StoreType Where img = :img")
    suspend fun getStoreType(img: Int) : StoreType

    @Query("Select count(*) From StoreType Where img = :img ")
    suspend fun countStoreType(img : Int) : Int
    
}