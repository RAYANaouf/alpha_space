package com.example.alphaspace.screens.mainScreens.storeScreen.sections

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.alphaspace.ui.theme.CustomWhite0
import com.example.alphaspace.ui.theme.categoryIcons_background
import com.example.alphaspace.ui.theme.categoryIcons_border
import com.example.alphaspace.ui.theme.categoryIcons_content

@Composable
fun PriceSection(
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize(1f)
                .padding(16.dp)
        ) {

            Surface(
                shape = RoundedCornerShape(12.dp),
                color = CustomWhite0,
                border = BorderStroke(width = 2.dp , color = categoryIcons_border),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                        .weight(4f)
                    ) {
                        Text(
                            text = "1500,00",
                            style = TextStyle(
                                color = categoryIcons_content,
                                fontSize = TextUnit(32f , TextUnitType.Sp),
                                fontWeight = FontWeight.W400
                            )
                        )
                    }
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Text(
                            text = "DA",
                            style = TextStyle(
                                color = categoryIcons_content,
                                fontSize = TextUnit(34f , TextUnitType.Sp),
                                fontWeight = FontWeight.W700
                            )
                        )
                    }
                }
            }
            
            
            Spacer(modifier = Modifier.height(26.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
            ) {
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = Color.Transparent,
                    border = BorderStroke(width = 2.dp , color = categoryIcons_border),
                    modifier = Modifier
                        .weight(2f)
                        .height(55.dp)
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = "CANCEL",
                            style = TextStyle(
                                color = categoryIcons_content,
                                fontSize = TextUnit(20f , TextUnitType.Sp),
                                fontWeight = FontWeight.W600,
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.weight(1f))

                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = Color.Transparent,
                    border = BorderStroke(width = 2.dp , color = categoryIcons_border),
                    modifier = Modifier
                        .weight(2f)
                        .height(55.dp)
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.background(categoryIcons_background)
                    ) {
                        Text(
                            text = "SELL",
                            style = TextStyle(
                                color = categoryIcons_content,
                                fontSize = TextUnit(20f , TextUnitType.Sp),
                                fontWeight = FontWeight.W600,
                            )
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PriceSection_preview() {
    PriceSection()
}