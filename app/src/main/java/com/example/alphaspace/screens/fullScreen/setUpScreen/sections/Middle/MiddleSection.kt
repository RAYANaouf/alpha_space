package com.example.alphaspace.screens.fullScreen.setUpScreen.sections.Middle

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alphaspace.Model.data.TextStyles.textStyles
import com.example.alphaspace.screens.common.AlphaTextField
import com.example.alphaspace.screens.fullScreen.setUpScreen.sections.Middle.component.SexAndAgeQuestion
import com.example.alphaspace.screens.fullScreen.setUpScreen.sections.Middle.component.WorkingTime
import com.example.alphaspace.screens.fullScreen.setUpScreen.sections.Middle.scenes.SceneOne
import com.example.alphaspace.ui.theme.color5
import com.example.alphaspace.ui.theme.iconColor_border_p1
import java.time.LocalTime

@Composable
fun MiddleSection(
    storeName : String ,
    firstName : String,
    lastName : String,
    supportGmail : String,
    age : String,
    sex : String,
    phoneNumber : String,
    onTextFieldCharge : (String , String)->Unit,
    openingTime : LocalTime,
    closingTime : LocalTime,
    formattedOpeningTime : String,
    formattedClosingTime : String,
    onOpeningTimeClick : ()->Unit,
    onClosingTimeClick : ()->Unit,
    modifier : Modifier = Modifier) {

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {

        SceneOne(
            storeName = storeName,
            firstName = firstName,
            lastName  = lastName
        ) { name, txt ->
            onTextFieldCharge(name, txt)
        }

        Spacer(modifier = Modifier.height(36.dp))



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



    }
}



@Preview(widthDp = 500 , heightDp = 800)
@Composable
fun MiddleSection_preview() {
    Surface(
        color = color5,
    ) {
        MiddleSection(
            storeName = "storeName",
            firstName ="firstName",
            lastName = "lastName",
            supportGmail = "supportGmail",
            phoneNumber = "phoneNumber",
            age = "21",
            sex = "Man",
            onTextFieldCharge = {name , txt ->

            },
            openingTime = LocalTime.of(10,0),
            closingTime = LocalTime.of(7,0),
            formattedOpeningTime = "",
            formattedClosingTime = "",
            onClosingTimeClick = {

            },
            onOpeningTimeClick = {

            }
        )
    }
}