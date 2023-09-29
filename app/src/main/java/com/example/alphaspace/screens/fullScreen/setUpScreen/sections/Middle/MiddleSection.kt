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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.alphaspace.Model.data.TextStyles.textStyles
import com.example.alphaspace.Model.viewModel.AlphaViewModel
import com.example.alphaspace.screens.common.AlphaTextField
import com.example.alphaspace.screens.fullScreen.setUpScreen.sections.Middle.component.SexAndAgeQuestion
import com.example.alphaspace.screens.fullScreen.setUpScreen.sections.Middle.component.WorkingTime
import com.example.alphaspace.screens.fullScreen.setUpScreen.sections.Middle.scenes.SceneFour
import com.example.alphaspace.screens.fullScreen.setUpScreen.sections.Middle.scenes.SceneOne
import com.example.alphaspace.screens.fullScreen.setUpScreen.sections.Middle.scenes.SceneThree
import com.example.alphaspace.screens.fullScreen.setUpScreen.sections.Middle.scenes.SceneTwo
import com.example.alphaspace.ui.theme.color5
import com.example.alphaspace.ui.theme.iconColor_border_p1
import java.time.LocalTime

@Composable
fun MiddleSection(
    scene        : Int,
    storeName    : String ,
    firstName    : String,
    lastName     : String,
    supportGmail : String,
    password     : String,
    password2    : String,
    age          : String,
    sex          : String,
    phoneNumber  : String,
    onTextFieldCharge    : (String , String)->Unit,
    openingTime  : LocalTime,
    closingTime  : LocalTime,
    formattedOpeningTime : String,
    formattedClosingTime : String,
    onOpeningTimeClick   : ()->Unit,
    onClosingTimeClick   : ()->Unit,
    modifier     : Modifier = Modifier) {


    if (scene == 1){
        SceneOne(
            age = age,
            sex = sex,
            storeName = storeName,
            firstName = firstName,
            lastName  = lastName,
            modifier = modifier
        ) { name, txt ->
            onTextFieldCharge(name, txt)
        }
    }
    else if(scene == 2 ){
        SceneTwo(
            phoneNumber = phoneNumber,
            openingTime = openingTime,
            closingTime = closingTime,
            formattedOpeningTime = formattedOpeningTime,
            formattedClosingTime = formattedClosingTime,
            onOpeningTimeClick = onOpeningTimeClick,
            onClosingTimeClick = onClosingTimeClick,
            onTextFieldCharge = {name , txt ->
                onTextFieldCharge(name , txt)
            },
            modifier = modifier
        )
    }
    else if(scene == 3 ) {
        SceneThree(
            password = password,
            password2 = password2,
            supportGmail =supportGmail,
            modifier = modifier
        ){name,txt->
            onTextFieldCharge(name , txt)
        }
    }
    else if(scene == 4){
        SceneFour(
            modifier = modifier
        )
    }

}



@Preview(widthDp = 500 , heightDp = 800)
@Composable
fun MiddleSection_preview() {

    val context = LocalContext.current
    Surface(
        color = color5,
    ) {
        MiddleSection(
            scene = 0,
            storeName = "storeName",
            firstName ="firstName",
            lastName = "lastName",
            password = "",
            password2 = "",
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