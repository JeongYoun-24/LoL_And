package com.example.lol_lain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.lol_lain.databinding.ActivityLoLdetailBinding
import com.example.lol_lain.databinding.ActivityTextBinding

class TextAc : AppCompatActivity() {
    private val binding by lazy {
        ActivityTextBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        /*val url = "https://ddragon.leagueoflegends.com/cdn/13.22.1/img/spell/"+id+"Q"+".png"
        Glide.with(this).load(url).placeholder(R.drawable.frame).error(R.drawable.error).into(binding.qimg)
        val url2 = "https://ddragon.leagueoflegends.com/cdn/13.22.1/img/spell/"+id+"W"+".png"
        Glide.with(this).load(url2).placeholder(R.drawable.frame).error(R.drawable.error).into(binding.wimg)
        val url3 = "https://ddragon.leagueoflegends.com/cdn/13.22.1/img/spell/"+id+"E"+".png"
        Glide.with(this).load(url3).placeholder(R.drawable.frame).error(R.drawable.error).into(binding.eimg)
        val url4 = "https://ddragon.leagueoflegends.com/cdn/13.22.1/img/spell/"+id+"R"+".png"
        Glide.with(this).load(url4).placeholder(R.drawable.frame).error(R.drawable.error).into(binding.rimg)*/

    }
}