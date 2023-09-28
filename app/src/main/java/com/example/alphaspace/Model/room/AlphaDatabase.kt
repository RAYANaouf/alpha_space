package com.example.alphaspace.Model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.alphaspace.Model.room.DAO.CategoryDAO
import com.example.alphaspace.Model.room.DAO.UserDAO
import com.example.alphaspace.Model.room.entities.Category
import com.example.alphaspace.Model.room.entities.User
import com.example.alphaspace.Model.room.entities.UserCategoryCrossRef

@Database(entities = [Category::class , User::class , UserCategoryCrossRef::class ] ,  version = 1, exportSchema = false)
abstract class AlphaDatabase : RoomDatabase() {

    abstract fun getCategoryDao(): CategoryDAO
    abstract fun getUserDao(): UserDAO

    companion object {

        @Volatile
        private var Instance: AlphaDatabase? = null

        fun getDatabase(context : Context) : AlphaDatabase{
            return Instance ?: synchronized(this){
                if (Instance == null){
                    Room.databaseBuilder(context , AlphaDatabase::class.java , "alphav1.3")
                        .build()
                        .also {
                            Instance = it
                        }
                }
                else{
                    Instance!!
                }
            }
        }
    }
}