package com.example.alphaspace.screens.mainScreens.profileScreen.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.alphaspace.Model.data.ProfileTabs
import com.example.alphaspace.Model.room.entities.StoreType
import com.example.alphaspace.Model.viewModel.AlphaViewModel
import com.example.alphaspace.R
import com.example.alphaspace.screens.fullScreen.setUpScreen.sections.Middle.scenes.Item
import com.example.alphaspace.screens.mainScreens.profileScreen.component.TabsBar
import com.example.alphaspace.screens.mainScreens.profileScreen.component.common.CategoryStage
import com.example.alphaspace.screens.mainScreens.profileScreen.component.profileHeader
import com.example.alphaspace.screens.mainScreens.profileScreen.component.slots.stage1_slot
import com.example.alphaspace.screens.mainScreens.profileScreen.component.stages.ClientStage
import com.example.alphaspace.screens.mainScreens.profileScreen.component.stages.EmployeesStage
import com.example.alphaspace.screens.mainScreens.profileScreen.component.stages.SoldStage
import com.example.alphaspace.ui.theme.AlphaSpaceTheme
import com.example.alphaspace.ui.theme.color4


@Composable
fun mainSection(modifier: Modifier = Modifier ,  viewModel : AlphaViewModel,  indicator : String , onIndicatorChange : (String)-> Unit) {
    LazyColumn(
        modifier = modifier
            .fillMaxHeight()
            .padding(start = 40.dp)
    ) {

        item {
            Spacer(modifier = Modifier.height(26.dp))
            profileHeader(
                viewModel = viewModel
            )

        }

        item {
            Spacer(modifier = Modifier.height(26.dp))

            TabsBar(
                indicator = indicator ,
                onClick = { tabName->
                    onIndicatorChange(tabName)
                }
            )
        }


        item {
            Spacer(modifier = Modifier.height(26.dp))
            if (indicator == ProfileTabs.tabs[0]){
                stage1_slot(
                    text = "Sold",
                    content = { SoldStage() }
                )
            }
            else if(indicator == ProfileTabs.tabs[1]){
                viewModel.userStoreTypes.forEachIndexed { index, storeType ->
                    CategoryStage(storeType = storeType)
                    if (index != viewModel.userStoreTypes.size-1){
                        Spacer(modifier = Modifier.height(50.dp))
                    }
                }
            }
            else if(indicator == ProfileTabs.tabs[2]){
                stage1_slot(
                    text = "All",
                    content = { ClientStage() }
                )
            }
            else if(indicator == ProfileTabs.tabs[3]){
                stage1_slot(
                    text = "All",
                    content = { EmployeesStage() }
                )
            }
            else if(indicator == ProfileTabs.tabs[4]){


                viewModel.getUserStoreTypes(
                    userId = viewModel.user?.userId ?: 0 ,
                    successCallBack = {

                    }
                )


                LazyVerticalGrid(
                    columns =  GridCells.Adaptive(minSize = 150.dp),
                    contentPadding = PaddingValues(bottom = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.heightIn(max = 350.dp)
                ){
                    items(viewModel.userStoreTypes){storeType->
                        Item(
                            img = storeType.img ,
                            txt =storeType.txt ,
                            selected = true,
                            onClick = {

                            }
                        )
                    }
                }
            }
        }


        item {
            Spacer(modifier = Modifier.height(26.dp))

            if (indicator == ProfileTabs.tabs[0]){
                stage1_slot(
                    text = "Original",
                    content = { SoldStage() }
                )
            }
        }

        item {
            Spacer(modifier = Modifier.height(26.dp))


            if (indicator == ProfileTabs.tabs[0]){
                stage1_slot(
                    text = "China",
                    content = { SoldStage() }
                )
            }

        }

        item {
            Spacer(modifier = Modifier.height(26.dp))

            if (indicator == ProfileTabs.tabs[0]){
                stage1_slot(
                    text = "Local",
                    content = { SoldStage() }
                )
            }
        }

    }
}

@Preview(heightDp = 450 , widthDp = 950)
@Composable
fun mainSection_preview1() {

    val context = LocalContext.current
    mainSection(indicator = "Home", onIndicatorChange = {},
        viewModel = viewModel(
            factory = object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    if (modelClass.isAssignableFrom(AlphaViewModel::class.java)){
                        return AlphaViewModel(context) as T
                    }
                    else
                        throw IllegalArgumentException("can't create AlphaViewModel (mainSection)")
                }
            }
        )
    )
}

@Preview(heightDp = 450 , widthDp = 950 )
@Composable
fun mainSection_preview2() {
    AlphaSpaceTheme() {
        val context = LocalContext.current
        Surface(color = color4) {
            mainSection(
                indicator = "Home" ,
                onIndicatorChange = {},
                viewModel = viewModel(
                    factory = object : ViewModelProvider.Factory{
                        override fun <T : ViewModel> create(modelClass: Class<T>): T {
                            if (modelClass.isAssignableFrom(AlphaViewModel::class.java)){
                                return AlphaViewModel(context) as T
                            }
                            else
                                throw IllegalArgumentException("can't create AlphaViewModel (mainSection)")
                        }
                    }
                )
            )
        }
    }
}


