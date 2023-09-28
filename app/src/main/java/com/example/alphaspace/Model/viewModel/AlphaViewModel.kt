package com.example.alphaspace.Model.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alphaspace.Model.data.screens_set
import com.example.alphaspace.Model.repo.AlphaRepo
import com.example.alphaspace.Model.room.AlphaDatabase
import com.example.alphaspace.Model.room.entities.User
import com.example.alphaspace.logic.ConnectHandler
import com.example.alphaspace.logic.ScreenHandler
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AlphaViewModel : ViewModel {

    private val context : Context

    /********************* handler **************************/

    var connectHandler : ConnectHandler
        private set

    var screenHandler  : ScreenHandler
        private set

    private var repo   : AlphaRepo


    var user : User? = null
        private set


    /********************************************************/



    constructor(context : Context){
        this.context = context
        this.connectHandler = ConnectHandler.getInstance(context)
        this.screenHandler = ScreenHandler.getInstance(connectHandler)

        this.repo  =  AlphaRepo(context)

    }

    /****************** handler setters ***********************/

    fun changeScreen(newScreen : String){
        screenHandler.setAppScreen(newScreen)
    }
    fun signOut(){
        connectHandler.signOut(context)
        screenHandler.setAppScreen(screens_set.signInScreen)
    }

    /********************************************************/


    /*******************   user   ***********************/

    fun setUser(user : User){
        this.user = user
    }

    fun AddUser(user : User , callBack : ()->Unit = {}){
        GlobalScope.launch(Dispatchers.Default) {
            async { repo.addUser(user) }.await()
            this@AlphaViewModel.user = user
            withContext(Dispatchers.Main){
                callBack()
            }
        }
    }

    fun getUserByGoogleAccountId(googleAccountId : String , callBack : (user : User?)->Unit ){
        GlobalScope.launch(Dispatchers.Default) {
            var user = async { repo.getUserByGoogleAccountId(googleAccountId ) }.await()
            callBack(user)
        }
    }



}