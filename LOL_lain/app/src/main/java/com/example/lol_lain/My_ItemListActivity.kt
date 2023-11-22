package com.example.lol_lain

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lol_lain.adpter.ChampionAdapters
import com.example.lol_lain.adpter.ItemAadpter
import com.example.lol_lain.data.ItemListData
import com.example.lol_lain.data.RuneData
import com.example.lol_lain.data.SpeilData
import com.example.lol_lain.databinding.ActivityMyItemListBinding
import com.example.lol_lain.databinding.ActivityMyRuneBinding
import com.google.android.material.navigation.NavigationView
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

class My_ItemListActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private val binding by lazy { ActivityMyItemListBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = Intent(this, LoLActivity::class.java)
        binding.SumBtn.setOnClickListener{startActivity(intent)}

        // 네비게이션 설정
        binding.btnNavi.setOnClickListener(){
            binding.layoutDrawer1.openDrawer(GravityCompat.START) // START : left  END : right
        }
        binding.navieView.setNavigationItemSelectedListener(this)

        val profileList = arrayListOf(  // 리사이클뷰 더비 데이터
            // 9번째 줄
            ItemListData("1001","장화","이동 속도 25","똥신","이동 속도가 약간 증가합니다.","300"),
            ItemListData("3072","피바라기","공격력 55 치명타 확률 20% 생명력 흡수 18% 탐식: 체력이 70% 이상일 경우 공격력이 증가합니다.","블써","공격력 및 생명력 흡수가 증가하며, 생명력 흡수가 최대 체력 이상으로 가능해집니다.","3400"),
            ItemListData("3074","굶주린 히드라","공격력 65 스킬 가속 25 생명력 흡수 10% 쪼개기:기본 공격과 스킬 사용 시 주변 적들에게 물리 피해를 입힙니다. 육식:미니언을 처치할 때마다 공격력을 획득하고 챔피언, 대형 몬스터, 공성 미니언 처치 시 2배 획득합니다. 사망 시 중첩의 60%만큼 잃습니다.","히드라","근접 공격으로 주변의 적에게 피해를 주면 체력이 회복됩니다.","3400"),
            ItemListData("3075","가시 갑옷","체력 350 방어력 70 가시:기본 공격에 맞으면 공격한 적에게 피해를 입히고, 대상이 챔피언일 경우의 고통스러운 상처를 남깁니다. 고통스러운 상처는 치유 및 회복 효과를 감소시킵니다.","가시","받은피해를 반사합니다.","2700"),
            ItemListData("3078","삼위일체","공격력 공격 속도 33% 체력 300 스킬 가속 20 삼중 공격:기본 공격 시 이동 속도가 상승합니다. 대상이 챔피언일 경우 기본 공격력이 증가하며, 이 효과는 중첩됩니다. 주문 검: 스킬을 사용하고 나면 다음 기본 공격 시 추가 피해를 입힙니다. 신화급 기본 지속 효과: 다른 모든 전설급 아이템에 공격력, 스킬 가속 및 이동 속도.","트포","취급주의: 이 아이템만 갖추면 '엄청난 피해'를 줄 수 있죠...","3333"),
            ItemListData("3083","워모그의 갑옷","체력 800 스킬 가속 10 기본 체력 재생 200% 워모그의 심장: 추가 체력이 1100 이상일 때, 6초 동안 피해를 입지 않으면 매초 체력을 회복합니다.","피돼지","체력과 체력 재생량이 대폭 상승합니다.","3000"),
            ItemListData("3084","강철심장","체력 800 기본 체력 재생 200% 스킬 가속 20 거인의 흡수:700의 사거리 내에 있는 챔피언을 상대로 3초 동안 강력한 공격을 충전합니다. 충전된 공격은 대상에게 125+최대 체력의 6%에 해당하는 추가 물리 피해를 입히고 피해량의 10%만큼 최대 체력을 얻습니다. 대상별 재사용 대기시간은 30초입니다. 신화급 기본 지속 효과: 다른 모든 전설급 아이템에 체력이 1% 증가하고 챔피언이  거대해집니다.뜨거운심장","","적을 처치하거나 어시스트를 올리면 체력이 회복됩니다.","3200"),
            ItemListData("3089","라바돈의 죽음모자","주문력 신비한 작품: 총 주문력이 40% 증가합니다.","데캡","주문력이 대폭 상승합니다.","3333"),
            ItemListData("3153","몰락한 왕의 검","공격력 40 공격 속도 25% 생명력 흡수 8% 안개의 검: 기본 공격 시 대상의 현재 체력에 비례한 물리 피해를 입힙니다. 흡수: 챔피언에게 3회 기본 공격을 가하면 마법 피해를 입히고 이동 속도를 훔칩니다. 아이템 성능은 근접 챔피언과 원거리 챔피언에게 각각 다르게 적용됩니다.","몰왕","상대의 체력에 비례하여 피해를 입히고, 상대의 이동 속도를 훔칠 수 있습니다.","3300"),
            ItemListData("3157","존야의 모래시계","주문력 80 방어력 45 스킬가속 15 사용 시 경직: 2.5초 동안 무적 및 대상으로 지정할 수 없는 상태</status>가 되지만, 그동안 아무런 행동도 할 수 없습니다","존야","사용하면 아무런 행동도 취할 수 없는 대신 공격도 받지 않는 무적 상태가 됩니다.","3000"),

            )



        binding.itemList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.itemList.setHasFixedSize(true)
        binding.itemList.adapter = ItemAadpter(profileList)







//        val thread = NetworkThread()
//        thread.start()
//        thread.join()
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

    private fun httpJsonConnertion(){



    }

    inner class NetworkThread(): Thread(){ // 스레드로 url api 정보 받아오기
        override fun run() {


            val id = intent.getStringExtra("id")
            // API 정보를 가지고 있는 주소
            val site = "https://ddragon.leagueoflegends.com/cdn/13.22.1/data/ko_KR/item.json"

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
            val root = JSONObject(buf.toString())
            Log.d("아이템JSON",root.toString())


            val response = root.getJSONObject("data")
            Log.d("1223",response.toString())

            for (i in 0 until response.length()){
            var idKey = 1001
                idKey += i




            }


//            val data2 = response.getJSONObject("1004")
//            Log.d("3443",data2.toString())
//
//            val data3 = data2.getString("gold")
//            Log.d("3443323",data3.toString())




//        for (i in 0 until response.length()){
//            val response = root.getJSONObject("data")
//            Log.d("아이템JSON데이터 ",response.toString())
//
//            val dd = response.getJSONArray(i.toString())
//            Log.d("??",dd.toString())
//        }




            // 화면에 출력
            runOnUiThread {
                // 페이지 수만큼 반복하여 데이터를 불러온다.
                for(i in 0 until 4){
                    // 쪽수 별로 데이터를 읽는다.
//                    val jObject = root.getJSONObject("data")
//                    val jsonData = jObject.getJSONArray("slots")
//                    val jso = JSONObject()
//                    jso.put("runes",jsonData.getString(i))
//                    Log.d("ssdasdas",jso.getString("runes"))



                }
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


