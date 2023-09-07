package com.example.alphaspace.Model.roomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.alphaspace.Model.data.Categories

@Database(entities = [Categories::class] ,  version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {

    abstract fun getCategoryDao(): Categories

    companion object {

        @Volatile
        private var Instance: MyDatabase? = null

        fun getDatabase(context : Context) : MyDatabase{
            return Instance ?: synchronized(this){
                if (Instance == null){
                    Room.databaseBuilder(context , MyDatabase::class.java , "alpha")
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