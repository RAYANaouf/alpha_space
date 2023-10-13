package com.example.alphaspace.screens.common.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alphaspace.Model.room.entities.Category
import com.example.alphaspace.ui.theme.categoryIcons_background
import com.example.alphaspace.ui.theme.categoryIcons_border
import com.example.alphaspace.ui.theme.categoryIcons_content



@Composable
fun CategoryHolder(
    modifier: Modifier = Modifier,
    category: Category
) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .size(80.dp)
            .background(categoryIcons_background)
            .border(width = 2.dp, color = categoryIcons_border, shape = RoundedCornerShape(12.dp))
    ) {
        Image(
            painter = painterResource(id = category.icon),
            contentDescription = "${category.name} category",
            modifier = Modifier
                .size(50.dp)
        )
    }

}

@Preview
@Composable
fun CategoryHolder_peview() {
    
}
