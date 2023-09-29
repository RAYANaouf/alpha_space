package com.example.alphaspace.Model.repo

import android.content.Context
import com.example.alphaspace.Model.room.AlphaDatabase
import com.example.alphaspace.Model.room.DAO.StoreTypeDAO
import com.example.alphaspace.Model.room.DAO.UserDAO
import com.example.alphaspace.Model.room.DAO.UserStoreTypeCrossRefDAO
import com.example.alphaspace.Model.room.entities.StoreType
import com.example.alphaspace.Model.room.entities.User
import com.example.alphaspace.Model.room.entities.UserStoreTypeCrossRef
import com.example.alphaspace.Model.room.relations.UserWithStoreTypes

class AlphaRepo {

    private val m_database : AlphaDatabase
    private val userDao : UserDAO
    private val storeTypeDao : StoreTypeDAO
    private val userStoreTypeCrossRefDao: UserStoreTypeCrossRefDAO

    constructor(context : Context){
        this.m_database = AlphaDatabase.getDatabase(context)

        //get entities dao
        this.userDao      = m_database.getUserDao()
        this.storeTypeDao = m_database.getStoreTypeDao()

        //get crossRef dao
        this.userStoreTypeCrossRefDao = m_database.getUserStoreTypeCrossRefDao()
    }


    /******** user  ******/
    suspend fun addUser(user : User): Long{
        return  userDao.addUser(user)
    }

    suspend fun getUserByGoogleAccountId(googleAccountId : String):User{
        return userDao.getUser(googleAccountId = googleAccountId)
    }

    suspend fun getUserWithStoreTypes(userId : Long) : UserWithStoreTypes{
        return userDao.getUserWithStoreTypes(userId)
    }

    /******** store type ********/

    suspend fun addStoreType(storeType : StoreType) : Long{
        return storeTypeDao.addStoreType(storeType)
    }

    suspend fun getStoreType(img : Int):StoreType{
        return storeTypeDao.getStoreType(img)
    }

    suspend fun getAllStoreType():List<StoreType>{
        return storeTypeDao.getAllStoreType()
    }

    suspend fun addUserStoreTypeCrossRef(userStoreTypeCrossRef: UserStoreTypeCrossRef):Long{
        return  userStoreTypeCrossRefDao.insertUserStoreTypeCrossRef(userStoreTypeCrossRef)
    }




    /******************** check existence *********************/
    suspend fun checkExistence(storeType: StoreType): Int{
        return storeTypeDao.countStoreType(storeType.img)
    }
    /**********************************************************/





}