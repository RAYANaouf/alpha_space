package com.example.alphaspace.screens.mainScreens.profileScreen

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.alphaspace.Model.data.ProfileTabs
import com.example.alphaspace.Model.viewModel.AlphaViewModel
import com.example.alphaspace.screens.mainScreens.profileScreen.sections.mainSection
import com.example.alphaspace.screens.mainScreens.profileScreen.sections.sideSection
import com.example.alphaspace.ui.theme.AlphaSpaceTheme

@Composable
fun Profilecreen(
    viewModel : AlphaViewModel
) {
    Row() {
        /*********** the setup **************/
        var indicator by rememberSaveable {
            mutableStateOf(ProfileTabs.tabs[0])
        }
        /************************************/

        mainSection(
            Modifier.weight(0.65f),
            viewModel = viewModel,
            indicator = indicator,
            onIndicatorChange = {
                indicator = it
            }
        )

        sideSection(
            modifier = Modifier.weight(0.35f),
            viewModel = viewModel,
            indicator = indicator
        )
    }
}







@Preview(showBackground = true, heightDp = 800 , widthDp = 1200)
@Composable
fun Profilecreen_preview() {
    AlphaSpaceTheme{
        var context = LocalContext.current
        Surface(color = MaterialTheme.colorScheme.background) {
            Profilecreen(
                viewModel(
                    factory = object : ViewModelProvider.Factory{
                        override fun <T : ViewModel> create(modelClass: Class<T>): T {
                            if (modelClass.isAssignableFrom(AlphaViewModel::class.java)){
                                return AlphaViewModel(context) as T
                            }
                            else
                                throw IllegalArgumentException("can't create AlphaViewModel ")
                        }
                    }
                )
            )
        }
    }
}

