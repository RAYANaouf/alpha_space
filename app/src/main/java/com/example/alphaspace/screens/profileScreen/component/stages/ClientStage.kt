package com.example.alphaspace.screens.profileScreen.component.stages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.alphaspace.R
import com.example.alphaspace.ui.theme.categoryIcons_background

@Composable
fun ClientStage(
    clients : List<String> = listOf("A++" , "A++" , "A++" , "A+" , "A" , "B" , "B" , "C" , "C" , "C" , "C" , "D" , "A++" , "A++" , "A++" , "A+" , "A" , "B" , "B" , "C" , "C" , "C" , "C" , "D"  ),
    clientsNames : List<String> = listOf("mohamed mekid" , "farhat makid" , "abdou gayed" , "rayan aouf" , "fodil gayed" , "achraf saidi" , "salh blile" , "salah bnhar", "salh blile" , "salah bnhar" , "mohamed mohamed" , "rayan dammad" , "mohamed mekid" , "farhat makid" , "abdou gayed" , "rayan aouf" , "fodil gayed" , "achraf saidi" , "salh blile" , "salah bnhar", "salh blile" , "salah bnhar" , "mohamed mohamed" , "rayan dammad"  ),
) {


    LazyVerticalGrid(
        columns = GridCells.Adaptive(80.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(18.dp),
        contentPadding = PaddingValues(start = 8.dp),
        modifier = Modifier.height(260.dp).fillMaxWidth()
    ){


        clients.forEachIndexed{index, grad ->
            item {
                ClientStageItem(grad , clientsNames[index])
            }

        }
    }
}

@Composable
fun ClientStageItem(
    grad : String = "grad",
    name : String = "the client name"
) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        shadowElevation = 4.dp,
        color = Color.White
    ) {
        Box(
            modifier = Modifier
                .height(120.dp)
                .width(80.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.client),
                contentDescription = "",
                modifier = Modifier
                    .background(categoryIcons_background)
                    .height(90.dp)
                    .fillMaxWidth()
            )

            Text(
                text = "$name",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(
                    fontSize = TextUnit(12f , TextUnitType.Sp),
                    textAlign = TextAlign.Justify,
                ),

                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .align(Alignment.BottomCenter)
                    .padding(start = 4.dp, top = 4.dp, end = 4.dp)
            )

            Box(
                modifier = Modifier
                    .background(Color.Red)
                    .align(Alignment.TopEnd)
            ) {
                Text(
                    text = "$grad",
                    style = TextStyle(fontSize = TextUnit(8f , TextUnitType.Sp)),
                    color = Color.White,
                    modifier = Modifier
                        .padding(4.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun ClientStage_preview() {
    ClientStage()
}

@Preview
@Composable
fun ClientStageItem_preview() {
    ClientStageItem()
}