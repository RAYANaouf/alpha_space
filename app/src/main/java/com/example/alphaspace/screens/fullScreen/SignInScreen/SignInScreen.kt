package com.example.alphaspace.screens.fullScreen.SignInScreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.alphaspace.screens.fullScreen.SignInScreen.sections.MainSection
import com.example.alphaspace.screens.fullScreen.SignInScreen.sections.SideSection
import com.google.android.gms.auth.api.signin.GoogleSignInAccount

@Composable
fun SignInScreen(
    onDone : ()->Unit = {},
    googleSignInBtn : (googleAccount : GoogleSignInAccount)->Unit = {}
) {




    var showSignInFlow by rememberSaveable {
        mutableStateOf(false)
    }

    Row(
        modifier = Modifier
            .fillMaxSize()
    ) {
        SideSection(
            modifier = Modifier.weight(3f)
        )

        MainSection(
            modifier = Modifier.weight(4f),
            onDone = {
                onDone()
            },
            googleSignInBtn = {googleAccount->
                googleSignInBtn(googleAccount)


            }
        )
    }



}

@Preview(widthDp = 1200 , heightDp = 800)
@Composable
fun SignInScreen_preview() {
    SignInScreen()
}