package com.example.lol_lain.data

import java.io.FileDescriptor

data class ItemListData(
    val id : String,
    val name : String,
    val description : String,
    val colloq : String,
    val plaintext : String,
    val base : String

//    val slots: ArrayList<gold?>?

)
data class gold (
    val base : Int,
    val sell : Int
)