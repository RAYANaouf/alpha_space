package com.example.alphaspace.screens.storeScreen.sections


import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.alphaspace.Model.types.Command
import com.example.alphaspace.Model.types.CommandBundel
import com.example.alphaspace.R
import com.example.alphaspace.ui.theme.CustomWhite_background
import com.example.alphaspace.ui.theme.categoryIcons_content
import com.example.alphaspace.ui.theme.color4
import com.example.alphaspace.ui.theme.color5
import com.example.alphaspace.ui.theme.iconColor_border_p1
import com.example.alphaspace.ui.theme.textColor1

@Composable
fun CommandSection(
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Surface(
            color = color4,
            shadowElevation = 8.dp,
            shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
            border = BorderStroke(
                width = 1.dp,
                color = iconColor_border_p1,
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(1f)
            ) {
                CommandSectionHeader()

                LazyColumn(
                    modifier = Modifier.weight(1f)
                ){
                    items(3){
                        CommandSectionItemGroup()
                    }
                }

                CommandSectionFooter()
            }
        }
    }
}


@Composable
fun CommandSectionHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .background(CustomWhite_background)
    ) {
        Text(
            text = "Commands",
            style = TextStyle(
                color = categoryIcons_content,
                fontSize = TextUnit(22f , TextUnitType.Sp),
                fontWeight = FontWeight.W600,
            )
        )
    }

    Divider(
        color = iconColor_border_p1,
        modifier = Modifier
            .height(1.dp)
            .fillMaxWidth()
    )
}

@Composable
fun CommandSectionFooter() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(25.dp)
    ) {
        Divider(
            color = iconColor_border_p1,
            modifier = Modifier
                .width(25.dp)
                .height(2.dp)
        )
    }
}


@Composable
fun CommandSectionItemGroup(
    commandBundle : CommandBundel = CommandBundel()
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "by  ${commandBundle.employee}",
            style = TextStyle(
                color = textColor1,
                fontSize = TextUnit(18f , TextUnitType.Sp),
                fontWeight = FontWeight.W500
            ),
            modifier = Modifier.padding(start = 26.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        commandBundle.commands.forEach {commande->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(26.dp)
                ) {
                    Spacer(modifier = Modifier
                        .width(1.dp)
                        .fillMaxHeight()
                        .background(iconColor_border_p1))
                }

                CommandSectionItem(
                    command = commande,
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier
                    .width(16.dp)
                    .fillMaxHeight())

            }
        }
    }
}

@Composable
fun CommandSectionItem(
    modifier: Modifier = Modifier,
    command : Command = Command(),
) {
    Surface(
        color = CustomWhite_background,
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(
            width = 0.5.dp,
            color = iconColor_border_p1
        ),
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.height(80.dp)
        ) {
            Image(
                painter = painterResource(id = command.img),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(120.dp)
                    .fillMaxHeight()
            )

            Divider(
                color = iconColor_border_p1,
                modifier = Modifier.width(0.5.dp).fillMaxHeight()
            )

            Column(
                modifier = Modifier.padding(start = 12.dp)
            ) {
                Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(
                        text = "Name : ${command.name}",
                        style = TextStyle(
                            color = textColor1,
                            fontSize = TextUnit(14f , TextUnitType.Sp),
                            fontWeight = FontWeight.W500
                        )
                    )
                }
//
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(
                        text = "Num : ${command.num}",
                        style = TextStyle(
                            color = textColor1,
                            fontSize = TextUnit(14f , TextUnitType.Sp),
                            fontWeight = FontWeight.W500
                        ),
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = "Color: ${command.color}",
                        style = TextStyle(
                            color = textColor1,
                            fontSize = TextUnit(14f , TextUnitType.Sp),
                            fontWeight = FontWeight.W500
                        ),
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}



@Preview(widthDp = 350 , heightDp = 450)
@Composable
fun CommandSection_preview() {
    CommandSection()
}

@Preview
@Composable
fun CommandSectionHeader_preview() {
    CommandSectionHeader()
}

@Preview
@Composable
fun CommandSectionItemGroup_preview() {
    Surface(color = color4) {
        CommandSectionItemGroup()
    }
}

@Preview(heightDp = 90)
@Composable
fun CommandSectionItem_preview() {
    CommandSectionItem()
}

