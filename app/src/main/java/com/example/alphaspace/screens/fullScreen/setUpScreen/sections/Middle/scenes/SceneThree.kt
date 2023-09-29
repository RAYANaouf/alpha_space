package com.example.alphaspace.screens.fullScreen.setUpScreen.sections.Middle.scenes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.alphaspace.Model.data.TextStyles.textStyles
import com.example.alphaspace.screens.common.AlphaTextField
import com.example.alphaspace.ui.theme.iconColor_border_p1

@Composable
fun SceneThree(
    modifier: Modifier =Modifier,
    supportGmail : String,
    password : String ,
    password2 : String ,
    onTextFieldCharge : (String , String)->Unit,
    ) {

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {

        Text(
            text = "that gmail is just for support.\nit's not the one that you'll use to sign in next time.",
            style = textStyles.textStyle_size3.copy(color = iconColor_border_p1 , fontSize = TextUnit(18f , TextUnitType.Sp))
        )
        
        Spacer(modifier = Modifier.height(12.dp))
        
        AlphaTextField(
            text = supportGmail,
            onValueChange = {
                onTextFieldCharge("supportGmail" , it)
            },
            textFieldStyle = textStyles.textFieldStyle,
            hint = "Your Support Gmail",
            hintStyle = textStyles.hintStyle,
            cursorColor = iconColor_border_p1,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        )

        Spacer(modifier = Modifier.height(36.dp))

        AlphaTextField(
            text = password,
            onValueChange = {
                onTextFieldCharge("password" , it)
            },
            textFieldStyle = textStyles.textFieldStyle,
            hint = "enter your password",
            hintStyle = textStyles.hintStyle,
            cursorColor = iconColor_border_p1,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        )

        Spacer(modifier = Modifier.height(36.dp))

        AlphaTextField(
            text = password2,
            onValueChange = {
                onTextFieldCharge("password2" , it)
            },
            textFieldStyle = textStyles.textFieldStyle,
            hint = "rewrite your password",
            hintStyle = textStyles.hintStyle,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            cursorColor = iconColor_border_p1,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        )
    }
}

@Preview
@Composable
fun SceneThreepreview() {
    SceneThree(
        password = "",
        password2 = "",
        supportGmail = "",
    ){_,_->

    }
}