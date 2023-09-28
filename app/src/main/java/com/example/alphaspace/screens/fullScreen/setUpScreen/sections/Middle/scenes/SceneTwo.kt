package com.example.alphaspace.screens.fullScreen.setUpScreen.sections.Middle.scenes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alphaspace.Model.data.TextStyles.textStyles
import com.example.alphaspace.screens.common.AlphaTextField
import com.example.alphaspace.screens.fullScreen.setUpScreen.sections.Middle.component.SexAndAgeQuestion
import com.example.alphaspace.screens.fullScreen.setUpScreen.sections.Middle.component.WorkingTime
import com.example.alphaspace.ui.theme.iconColor_border_p1
import java.time.LocalTime

@Composable
fun SceneTwo(
    age : String,
    sex : String,
    phoneNumber : String,
    openingTime : LocalTime,
    closingTime : LocalTime,
    formattedOpeningTime : String,
    formattedClosingTime : String,
    onOpeningTimeClick : ()->Unit,
    onClosingTimeClick : ()->Unit,
    modifier: Modifier = Modifier,
    onTextFieldCharge : (String , String)->Unit
    ) {

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        AlphaTextField(
            text = phoneNumber,
            onValueChange = {
                onTextFieldCharge("phoneNumber" , it.filter {
                    it.isDigit()
                })
            },
            textFieldStyle = textStyles.textFieldStyle,
            hint = "Your phone number",
            hintStyle = textStyles.hintStyle,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Phone
            ),
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

        Spacer(modifier = Modifier.height(36.dp))

        WorkingTime(
            openingTime = openingTime,
            closingTime = closingTime,
            formattedOpeningTime = formattedOpeningTime,
            formattedClosingTime = formattedClosingTime,
            onOpeningTimeClick = {
                onOpeningTimeClick()
            },
            onClosingTimeClick = {
                onClosingTimeClick()
            }
        )

    }
}

@Preview
@Composable
fun SceneTwo_preview() {
    SceneTwo(
        age = "",
        sex = "",
        phoneNumber = "",
        openingTime = LocalTime.of(10,0),
        closingTime = LocalTime.of(19,0),
        formattedOpeningTime = "10:00",
        formattedClosingTime = "19:00",
        onOpeningTimeClick = {

        },
        onClosingTimeClick = {

        }
    ){_,_->

    }
}