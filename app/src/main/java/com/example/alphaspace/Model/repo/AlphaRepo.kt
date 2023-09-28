package com.example.alphaspace.Model.repo

import android.content.Context
import com.example.alphaspace.Model.room.AlphaDatabase
import com.example.alphaspace.Model.room.DAO.UserDAO
import com.example.alphaspace.Model.room.entities.User

class AlphaRepo {

    private val m_database : AlphaDatabase
    private val userDao : UserDAO

    constructor(context : Context){
        this.m_database = AlphaDatabase.getDatabase(context)
        this.userDao    = m_database.getUserDao()
    }

    suspend fun addUser(user : User){
        userDao.addUser(user)
    }

    suspend fun getUserByGoogleAccountId(googleAccountId : String):User{
        return userDao.getUser(googleAccountId = googleAccountId)
    }





}