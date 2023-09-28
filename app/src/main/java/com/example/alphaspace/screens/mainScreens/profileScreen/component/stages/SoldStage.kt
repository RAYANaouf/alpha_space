package com.example.alphaspace.screens.mainScreens.profileScreen.component.stages

import android.graphics.Color.parseColor
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alphaspace.R
import com.example.alphaspace.ui.theme.color4

@Composable
fun SoldStage(modifier: Modifier = Modifier , items : List<Int> = listOf(R.drawable.shoes , R.drawable.shoes2, R.drawable.shoes3,R.drawable.shoes4 , R.drawable.shoes5, R.drawable.shoes6,R.drawable.shoes7 , R.drawable.shoes8
    , R.drawable.shoes10,R.drawable.shoes11 , R.drawable.shoes12, R.drawable.shoes13)) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        LazyHorizontalGrid(
            rows = GridCells.Fixed(1),
            horizontalArrangement = Arrangement.spacedBy(18.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp) ,
            contentPadding = PaddingValues( start = 6.dp,end = 22.dp, bottom = 8.dp),
            modifier = Modifier.height(200.dp)) {
            items(items){ 
                SoldCard(it)
            }
        }
    }
}

@Composable
fun SoldCard(img : Int = R.drawable.shoes) {
    Surface(
        shadowElevation = 3.dp,
        shape = RoundedCornerShape(16.dp),
        color = Color.White
    ) {
        Box(
            modifier = Modifier
                .width(230.dp)
                .height(150.dp)
                .background(Color(parseColor("#fafafa")))
        ) {
            Column()
            {
                Image(
                    painter = painterResource(id = img),
                    contentDescription = "" ,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .weight(3f)
                        .fillMaxWidth()
                )
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(start = 8.dp)) {
                    Text(text = "1520DA" , style = TextStyle(fontSize = MaterialTheme.typography.bodyMedium.fontSize))

                    Text(text = "bla bla bla bla " , style = TextStyle(fontSize = MaterialTheme.typography.bodySmall.fontSize))
                }
            }
            Surface(
                modifier = Modifier
                    .align(Alignment.TopEnd),
                shape = RoundedCornerShape(bottomStart = 2.dp)
            ) {
                Box(
                    modifier = Modifier
                        .background(Color.Red)
                        .width(40.dp)
                        .height(25.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "-15%" , style = TextStyle(color = Color.White))
                }
            }
        }
    }
}




@Preview(widthDp = 350 , heightDp = 200)
@Composable
fun SoldCard_preview() {
    Surface(color = color4) {
       Box (contentAlignment = Alignment.Center){
           SoldCard()
       }
    }
}


@Preview(widthDp = 450)
@Composable
fun SoldStage_preview() {
    SoldStage()
}