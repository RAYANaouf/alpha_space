package com.example.alphaspace.logic

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.alphaspace.Model.data.screens_set
import com.example.alphaspace.Model.room.AlphaDatabase
import com.example.alphaspace.Model.room.DAO.UserDAO

class ScreenHandler {

    private val connectHandler : ConnectHandler

    var screen by mutableStateOf("")
        private set


    private constructor(connectHandler : ConnectHandler){

        this.connectHandler = connectHandler

        screen = if (connectHandler.checkSignIn()){
            screens_set.loading_checkForSetUp
        } else{
            screens_set.signInScreen
        }

    }

    fun setAppScreen(newScreen : String){
        screen = newScreen
    }


    companion object{

        @Volatile
        private var Instance : ScreenHandler? = null

        fun getInstance(connectHandler : ConnectHandler) : ScreenHandler {
            return Instance?: synchronized(this){
                if (Instance==null){
                    Instance = ScreenHandler(connectHandler)
                    Instance!!
                }
                else{
                    Instance!!
                }
            }
        }
    }


}