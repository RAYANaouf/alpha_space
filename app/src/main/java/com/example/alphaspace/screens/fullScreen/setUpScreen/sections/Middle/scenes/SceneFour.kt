package com.example.alphaspace.screens.fullScreen.setUpScreen.sections.Middle.scenes

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.alphaspace.Model.data.TextStyles.textStyles
import com.example.alphaspace.Model.data.storeTypes.allStoreTypes
import com.example.alphaspace.Model.room.entities.StoreType
import com.example.alphaspace.Model.viewModel.AlphaSetUpViewModel
import com.example.alphaspace.R
import com.example.alphaspace.ui.theme.CustomBlack0
import com.example.alphaspace.ui.theme.CustomGray0
import com.example.alphaspace.ui.theme.CustomWhite0
import com.example.alphaspace.ui.theme.blue2

@Composable
fun SceneFour(
    modifier: Modifier = Modifier ,
    storeTypes : List<StoreType> = allStoreTypes.storeType
) {


    val viewModel : AlphaSetUpViewModel = viewModel()



    Column(modifier = modifier) {
        Header()

        Spacer(modifier = Modifier.height(36.dp))

        LazyVerticalGrid(
            columns =  GridCells.Adaptive(minSize = 150.dp),
            contentPadding = PaddingValues(bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
        ){
            items(storeTypes){storeType->

                Item(
                    img = storeType.img ,
                    txt =storeType.txt ,
                    selected = search(viewModel.storeTypes , storeType),
                    onClick = {
                        if (it){
                            viewModel.storeTypes.add(storeType)
                        }
                        else{
                            viewModel.storeTypes.remove(storeType)
                        }
                    }
                )
            }
        }
    }

}

fun search(storeTypes: List<StoreType>, storeType : StoreType) : Boolean{
    storeTypes.forEach(){
        if (it == storeType){
            return true
        }
    }
    return false
}


@Composable
fun Header(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .height(40.dp)
    ) {
        Divider(modifier = Modifier
            .height(2.dp)
            .weight(1f) , color = blue2)

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxHeight()
        ) {

            Divider(modifier = Modifier
                .fillMaxHeight(0.25f)
                .width(2.dp) , color = blue2)

            Spacer(modifier = Modifier.width(2.dp))

            Divider(modifier = Modifier
                .fillMaxHeight(0.5f)
                .width(2.dp) , color = blue2)

            Spacer(modifier = Modifier.width(2.dp))

            Divider(modifier = Modifier
                .fillMaxHeight(0.75f)
                .width(2.dp) , color = blue2)

            Spacer(modifier = Modifier.width(2.dp))

            Divider(modifier = Modifier
                .fillMaxHeight(1f)
                .width(2.dp) , color = blue2)

        }

        Spacer(modifier = Modifier.width(16.dp))

        Text(text = "What kind your store is" , style = textStyles.textStyle_size2.copy(color = CustomBlack0))

        Spacer(modifier = Modifier.width(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxHeight()
        ) {

            Divider(modifier = Modifier
                .fillMaxHeight(1f)
                .width(2.dp) , color = blue2)

            Spacer(modifier = Modifier.width(2.dp))

            Divider(modifier = Modifier
                .fillMaxHeight(0.75f)
                .width(2.dp) , color = blue2)

            Spacer(modifier = Modifier.width(2.dp))

            Divider(modifier = Modifier
                .fillMaxHeight(0.5f)
                .width(2.dp) , color = blue2)

            Spacer(modifier = Modifier.width(2.dp))

            Divider(modifier = Modifier
                .fillMaxHeight(0.25f)
                .width(2.dp) , color = blue2)

        }

        Divider(modifier = Modifier
            .height(2.dp)
            .weight(1f) , color = blue2)
    }
}

@Composable
fun Item(
    @DrawableRes img : Int,
    @StringRes   txt : Int,
    selected : Boolean ,
    onClick : (Boolean)->Unit = {},
    modifier: Modifier = Modifier
) {

    var _selected by remember{ mutableStateOf(selected) }

    Surface(
        shadowElevation = if (selected) 6.dp else 2.dp,
        shape = RoundedCornerShape(12.dp),
        border = if (selected) BorderStroke(2.dp, color = blue2) else BorderStroke(1.dp, color = CustomGray0),
        color = CustomWhite0,
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .clickable {
                _selected = !_selected
                onClick(_selected)
            }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .size(150.dp)
        ) {
            Image(
                painter = painterResource(id = img),
                contentDescription = stringResource(id = R.string.shoes_Store),
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .weight(1f)
                    .size(90.dp)
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = stringResource(id = txt),
                style = textStyles.textStyle_size3.copy(color = blue2 , textAlign = TextAlign.Center),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            )
        }
    }
}

@Preview
@Composable
fun SceneFour_preview() {
    SceneFour()
}


@Preview
@Composable
fun Item_preview() {
    Item(
        img = R.drawable.shoes,
        txt = R.string.shoes_Store,
        selected = true
    )
}

