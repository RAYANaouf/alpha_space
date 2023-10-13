package com.example.alphaspace.screens.fullScreen.setUpScreen


import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.alphaspace.Model.data.TextStyles.textStyles
import com.example.alphaspace.Model.data.screens_set
import com.example.alphaspace.Model.room.entities.User
import com.example.alphaspace.Model.viewModel.AlphaSetUpViewModel
import com.example.alphaspace.Model.viewModel.AlphaViewModel
import com.example.alphaspace.R
import com.example.alphaspace.screens.common.Indicator
import com.example.alphaspace.screens.fullScreen.setUpScreen.sections.LeftSide.LeftSideSection
import com.example.alphaspace.screens.fullScreen.setUpScreen.sections.Middle.MiddleSection
import com.example.alphaspace.screens.fullScreen.setUpScreen.sections.RightSide.RightSideSection
import com.example.alphaspace.ui.theme.CustomBlack0
import com.example.alphaspace.ui.theme.CustomWhite0
import com.example.alphaspace.ui.theme.color4
import com.example.alphaspace.ui.theme.iconColor_border_p1
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.time.TimePickerDefaults
import com.vanpra.composematerialdialogs.datetime.time.timepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Composable
fun SetUpScreen(
    viewModel : AlphaViewModel
) {

    val setUpViewModel : AlphaSetUpViewModel = androidx.lifecycle.viewmodel.compose.viewModel()


    //context
    val context = LocalContext.current

    /*****************  state  ****************************/

    //text & style for textField
    //text


    var scene by remember{
        mutableStateOf(1)
    }

    var storeName by rememberSaveable {
        mutableStateOf("")
    }

    var firstName by rememberSaveable {
        mutableStateOf("")
    }

    var lastName by rememberSaveable {
        mutableStateOf("")
    }

    var supportGmail by rememberSaveable {
        mutableStateOf("")
    }

    var password by rememberSaveable {
        mutableStateOf("")
    }

    var password2 by rememberSaveable {
        mutableStateOf("")
    }

    var phoneNumber by rememberSaveable {
        mutableStateOf("")
    }

    var age by rememberSaveable {
        mutableStateOf("18")
    }

    var sex by rememberSaveable {
        mutableStateOf("Man")
    }



    //time dialogs
    var openingTime by rememberSaveable {
        mutableStateOf(LocalTime.of(10 , 0))
    }

    var closingTime by rememberSaveable {
        mutableStateOf(LocalTime.of(19,0))
    }

    val formattedOpeningTime by remember{
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("hh:mm")
                .format(openingTime)
        }
    }

    val formattedClosingTime by remember{
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("hh:mm")
                .format(closingTime)
        }
    }

    val openingTimeDialogState = rememberMaterialDialogState()

    var closingTimeDialogState = rememberMaterialDialogState()


    /******************************************************/

    /************  dialog  ************************/

    //opening time picker
    MaterialDialog(
        dialogState = openingTimeDialogState,
        backgroundColor = CustomWhite0,
        shape = RoundedCornerShape(12.dp),
        elevation = 8.dp,
        buttons = {
            this.positiveButton(
                text = "Done",
                textStyle = textStyles.textStyle_size1.copy(color = iconColor_border_p1 , fontSize = TextUnit(18f , TextUnitType.Sp))
            ){

            }
            negativeButton(
                text = "Cancel",
                textStyle = textStyles.textStyle_size1.copy(color = iconColor_border_p1 , fontSize = TextUnit(18f , TextUnitType.Sp))
            ){

            }
        }
    ) {
        timepicker(
            initialTime = openingTime,
            title = "Opening Time",
            colors = TimePickerDefaults.colors(
                activeBackgroundColor = iconColor_border_p1,
                inactiveBackgroundColor = color4,
                activeTextColor = CustomWhite0,
                inactiveTextColor = CustomBlack0,
                selectorColor = iconColor_border_p1
            )
        ){
            openingTime = it
        }
    }

    //closing time picker
    MaterialDialog(
        dialogState = closingTimeDialogState,
        backgroundColor = CustomWhite0,
        shape = RoundedCornerShape(12.dp),
        elevation = 8.dp,
        buttons = {
            this.positiveButton(
                text = "Done",
                textStyle = textStyles.textStyle_size1.copy(color = iconColor_border_p1 , fontSize = TextUnit(18f , TextUnitType.Sp))
            ){

            }
            negativeButton(
                text = "Cancel",
                textStyle = textStyles.textStyle_size1.copy(color = iconColor_border_p1 , fontSize = TextUnit(18f , TextUnitType.Sp))
            ){

            }
        },

    ) {
        timepicker(
            initialTime = closingTime,
            title = "closing Time",
            colors = TimePickerDefaults.colors(
                activeBackgroundColor = iconColor_border_p1,
                inactiveBackgroundColor = color4,
                activeTextColor = CustomWhite0,
                inactiveTextColor = CustomBlack0,
                selectorColor = iconColor_border_p1
            )
        ){
            closingTime = it
        }
    }
    /**********************************************/

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 36.dp)
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
        ) {
            LeftSideSection(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxHeight(1f)
            )

            MiddleSection(
                scene = scene,
                storeName = storeName,
                firstName = firstName,
                lastName = lastName,
                phoneNumber = phoneNumber,
                password = password,
                password2 = password2,
                supportGmail = supportGmail,
                sex = sex,
                age = age,
                onTextFieldCharge = { name , txt->
                    when(name){
                        "storeName"->{
                            storeName = txt
                        }
                        "firstName"->{
                            firstName=txt
                        }
                        "lastName"->{
                            lastName = txt
                        }
                        "password"->{
                            password = txt
                        }
                        "password2"->{
                            password2 = txt
                        }
                        "phoneNumber"->{
                            phoneNumber = txt
                        }
                        "supportGmail"->{
                            supportGmail = txt
                        }
                        "sex"->{
                            sex = txt
                        }
                        "age"->{
                            age = txt
                        }

                    }
                },
                formattedOpeningTime = formattedOpeningTime,
                formattedClosingTime = formattedClosingTime,
                openingTime = openingTime,
                closingTime = closingTime,
                onOpeningTimeClick = {
                    openingTimeDialogState.show()
                },
                onClosingTimeClick = {
                    closingTimeDialogState.show()
                },
                modifier = Modifier
                    .weight(4f)
                    .fillMaxHeight(1f)
            )

            RightSideSection(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxHeight(1f)
            )

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(start = 26.dp, end = 26.dp)
        ) {

            Indicator(
                count = 4,
                position = scene,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .align(Alignment.Center)
            )

            var load by rememberSaveable {
                mutableStateOf(false)
            }

            if (!load){
                Button(
                    onClick = {

                              if (scene == 1){
                                  if (storeName.isNotEmpty() && firstName.isNotEmpty() && lastName.isNotEmpty()){
                                      scene = 2
                                  }
                                  else{
                                      Toast.makeText(context , "fulfill your information" , Toast.LENGTH_LONG).show()
                                  }
                              }
                              else if(scene == 2){
                                  if (phoneNumber.isNotEmpty() ){
                                      scene = 3
                                  }
                                  else{
                                      Toast.makeText(context , "fulfill your information" , Toast.LENGTH_LONG).show()
                                  }
                              }
                              else if(scene == 3){
                                  if (supportGmail.isNotEmpty() && password.isNotEmpty() && password2.isNotEmpty()){
                                      if (password == password2){
                                          scene += 1
                                      }
                                      else{
                                          Toast.makeText(context , "your password isn't the same" , Toast.LENGTH_LONG).show()
                                      }
                                  }
                                  else{
                                      Toast.makeText(context , "fulfill your information" , Toast.LENGTH_LONG).show()
                                  }
                              }
                        else if(scene == 4){
                                  load = true

                                  val user = User(
                                      firstName = firstName,
                                      lastName = lastName,
                                      age = age.toIntOrNull() ?: 21,
                                      sex = sex,
                                      userPhoneNumber = phoneNumber.toIntOrNull() ?: 0,
                                      userPassword = password,
                                      userGmail = viewModel.connectHandler.googleSignInAccount?.email ?: "",
                                      supportGmail = supportGmail,
                                      openingHour = openingTime.hour,
                                      openingMinute = openingTime.minute,
                                      closingHour = closingTime.hour,
                                      closingMinute = closingTime.minute,
                                      googleAccountId = viewModel.connectHandler.googleSignInAccount?.id ?: "",
                                      image = "",
                                  )

                                  viewModel.setUpUserWithStoreTypes(
                                      user = user ,
                                      storeTypes = setUpViewModel.storeTypes.toList() ,
                                      failureCallBack = {
                                          Toast.makeText(context , "${it.message}" , Toast.LENGTH_LONG).show()
                                      },
                                      successCallBack = {
                                          load = false
                                          Toast.makeText(context , "$it" , Toast.LENGTH_LONG).show()
                                          viewModel.screenHandler.setAppScreen(screens_set.mainScreen)
                                      }
                                  )
                              }


                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = iconColor_border_p1,
                        contentColor = Color.White
                    ),
                    elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 6.dp),
                    modifier = Modifier.align(Alignment.CenterEnd)
                ) {
                    Text(
                        text = stringResource(id = if(scene<4) R.string.next else R.string.done),
                        style = textStyles.textStyle_size1.copy(color = Color.White)
                    )
                }


            }
            else{

            }

            Column(modifier = Modifier.align(Alignment.CenterStart)) {
                AnimatedVisibility(
                    visible = scene > 1 ,
                ) {
                    Button(
                        onClick = {
                            if (scene > 1){
                                scene -= 1
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = CustomWhite0,
                            contentColor = iconColor_border_p1
                        ),
                        elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 6.dp),
                    ) {
                        Text(
                            text = "Back",
                            style = textStyles.textStyle_size1.copy(color = iconColor_border_p1)
                        )

                    }
                }
            }

        }
    }

}




@Preview(widthDp = 1200 , heightDp = 800)
@Composable
fun SetUpScreen_preview() {

    var context = LocalContext.current
    SetUpScreen(
        viewModel = viewModel(
            factory = object : ViewModelProvider.Factory{
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    if (modelClass.isAssignableFrom(AlphaViewModel::class.java)){
                        return AlphaViewModel(context = context) as T
                    }
                    throw IllegalArgumentException("can't create alphaViewModel class (setScreen File)")
                }
            }
        )
    )
}
