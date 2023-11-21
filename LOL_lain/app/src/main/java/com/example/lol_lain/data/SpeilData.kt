package com.example.lol_lain.data

import android.graphics.drawable.Drawable
import android.net.Uri
import retrofit2.http.Url

data class SpeilData(
    val img : Int,
    val id  : String,
    val name  : String,
    val description : String,
    val tooltip :String,
    val cooldown : String

)
