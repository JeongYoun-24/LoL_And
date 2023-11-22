package com.example.lol_lain

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.bumptech.glide.Glide
import com.example.lol_lain.data.RuneData
import com.example.lol_lain.databinding.ActivityMyRuneBinding
import com.google.android.material.navigation.NavigationView
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

class My_RuneActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private val binding by lazy { ActivityMyRuneBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 소환사 정보 액티비티로 이동하는 버튼 이벤트
        val intent1 = Intent(this, LoLActivity::class.java)
        binding.SumBtn.setOnClickListener{startActivity(intent1)}

//        https://ddragon.leagueoflegends.com/cdn/img/perk-images/Styles/7200_Domination.png
        val url = "https://ddragon.leagueoflegends.com/cdn/img/perk-images/Styles"+"/7200_Domination"+".png"
        Glide.with(this).load(url).placeholder(R.drawable.frame).error(R.drawable.error).into(binding.RuneImg1)
        val url2 = "https://ddragon.leagueoflegends.com/cdn/img/perk-images/Styles"+"/7201_Precision"+".png"
        Glide.with(this).load(url2).placeholder(R.drawable.frame).error(R.drawable.error).into(binding.RuneImg2)
        val url3 = "https://ddragon.leagueoflegends.com/cdn/img/perk-images/Styles"+"/7202_Sorcery"+".png"
        Glide.with(this).load(url3).placeholder(R.drawable.frame).error(R.drawable.error).into(binding.RuneImg3)
        val url4 = "https://ddragon.leagueoflegends.com/cdn/img/perk-images/Styles"+"/7203_Whimsy"+".png"
        Glide.with(this).load(url4).placeholder(R.drawable.frame).error(R.drawable.error).into(binding.RuneImg4)
        val url5 = "https://ddragon.leagueoflegends.com/cdn/img/perk-images/Styles"+"/7204_Resolve"+".png"
        Glide.with(this).load(url5).placeholder(R.drawable.frame).error(R.drawable.error).into(binding.RuneImg5)


        binding.RuneName1.text = "지배"
        binding.RuneName2.text = "정밀"
        binding.RuneName3.text = "마법"
        binding.RuneName4.text = "영감"
        binding.RuneName5.text = "결의"

        val thread = NetworkThread()
        thread.start()
        thread.join()


        binding.btnNavi.setOnClickListener(){
            binding.layoutDrawer.openDrawer(GravityCompat.START) // START : left  END : right
        }
        binding.navieView.setNavigationItemSelectedListener(this)

       /* val profileList9 = arrayListOf(  // 리사이클뷰 더비 데이터
            // 9번째 줄
            RuneData(,"말파이트","","","")
        )*/


//        binding.RuneList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
//        binding.RuneList.setHasFixedSize(true)
//        binding.RuneList.adapter = ProfileAdapter(profileList)

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


        binding.layoutDrawer.closeDrawers() //네이게이션 닫기
        return false
    }



    inner class NetworkThread(): Thread(){ // 스레드로 url api 정보 받아오기
        override fun run() {


            val id = intent.getStringExtra("id")
            // API 정보를 가지고 있는 주소
            val site = "https://ddragon.leagueoflegends.com/cdn/13.22.1/data/ko_KR/runesReforged.json"

            val url = URL(site)
            val conn = url.openConnection()
            val input = conn.getInputStream()
            val isr = InputStreamReader(input)
            // br: 라인 단위로 데이터를 읽어오기 위해서 만듦
            val br = BufferedReader(isr)
            Log.d("값을 찾아줘",br.toString())
            // Json 문서는 일단 문자열로 데이터를 모두 읽어온 후, Json에 관련된 객체를 만들어서 데이터를 가져옴
            var str: String? = null
            val buf = StringBuffer()
            Log.d("값을 찾아줘",buf.toString())
            do{
                str = br.readLine()
                if(str!=null){ buf.append(str) }
            }while (str!=null)
            // 전체가 객체로 묶여있기 때문에 객체형태로 가져옴
            val root = JSONArray(buf.toString())
            Log.d("룬정보",root.toString())
            val response = root.getJSONObject(0).getString("slots")
            Log.d("룬정보",response)


//            val data2 = response.getJSONArray("runes")

//            Log.d("룬정보",data2.toString())

            val profileList9 = arrayListOf(  // 리사이클뷰 더비 데이터
                // 9번째 줄
                RuneData()
            )



            // 화면에 출력
            runOnUiThread {
                // 페이지 수만큼 반복하여 데이터를 불러온다.
                for(i in 0 until 4){
                    // 쪽수 별로 데이터를 읽는다.
                    val jObject = root.getJSONObject(i)
                    val jsonData = jObject.getJSONArray("slots")
                    val jso = JSONObject()
                    jso.put("runes",jsonData.getString(i))
                    Log.d("ssdasdas",jso.getString("runes"))




                }
                binding.datail1.text = "강력한 피해와 빠른 접근 강화\n 기본공격 위주의 딜러(ADC) \n 암살자"
                binding.datail2.text = "공격 강화 및 지속적 피해 강화\n 콤보를 통한 스킬 연계가 핵심인 챔피언 \n 순간 딜링 의존도가 높은 일부 메이지 \n 전사,원거리딜러"
                binding.datail3.text = "스킬 및 광역 효과 강화\n 기동성이 필요한 일부 전사 \n 견제에 능한 서포터 \n 대부분의 마법사"
                binding.datail4.text = "다양한 방식의 전투 보조 능력 강화\n 영감의 하위 룬이 필요한 챔피언 \n 유틸리티를 필요로 하는 챔피언"
                binding.datail5.text = "내구력 및 군중 제어 능력 강화\n 수비적인 플레이나 탱커형 서포터 \n 탱커"



            }


        }
        // 함수를 통해 데이터를 불러온다.
        fun JSON_Parse(obj: JSONObject, data : String): String {
            // 원하는 정보를 불러와 리턴받고 없는 정보는 캐치하여 "없습니다."로 리턴받는다.
            return try { obj.getString(data)
            } catch (e: Exception) {
                "없습니다."
            }
        }
    }

}