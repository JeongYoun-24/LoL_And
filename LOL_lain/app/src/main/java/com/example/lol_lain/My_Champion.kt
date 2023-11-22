package com.example.lol_lain

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.lol_lain.adpter.ChampionAdapters
import com.example.lol_lain.data.SpeilData
import com.example.lol_lain.databinding.ActivityMySpeilBinding
import com.google.android.material.navigation.NavigationView
import org.json.JSONObject
import org.json.JSONTokener
import java.io.IOException

var text = ""
class My_Champion : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private val binding by lazy { ActivityMySpeilBinding.inflate(layoutInflater) }

   // val retrofit = Retrofit.Builder().baseUrl("https://ddragon.leagueoflegends.com/cdn/10.6.1/data/ko_KR/champion.json").addConverterFactory(GsonConverterFactory.create()).build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 네비게이션 설정
        binding.btnNavi.setOnClickListener(){
            binding.layoutDrawer1.openDrawer(GravityCompat.START) // START : left  END : right
        }
        binding.navieView.setNavigationItemSelectedListener(this)

        // 소환사 정보 액티비티 이동 버튼
        val intent1 = Intent(this, LoLActivity::class.java)
        binding.SumBtn.setOnClickListener{startActivity(intent1)}



        val json = assets.open("data.json").reader().readText()
        val data = JSONObject(json).getJSONObject("data")
        Log.d("JSON데이터", data.toString())

        val data2 = data.getJSONObject("Aatrox")
        Log.d("json str", data2.getString("id"))

        val data3 = data2.getJSONObject("image")
        Log.d("json str", data3.getString("full"))


        val jsonObject = JSONTokener(json).nextValue() as JSONObject
        val jsonArray = jsonObject.getJSONObject("data")


        val jsonPeil = assets.open("speil.json").reader().readText()
        val dataList = JSONObject(jsonPeil).getJSONObject("data")

        val speilList = dataList.getJSONObject("SummonerBarrier")
        val speilList2 = dataList.getJSONObject("SummonerBoost")
        val speilList3 = dataList.getJSONObject("SummonerCherryFlash")
        val speilList4 = dataList.getJSONObject("SummonerCherryHold")
        val speilList5 = dataList.getJSONObject("SummonerDot")
        val speilList6 = dataList.getJSONObject("SummonerFlash")
        val speilList7 = dataList.getJSONObject("SummonerHaste")
        val speilList8 = dataList.getJSONObject("SummonerHeal")
        val speilList9 = dataList.getJSONObject("SummonerMana")
        val speilList10 = dataList.getJSONObject("SummonerSmite")
        val speilList11 = dataList.getJSONObject("SummonerSnowball")
        val speilList12 = dataList.getJSONObject("SummonerTeleport")


        Log.d("값확인3",speilList.getString("id"))
        Log.d("값확인3",speilList.getString("name"))
        Log.d("값확인3",speilList.getString("description"))
        Log.d("값확인3",speilList.getString("tooltip"))
        Log.d("값확인3",speilList.getString("cooldown"))

        val url5 = "https://ddragon.leagueoflegends.com/cdn/13.22.1/img/spell/SummonerBoost.png"
        val img =  Glide.with(this).load(url5).placeholder(R.drawable.frame).error(R.drawable.error)

        val profileList = arrayListOf(  // 리사이클뷰 더비 데이터
            // 9번째 줄
            SpeilData(R.drawable.malphite,"${speilList.getString("id")}","${speilList.getString("name")}","${speilList.getString("description")}", "${speilList.getString("tooltip")}","${speilList.getString("cooldown")}"),
            SpeilData(R.drawable.malphite,"${speilList2.getString("id")}","${speilList2.getString("name")}","${speilList2.getString("description")}", "${speilList2.getString("tooltip")}","${speilList2.getString("cooldown")}"),
            SpeilData(R.drawable.malphite,"${speilList3.getString("id")}","${speilList3.getString("name")}","${speilList3.getString("description")}", "${speilList3.getString("tooltip")}","${speilList3.getString("cooldown")}"),
            SpeilData(R.drawable.malphite,"${speilList4.getString("id")}","${speilList4.getString("name")}","${speilList4.getString("description")}", "${speilList4.getString("tooltip")}","${speilList4.getString("cooldown")}"),
            SpeilData(R.drawable.malphite,"${speilList5.getString("id")}","${speilList5.getString("name")}","${speilList5.getString("description")}", "${speilList5.getString("tooltip")}","${speilList5.getString("cooldown")}"),
            SpeilData(R.drawable.malphite,"${speilList6.getString("id")}","${speilList6.getString("name")}","${speilList6.getString("description")}", "${speilList6.getString("tooltip")}","${speilList6.getString("cooldown")}"),
            SpeilData(R.drawable.malphite,"${speilList7.getString("id")}","${speilList7.getString("name")}","${speilList7.getString("description")}", "${speilList7.getString("tooltip")}","${speilList7.getString("cooldown")}"),
            SpeilData(R.drawable.malphite,"${speilList8.getString("id")}","${speilList8.getString("name")}","${speilList8.getString("description")}", "${speilList8.getString("tooltip")}","${speilList8.getString("cooldown")}"),
            SpeilData(R.drawable.malphite,"${speilList9.getString("id")}","${speilList9.getString("name")}","${speilList9.getString("description")}", "${speilList9.getString("tooltip")}","${speilList9.getString("cooldown")}"),
            SpeilData(0,"${speilList10.getString("id")}","${speilList10.getString("name")}","${speilList10.getString("description")}", "${speilList10.getString("tooltip")}","${speilList10.getString("cooldown")}"),

        )

        binding.speilList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.speilList.setHasFixedSize(true)
        binding.speilList.adapter = ChampionAdapters(profileList)



    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this, LoginActivity::class.java)    // 로그인 액티비티
        val intent2 = Intent(this, MainActivity::class.java)    // 챔피언 정보 액티비티
        val intent3 = Intent(this, My_Champion::class.java)    // 소환사 스펠 액티비티
        val intent4 = Intent(this, My_RuneActivity::class.java) // 챔피언 룬 액티비티
        val intent5 = Intent(this, My_ItemListActivity::class.java) // 챔피언 룬 액티비티


        when(item.itemId){
            R.id.login -> startActivity(intent)
            R.id.champion -> startActivity(intent2)
            R.id.championSpell -> startActivity(intent3)
            R.id.championRune -> startActivity(intent4)
            R.id.championItem -> startActivity(intent5)


            R.id.login -> Toast.makeText(applicationContext,"로그인", Toast.LENGTH_LONG).show()


            R.id.champion -> Toast.makeText(applicationContext,"챔피언 정보", Toast.LENGTH_LONG).show()
            R.id.championSpell -> Toast.makeText(applicationContext,"새소식", Toast.LENGTH_LONG).show()
        }


        binding.layoutDrawer1.closeDrawers() //네이게이션 닫기
        return false
    }


fun getjson() :String?{
    val jsonString :String

    try {
        jsonString = assets.open("data.json").bufferedReader().use { it.readText() }


    }catch (ioException : IOException){
        ioException.printStackTrace()
        return null
    }


    return jsonString
}


}