package com.example.alphaspace.Model.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User (
    @PrimaryKey(autoGenerate = true )
    @ColumnInfo(name = "user_id")
    val userId : Long = 0 ,

    @ColumnInfo(name = "first_name")
    val firstName : String,

    @ColumnInfo(name = "last_name")
    val lastName : String,

    val age : Int ,

    val sex : String,

    @ColumnInfo(name = "phone_number")
    val phoneNumber : Int,

    @ColumnInfo(name = "google_account_id")
    val googleAccountId : String,

    //should be WorkingTime class contain hour and minute of opening and closing the store

    @ColumnInfo(name = "opening_hour")
    val openingHour : Int,

    @ColumnInfo(name = "opening_minute")
    val openingMinute : Int,

    @ColumnInfo(name = "closing_hour")
    val closingHour : Int,

    @ColumnInfo(name = "closing_minute")
    val closingMinute : Int,

    val image : String = "",

    val followers : Int = 0,

    val clients : Int = 0
)