package com.example.alphaspace.Model.types

import com.example.alphaspace.R

data class Command(
    val img : Int = R.drawable.shoes2,
    val name : String  = "Shoes",
    val num  : Int     = 1 ,
    val color : String = "White"
)