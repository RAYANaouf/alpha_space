package com.example.alphaspace.screens.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alphaspace.ui.theme.CustomWhite0
import com.example.alphaspace.ui.theme.iconColor_border_p1

@Composable
fun AlphaTextField(
    modifier : Modifier = Modifier,
    shape : Shape = RoundedCornerShape(12.dp),
    borderStroke: BorderStroke = BorderStroke(1.dp , iconColor_border_p1),
    background : Color = CustomWhite0,
    text : String,
    onValueChange : (String)->Unit,
    textFieldStyle: TextStyle,
    hint : String ,
    hintStyle : TextStyle,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    cursorColor : Color = Color.Black
) {



    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = modifier
            .clip(shape)
            .border(
                border = borderStroke,
                shape = shape
            )
            .background(background)
            .padding(start = 10.dp, end = 10.dp, top = 6.dp, bottom = 6.dp)
    ) {

        BasicTextField(
            value = text,
            onValueChange = {
                onValueChange(it)
            },
            textStyle = textFieldStyle,
            cursorBrush = SolidColor(cursorColor),
            keyboardOptions = keyboardOptions

        )

        if (text == ""){
            Text(
                text = hint ,
                style = hintStyle
            )
        }

    }
}


@Preview
@Composable
fun AlphaTextField_preview() {
    AlphaTextField(
        text = "",
        onValueChange = {

        },
        hint = "hint",
        hintStyle = TextStyle(),
        textFieldStyle = TextStyle(),
    )
}