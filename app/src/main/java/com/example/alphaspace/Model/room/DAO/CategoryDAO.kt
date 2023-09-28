package com.example.alphaspace.Model.room.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.alphaspace.Model.room.entities.Category
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert( category : Category)

    @Update
    suspend fun update( category: Category)

    @Delete
    suspend fun delete( category: Category)

    @Query("SELECT * from Categories WHERE cat_id = :id")
     fun getItem(id: Int): Flow<Category>

}