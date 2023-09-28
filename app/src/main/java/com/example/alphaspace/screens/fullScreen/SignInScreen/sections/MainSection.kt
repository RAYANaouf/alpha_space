package com.example.alphaspace.screens.fullScreen.SignInScreen.sections

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alphaspace.screens.fullScreen.SignInScreen.Scenes.LogInScene
import com.google.android.gms.auth.api.signin.GoogleSignInAccount

@Composable
fun MainSection(
    modifier : Modifier = Modifier,
    onDone : ()->Unit = {},
    googleSignInBtn : (googleAccount : GoogleSignInAccount)->Unit = {}
) {

    var context = LocalContext.current
    var scene by remember {
        mutableStateOf("logIn")
    }

    if (scene == "logIn"){
        LogInScene(
            modifier = modifier.padding(top = 16.dp , bottom = 16.dp),
            onNextBtnClicked = {
                onDone()
            },
            onSignInClicked = {googleAccount->
                googleSignInBtn(googleAccount)
            }
        )
    }
    else if(scene == "signIn"){

    }

}

@Preview(widthDp = 1200 , heightDp = 800)
@Composable
fun MainSection_preview() {
    MainSection()
}