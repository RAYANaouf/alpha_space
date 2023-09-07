package com.example.alphaspace.Model.roomDatabase.DAO

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.alphaspace.Model.data.Categories
import com.example.alphaspace.Model.roomDatabase.classes.Category
import kotlinx.coroutines.flow.Flow

interface CategoryDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert( category : Category )

    @Update
    fun update( category: Category )

    @Delete
    fun delete( category: Category)

    @Query("SELECT * from Categories WHERE id = :id")
    fun getItem(id: Int): Flow<Categories>

}