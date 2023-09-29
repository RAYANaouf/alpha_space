package com.example.alphaspace.Model.data.TextStyles

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import com.example.alphaspace.ui.theme.textColor1
import com.example.alphaspace.ui.theme.textColor2

object textStyles {

    val textStyle_size1 : TextStyle =
        TextStyle(
            color = textColor1,
            fontWeight = FontWeight.W500,
            fontSize = TextUnit(26f , TextUnitType.Sp)
        )

    val textStyle_size2 : TextStyle =
        TextStyle(
            color = textColor1,
            fontWeight = FontWeight.W500,
            fontSize = TextUnit(22f , TextUnitType.Sp)
        )

    val textStyle_size3 : TextStyle =
        TextStyle(
            color = textColor1,
            fontWeight = FontWeight.W500,
            fontSize = TextUnit(18f , TextUnitType.Sp)
        )

    val textFieldStyle : TextStyle =
        TextStyle(
            color = textColor1,
            fontWeight = FontWeight.W500,
            fontSize = TextUnit(28f , TextUnitType.Sp)
        )

    val hintStyle : TextStyle =
        TextStyle(
            color = textColor2,
            fontWeight = FontWeight.W500,
            fontSize = TextUnit(28f , TextUnitType.Sp)
        )
}
