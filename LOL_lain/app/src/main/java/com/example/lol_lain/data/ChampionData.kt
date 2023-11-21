package com.example.lol_lain.data

data class ChampionData(
    var page: Int,
    val data : ArrayList<data>
)

data class data(
    var id:String,
    var key: String ,
    var name: String ,
    var title: String,
    var blurb: String
)
