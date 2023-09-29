package com.example.alphaspace.screens.fullScreen.setUpScreen.sections.Middle.scenes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alphaspace.Model.data.TextStyles.textStyles
import com.example.alphaspace.screens.common.AlphaTextField
import com.example.alphaspace.screens.fullScreen.setUpScreen.sections.Middle.component.SexAndAgeQuestion
import com.example.alphaspace.ui.theme.iconColor_border_p1

@Composable
fun SceneOne(
    age : String,
    sex : String,
    storeName : String ,
    firstName : String,
    lastName : String,
    modifier: Modifier = Modifier,
    onTextFieldCharge : (String , String)->Unit
    ) {

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        AlphaTextField(
            text = storeName,
            onValueChange = {
                onTextFieldCharge("storeName" , it)
            },
            textFieldStyle = textStyles.textFieldStyle,
            hint = "Store name",
            hintStyle = textStyles.hintStyle,
            cursorColor = iconColor_border_p1,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        )

        Spacer(modifier = Modifier.height(36.dp))

        AlphaTextField(
            text = firstName,
            onValueChange = {
                onTextFieldCharge("firstName",it)
            },
            textFieldStyle = textStyles.textFieldStyle,
            hint = "Your first name",
            hintStyle = textStyles.hintStyle,
            cursorColor = iconColor_border_p1,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        )

        Spacer(modifier = Modifier.height(36.dp))

        AlphaTextField(
            text = lastName,
            onValueChange = {
                onTextFieldCharge("lastName",it)
            },
            textFieldStyle = textStyles.textFieldStyle,
            hint = "Your last name",
            hintStyle = textStyles.hintStyle,
            cursorColor = iconColor_border_p1,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        )

        Spacer(modifier = Modifier.height(36.dp))

        SexAndAgeQuestion(
            sex = sex,
            age = age,
            onSexSet = {
                onTextFieldCharge("sex",it)
            },
            onAgeSet = {
                onTextFieldCharge("age",it)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        )

    }
}

@Preview
@Composable
fun SceneOne_preview() {
    SceneOne(
        age = "",
        sex = "",
        storeName  = "",
        firstName = "",
        lastName = ""
    ) { _ , _ ->

    }
}