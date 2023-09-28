package com.example.alphaspace.screens.mainScreens.profileScreen.component.slots

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SideCard_Slot(modifier: Modifier = Modifier , title : String , content : @Composable ()-> Unit) {
    Column(modifier = modifier) {
        Text(
            text = "$title" ,
            style = TextStyle(fontSize = MaterialTheme.typography.headlineMedium.fontSize)
        )

        Spacer(modifier = Modifier.height(16.dp))

        content()
    }

}

@Preview(heightDp = 500 , widthDp = 200)
@Composable
fun SideCard_Slot_preview() {
    SideCard_Slot(title = "work time", content = {})
}