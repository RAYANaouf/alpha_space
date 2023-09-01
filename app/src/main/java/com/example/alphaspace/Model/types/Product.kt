package com.example.alphaspace.Model.types


data class Product(
    val id       : Int = 0,
    val price    : Int = 1500,
    val colors   : List<String> = listOf("Black","white","blue"),
    val date     : String       = "8/21/2023",
    val pointers : List<Int>    = listOf(36,37,38,39,40),
    val made_in  : String       = "algeria"
)