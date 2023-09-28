package com.example.alphaspace.screens.fullScreen.SignInScreen.Scenes

import android.app.Activity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.alphaspace.R
import com.example.alphaspace.logic.ConnectHandler
import com.example.alphaspace.ui.theme.CustomWhite0
import com.example.alphaspace.ui.theme.iconColor_border_p1
import com.example.alphaspace.ui.theme.textColor1
import com.example.alphaspace.ui.theme.textColor2
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount


@Composable
fun
        LogInScene(
    modifier: Modifier = Modifier ,
    onNextBtnClicked : ()->Unit = {} ,
    onSignInClicked  : (googleAccount : GoogleSignInAccount)->Unit = {}
) {
    /************   text feild   **************/

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    /*****************************************/

    /********   text style textField *********/

    var textStyle_textField = TextStyle(
        color = textColor1,
        fontSize = TextUnit(26f , TextUnitType.Sp),
        fontWeight = FontWeight.W600
    )

    var textStyle_hint      = TextStyle(
        color = textColor2,
        fontSize = TextUnit(26f , TextUnitType.Sp),
        fontWeight = FontWeight.W600
    )

    /*****************************************/

    /**************   registers **************/

    val signInLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()){ result->
        if (result.resultCode == Activity.RESULT_OK){
            var googleAccount = GoogleSignIn.getSignedInAccountFromIntent(result.data).result
            if (googleAccount != null){
                onSignInClicked(googleAccount)
            }
        }
    }

    /*****************************************/


    /**************   context   **************/

    val context = LocalContext.current

    /*****************************************/



    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxHeight()
    ) {

        Spacer(
            modifier = Modifier
                .weight(4f)
        )

        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .weight(7f)
        ) {
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(65.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .border(
                        width = 2.dp,
                        color = iconColor_border_p1,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .background(CustomWhite0)
                    .padding(start = 16.dp, top = 2.dp, bottom = 2.dp, end = 16.dp)
            ) {

                BasicTextField(
                    value = email,
                    onValueChange = { s-> email = s} ,
                    textStyle = textStyle_textField,
                    singleLine = true ,
                    maxLines = 1,
                    modifier = Modifier
                        .fillMaxWidth(),
                    cursorBrush = SolidColor(iconColor_border_p1)
                )

                if (email == ""){
                    Text(
                        text = "Email",
                        style = textStyle_hint
                    )
                }

            }

            Spacer(
                modifier = Modifier
                    .height(32.dp)
            )

            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(65.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .border(
                        width = 2.dp,
                        color = iconColor_border_p1,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .background(CustomWhite0)
                    .padding(start = 16.dp, top = 2.dp, bottom = 2.dp, end = 16.dp)
            ) {

                BasicTextField(
                    value = password,
                    onValueChange = { password = it},
                    textStyle = textStyle_textField,
                    singleLine = true ,
                    maxLines = 1,
                    modifier = Modifier
                        .fillMaxWidth()
                )

                if (password == ""){
                    Text(
                        text = "Password",
                        style = textStyle_hint
                    )
                }

            }

            Spacer(
                modifier = Modifier
                    .height(32.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(65.dp)
            ) {
                Text(
                    text = "forget the password",
                    style = TextStyle(
                        color = textColor2,
                        fontSize = TextUnit(20f , TextUnitType.Sp),
                        fontWeight = FontWeight.W500
                    )
                )
                Button(
                    onClick = { onNextBtnClicked() },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = iconColor_border_p1
                    ),
                    modifier = Modifier
                        .height(55.dp)
                        .width(110.dp)
                ) {
                    Text(
                        text = "Next",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = TextUnit(20f , TextUnitType.Sp),
                            fontWeight = FontWeight.W600
                        )
                    )
                }
            }

            Spacer(
                modifier = Modifier
                    .height(32.dp)
            )

            Button(
                onClick = {
                   ConnectHandler.signInWithGoogle(signInLauncher , context)

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = CustomWhite0,
                    contentColor = textColor2
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 4.dp
                ),
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(55.dp)
            ) {
                Text(text = "Sing In with google ")

                Spacer(modifier = Modifier.width(16.dp))

                Image(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = "",
                    modifier = Modifier
                        .size(30.dp)
                )
            }
        }


    }

}


@Preview(widthDp = 1200 , heightDp = 800)
@Composable
fun LogInScene_preview() {
    LogInScene()
}
