package com.example.alphaspace.Model.types

import com.example.alphaspace.R

data class CommandBundel (
    val employee : String        = "rayan",
    val commands : List<Command> = listOf(
        Command(img = R.drawable.pumma,name = "pumma one" , num = 1 , color = "White"),
        Command(img = R.drawable.tn, name = "TN BRI" , num = 2 , color = "Blue/Red")
    )
    )