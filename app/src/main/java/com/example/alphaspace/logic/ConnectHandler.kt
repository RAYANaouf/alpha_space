package com.example.alphaspace.logic

import android.content.Context
import android.content.Intent
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.result.ActivityResult
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.alphaspace.Model.room.entities.User
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions


class ConnectHandler{



    var googleSignInAccount by mutableStateOf<GoogleSignInAccount?>(null)
        private set

    var isSignIn by mutableStateOf(false)
        private set

    private constructor(context : Context ){
        googleSignInAccount = GoogleSignIn.getLastSignedInAccount(context)
        isSignIn = googleSignInAccount != null
    }


     fun checkSignIn() : Boolean{
        return isSignIn
    }

    fun signOut(context: Context){
        GoogleSignIn.getClient(context , GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).build()).signOut()
        googleSignInAccount = null
        isSignIn = false
    }

    fun setAccount(account : GoogleSignInAccount){
        googleSignInAccount = account
        isSignIn = account!= null
    }


    companion object{

        @Volatile
        private var Instance : ConnectHandler? = null

        fun getInstance(context: Context) : ConnectHandler {
            return Instance?: synchronized(this){
                if (Instance==null){
                    Instance = ConnectHandler(context)
                    Instance!!
                }
                else{
                    Instance!!
                }
            }
        }

        fun signInWithGoogle(launcher : ManagedActivityResultLauncher<Intent, ActivityResult>, context: Context){
            var googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .requestId()
                .requestProfile()
                .build()

            launcher.launch(GoogleSignIn.getClient( context , googleSignInOptions ).signInIntent)


        }
    }

}