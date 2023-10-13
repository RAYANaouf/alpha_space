package com.example.alphaspace.screens.common.dropDownMenu

import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.PopupProperties
import com.example.alphaspace.ui.theme.color5

@Composable
fun AlphaDropDownMenu(
    expanded : Boolean,
    items : List<String> ,
    onClick : (String)->Unit,
    onDismissRequest : ()->Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        color = color5
    ) {
        DropdownMenu(
            expanded = expanded ,
            onDismissRequest = { onDismissRequest() },
            properties = PopupProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
                clippingEnabled = true
            ),
            modifier = modifier
        ) {

            items.forEach {item->
                DropdownMenuItem(
                    text = {
                        Text(text = item)
                    },
                    onClick = {
                        onClick(item)
                    }
                )
            }

        }
    }
}

@Preview
@Composable
fun AlphaDropDownMenu_preview() {
    AlphaDropDownMenu(
        expanded = true ,
        onDismissRequest = {},
        items = listOf("Man","Woman"),
        onClick = {

        }
    )
}