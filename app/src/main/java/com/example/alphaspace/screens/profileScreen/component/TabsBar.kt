package com.example.alphaspace.screens.profileScreen.component

import android.graphics.Color.parseColor
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alphaspace.Model.data.ProfileTabs
import com.example.alphaspace.ui.theme.navigationRail_backgroundColor

@Composable
fun TabsBar(modifier: Modifier = Modifier, indicator : String = ProfileTabs.tabs[0], onClick : (tabName : String)->Unit = {}) {
    Surface(
        shape = CircleShape,
        modifier = modifier
            .fillMaxWidth(1f)
            .height(60.dp),
        color = Color.White,
        shadowElevation = 1.dp
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
        ){

            ProfileTabs.tabs.forEachIndexed {index,s ->
                Box (
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(1f)
                        .clickable { onClick(s) }
                ){
                    Text(text = "$s")
                    if (s == indicator){
                        Divider(modifier= Modifier
                            .height(4.dp)
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter), color = navigationRail_backgroundColor)
                    }
                }

                if (index != ProfileTabs.tabs.size-1){
                    Spacer(modifier = Modifier
                        .fillMaxHeight(0.4f)
                        .shadow(2.dp)
                        .width(0.35.dp)
                        .background(Color(parseColor("#888888"))))
                }

            }
        }
    }
}

@Preview
@Composable
fun TabsBar_preview() {
    TabsBar()
}