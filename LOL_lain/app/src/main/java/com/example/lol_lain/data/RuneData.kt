package com.example.lol_lain.data


import com.squareup.moshi.Json

class RuneData : ArrayList<RuneData.RuneDataItem>(){
    data class RuneDataItem(
        @Json(name = "icon")
        val icon: String?,
        @Json(name = "id")
        val id: Int?,
        @Json(name = "key")
        val key: String?,
        @Json(name = "name")
        val name: String?,
        @Json(name = "slots")
        val slots: List<Slot?>?
    ) {
        data class Slot(
            @Json(name = "runes")
            val runes: List<Rune?>?
        ) {
            data class Rune(
                @Json(name = "icon")
                val icon: String?,
                @Json(name = "id")
                val id: Int?,
                @Json(name = "key")
                val key: String?,
                @Json(name = "longDesc")
                val longDesc: String?,
                @Json(name = "name")
                val name: String?,
                @Json(name = "shortDesc")
                val shortDesc: String?
            )
        }
    }
}