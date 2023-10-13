package com.example.alphaspace.Model.viewModel

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alphaspace.Model.data.screens_set
import com.example.alphaspace.Model.data.storeTypes.allStoreTypes
import com.example.alphaspace.Model.repo.AlphaRepo
import com.example.alphaspace.Model.room.entities.StoreType
import com.example.alphaspace.Model.room.entities.User
import com.example.alphaspace.Model.room.entities.UserStoreTypeCrossRef
import com.example.alphaspace.Model.room.relations.UserWithStoreTypes
import com.example.alphaspace.logic.ConnectHandler
import com.example.alphaspace.logic.Errors
import com.example.alphaspace.logic.ScreenHandler
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

    private val _userStoreTypes  = mutableStateListOf<StoreType>()
    val userStoreTypes : List<StoreType>
        get() = _userStoreTypes

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

    fun AddUser(user : User , callBack : (Long)->Unit = {}){
        GlobalScope.launch(Dispatchers.Default) {
            val userId = async { repo.addUser(user) }.await()
            this@AlphaViewModel.user = user
            withContext(Dispatchers.Main){
                callBack(userId)
            }
        }
    }

    fun getUserByGoogleAccountId(googleAccountId : String , callBack : (user : User?)->Unit ){
        GlobalScope.launch(Dispatchers.Default) {
            var user = async { repo.getUserByGoogleAccountId(googleAccountId ) }.await()
            callBack(user)
        }
    }

    /**********************    StoreType    ****************************/


    fun addStoreType(storeType: StoreType , callBack: (Long) -> Unit = {}){
        viewModelScope.launch {
            callBack(repo.addStoreType(storeType))
        }
    }

    fun checkForStoreType(storeType: StoreType , callBack: (Int) -> Unit){
        viewModelScope.launch {
            callBack(repo.checkExistence(storeType))
        }
    }

    fun getAllStoreType(successCallBack: (List<StoreType>) -> Unit = {}, failureCallBack: (Errors.RoomError) -> Unit = {}){
        viewModelScope.launch {
            var storetypes = repo.getAllStoreType()
            if (storetypes != null){
                successCallBack(storetypes)
            }
            else{
                failureCallBack(Errors.RoomError("error"))
            }
        }
    }

    fun getUserStoreTypes(userId : Long, successCallBack: (List<StoreType>) -> Unit = {}, failureCallBack: (Errors.RoomError) -> Unit ={}){
       if (userStoreTypes.size > 0){
           successCallBack(userStoreTypes!!.toList())
       }
        else{
           viewModelScope.launch {
               val storeTypes = repo.getUserWithStoreTypes(userId)?.storeTypes
               if (!storeTypes.isNullOrEmpty()){
                   withContext(Dispatchers.Main){
                       this@AlphaViewModel._userStoreTypes.clear()
                       this@AlphaViewModel._userStoreTypes += storeTypes
                       successCallBack(_userStoreTypes)
                   }

               }
               else{
                   failureCallBack(Errors.RoomError("user hasn't store type or your internet is turned off "))
               }
           }
       }
    }

    fun getUserStoreTypes(user : User){

    }


    /**************************  setUp User with Its StoreTypes *************************/

    fun setUpUserWithStoreTypes(user : User , storeTypes : List<StoreType> , successCallBack: (String) -> Unit ={} , failureCallBack:(Errors.RoomError)->Unit = {}){
        viewModelScope.launch {
            val userId = repo.addUser(user)

            if (userId > 0 ){
                this@AlphaViewModel.user = user
                storeTypes.forEach {storeType->
                    if (repo.checkExistence(storeType) == 0){
                        val storeTypeId = repo.addStoreType(storeType)
                        if ( storeTypeId > 0){
                            if (repo.addUserStoreTypeCrossRef(UserStoreTypeCrossRef(userId , storeTypeId)) > 0){
//                                successCallBack("setUp Success")
                                this@AlphaViewModel._userStoreTypes.add(storeType)
                            }
                            else{
                                failureCallBack(Errors.RoomError("failed to associate user with store types"))
                                return@launch
                            }
                        }
                        else{
                            failureCallBack(Errors.RoomError("failed to create store type"))
                            return@launch
                        }
                    }
                    else{
                        val storeType = repo.getStoreType(storeType.img)
                        if (repo.addUserStoreTypeCrossRef(UserStoreTypeCrossRef(user.userId , storeType.storeTypeId)) > 0){
//                            successCallBack("setUp Success")
                        }
                        else{
                            failureCallBack(Errors.RoomError(""))
                            return@launch
                        }

                    }
                }
            }
            else{
                failureCallBack(Errors.RoomError("failed to insert user"))
                return@launch
            }

            successCallBack("setUp Success")

        }
    }

}