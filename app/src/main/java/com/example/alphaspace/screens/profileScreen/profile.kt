package com.example.alphaspace.screens.profileScreen

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.alphaspace.Model.data.ProfileTabs
import com.example.alphaspace.screens.profileScreen.sections.mainSection
import com.example.alphaspace.screens.profileScreen.sections.sideSection
import com.example.alphaspace.ui.theme.AlphaSpaceTheme

@Composable
fun Profilecreen() {
    Row() {
        /*********** the setup **************/
        var indicator by rememberSaveable {
            mutableStateOf(ProfileTabs.tabs[0])
        }
        /************************************/

        mainSection(
            Modifier.weight(0.65f),
            indicator = indicator,
            onIndicatorChange = {
                indicator = it
            }
        )

        sideSection(
            Modifier.weight(0.35f),
            indicator = indicator
        )
    }
}







@Preview(showBackground = true, heightDp = 800 , widthDp = 1200)
@Composable
fun Profilecreen_preview() {
    AlphaSpaceTheme{
        Surface(color = MaterialTheme.colorScheme.background) {
            Profilecreen()
        }
    }
}

