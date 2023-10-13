package com.example.alphaspace.screens.fullScreen.setUpScreen.sections.Middle.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alphaspace.Model.data.TextStyles.textStyles
import com.example.alphaspace.screens.common.dropDownMenu.AlphaDropDownMenu
import com.example.alphaspace.ui.theme.CustomWhite0
import com.example.alphaspace.ui.theme.iconColor_border_p1

@Composable
fun SexAndAgeQuestion(
    modifier : Modifier = Modifier ,
    age : String ,
    onAgeSet : (String)->Unit ,
    sex : String ,
    onSexSet : (String)->Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ){
        AgeQuestion(
            age = age,
            onAgeSet = { age->
                onAgeSet(age)
            },
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        )
        SexQuestion(
            sex = sex,
            onSexSet = { sex->
                onSexSet(sex)
            },
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        )
    }
}


@Composable
fun AgeQuestion(
    age : String,
    onAgeSet : (String)->Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        Text(
            text = "Age :",
            style = textStyles.textStyle_size1,
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .padding(start = 20.dp, end = 20.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxHeight(0.9f)
                    .width(75.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .border(
                        border = BorderStroke(2.dp, iconColor_border_p1),
                        RoundedCornerShape(12.dp)
                    )
                    .background(CustomWhite0)
                    .padding(top = 6.dp, bottom = 6.dp, start = 8.dp, end = 8.dp)
            ) {

                BasicTextField(
                    value = age,
                    onValueChange = {

                        val age = it.filter { char->
                            char.isDigit()
                        }
                        if (age.length<3){
                            onAgeSet(age)
                        }

                    },
                    textStyle = textStyles.textFieldStyle.copy(textAlign = TextAlign.Center ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
                    ),
                    singleLine = true,
                    cursorBrush = SolidColor(iconColor_border_p1),
                    modifier = Modifier
                )



            }
        }
    }
}

@Composable
fun SexQuestion(
    sex: String,
    onSexSet: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    /********** dropDownMenu ****************/
    var expanded  by rememberSaveable {
        mutableStateOf(false)
    }
    /****************************************/
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Text(
            text = "Sex :",
            style = textStyles.textStyle_size1,
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .padding(start = 20.dp, end = 20.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxHeight(0.9f)
                    .width(120.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .clickable {
                        expanded = true
                    }

                    .border(
                        border = BorderStroke(2.dp, iconColor_border_p1),
                        RoundedCornerShape(12.dp)
                    )
                    .background(CustomWhite0)
                    .padding(top = 6.dp, bottom = 6.dp, start = 8.dp, end = 8.dp)
            ) {

                Text(
                    text = sex ,
                    style = textStyles.textStyle_size1
                )

                AlphaDropDownMenu(
                    expanded = expanded ,
                    items = listOf("Man","Woman"),
                    onClick = {selectedItem->
                        onSexSet(selectedItem)
                        expanded = false
                    },
                    onDismissRequest = {
                        expanded = false
                    },
                    modifier = Modifier
                        .background(
                            CustomWhite0
                        )
                        .clip(RoundedCornerShape(12.dp))
                )

            }
        }
    }
}

@Preview
@Composable
fun SexAndAgeQuestion_preview() {
    SexAndAgeQuestion(
        age = "18" ,
        onAgeSet = {},
        sex = "",
        onSexSet = {}
    )
}


@Preview
@Composable
fun SexQuestion_preview() {
    SexQuestion(
        sex = "",
        onSexSet = {

        }
    )
}

@Preview
@Composable
fun AgeQuestion_preview() {
    AgeQuestion(
        age = "18",
        onAgeSet = {

        }
    )
}