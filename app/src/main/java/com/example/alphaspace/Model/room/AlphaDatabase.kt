package com.example.alphaspace.Model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.alphaspace.Model.room.DAO.CategoryDAO
import com.example.alphaspace.Model.room.DAO.StoreTypeDAO
import com.example.alphaspace.Model.room.DAO.UserDAO
import com.example.alphaspace.Model.room.DAO.UserStoreTypeCrossRefDAO
import com.example.alphaspace.Model.room.entities.Category
import com.example.alphaspace.Model.room.entities.StoreType
import com.example.alphaspace.Model.room.entities.User
import com.example.alphaspace.Model.room.entities.UserCategoryCrossRef
import com.example.alphaspace.Model.room.entities.UserStoreTypeCrossRef

@Database(entities = [Category::class , User::class , StoreType::class , UserCategoryCrossRef::class  , UserStoreTypeCrossRef::class] ,  version = 1, exportSchema = false)
abstract class AlphaDatabase : RoomDatabase() {

    abstract fun getCategoryDao(): CategoryDAO
    abstract fun getUserDao(): UserDAO
    abstract fun getStoreTypeDao(): StoreTypeDAO
    abstract fun getUserStoreTypeCrossRefDao() : UserStoreTypeCrossRefDAO

    companion object {

        @Volatile
        private var Instance: AlphaDatabase? = null

        fun getDatabase(context : Context) : AlphaDatabase{
            return Instance ?: synchronized(this){
                if (Instance == null){
                    Room.databaseBuilder(context , AlphaDatabase::class.java , "alphav1.5")
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