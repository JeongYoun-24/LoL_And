package com.example.lol_lain


import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.example.lol_lain.databinding.ActivityLoLdetailBinding
import com.google.android.material.navigation.NavigationView
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

var text2 = ""
var index = 0
class LoL_DetailActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener{
    private val binding by lazy { ActivityLoLdetailBinding.inflate(layoutInflater) }
    lateinit var imgView : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        // 소환사 정보 액티비티 이동
        val intent1 = Intent(this, LoLActivity::class.java)
        binding.SumBtn.setOnClickListener{startActivity(intent1)}

        binding.skilName.text = ""
        binding.skilDetail.text = ""

        // 챔피언정보 액티비티에서 받아온 인텐트 에 객체정보를 받아 변환
        val bitmap: Bitmap? = intent.getParcelableExtra("gender")

        Log.d("이미지값??",bitmap.toString())

//        older.gender.setImageResource(profileList.get(position).gender)
        // 챔피언 정보 이미지 값
       binding.ivProfile2.setImageBitmap(bitmap)

        // 챔피언 정보 이름,라인,스토리 ,
        binding.tvName2.text = intent.getStringExtra("name")
        binding.tvLain2.text = intent.getStringExtra("lain")
        binding.detail.text = intent.getStringExtra("detail")


        // 챔피언 의 아이디값을 인텐트로  받음
        val id = intent.getStringExtra("id")

        val Imgurl = "https://raw.communitydragon.org/latest/plugins/rcp-fe-lol-static-assets/global/default/images/nav-icon-profile.svg"
//        Glide.with(this).load(Imgurl).placeholder(R.drawable.frame).error(R.drawable.error).into(binding.SumBtn)


        // 인텐트로 받아온 아이디 값으로 챔피언 스킬이미지 api url로 들고오기
        val url = "https://ddragon.leagueoflegends.com/cdn/13.22.1/img/spell/"+id+"Q"+".png"
        Glide.with(this).load(url).placeholder(R.drawable.frame).error(R.drawable.error).into(binding.qimg)
        val url2 = "https://ddragon.leagueoflegends.com/cdn/13.22.1/img/spell/"+id+"W"+".png"
        Glide.with(this).load(url2).placeholder(R.drawable.frame).error(R.drawable.error).into(binding.wimg)
        val url3 = "https://ddragon.leagueoflegends.com/cdn/13.22.1/img/spell/"+id+"E"+".png"
        Glide.with(this).load(url3).placeholder(R.drawable.frame).error(R.drawable.error).into(binding.eimg)
        val url4 = "https://ddragon.leagueoflegends.com/cdn/13.22.1/img/spell/"+id+"R"+".png"
        Glide.with(this).load(url4).placeholder(R.drawable.frame).error(R.drawable.error).into(binding.rimg)


        // 네비게이션 설정 
        binding.btnNavi.setOnClickListener(){
            binding.layoutDrawer1.openDrawer(GravityCompat.START) // START : left  END : right
        }
        binding.navieView.setNavigationItemSelectedListener(this)

//        binding.SkilDetail.text =
        val index1 = 0
        val thread = NetworkThread(index1)
        thread.start()
        thread.join()

        
        // 챔피언 스킬 설명 (인덱스 번호로 순서에 맞는 정보 받아오기)
        binding.qimg.setOnClickListener {
            binding.skilDetail.text = ""
            val index1 = 0
            val thread = NetworkThread(index1)
            thread.start()
            thread.join()
        }
        binding.wimg.setOnClickListener {
            val index1 = 1
            binding.skilDetail.text = ""
            val thread = NetworkThread(index1)
            thread.start()
            thread.join()
        }
        binding.eimg.setOnClickListener {
            val index1 = 2
            binding.skilDetail.text = ""
            val thread = NetworkThread(index1)
            thread.start()
            thread.join()
        }
        binding.rimg.setOnClickListener {
            val index1 = 3
            binding.skilDetail.text = ""
            val thread = NetworkThread(index1)
            thread.start()
            thread.join()
        }




    }

    // 네이게이션 메뉴 아이템 클릭시 수행 메서드
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this, LoginActivity::class.java)
        val intent2 = Intent(this, MainActivity::class.java)
        val intent3 = Intent(this, My_Champion::class.java)
        val intent4 = Intent(this, My_RuneActivity::class.java)
        val intent5 = Intent(this, My_ItemListActivity::class.java)

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
    override fun onBackPressed() {
        if(binding.layoutDrawer1.isDrawerOpen(GravityCompat.START)){
            binding.layoutDrawer1.closeDrawers()
        }else{

        }
        super.onBackPressed()
    }


    class CustemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gender = itemView.findViewById<ImageView>(R.id.iv_profile) // 성별
    }



    inner class NetworkThread(val index1 :Int): Thread(){ // 스레드로 url api 정보 받아오기
        override fun run() {
           
            Log.d("버튼에서 받은값",index1.toString())
            
            val id = intent.getStringExtra("id")
            Log.d("sdasdsad",id.toString())

            // API 정보를 가지고 있는 주소
            val site = "https://ddragon.leagueoflegends.com/cdn/13.22.1/data/ko_KR/champion/"+id+".json"
            val url = URL(site)
            val conn = url.openConnection()
            val input = conn.getInputStream()
            val isr = InputStreamReader(input)
            // br: 라인 단위로 데이터를 읽어오기 위해서 만듦
            val br = BufferedReader(isr)
            // Json 문서는 일단 문자열로 데이터를 모두 읽어온 후, Json에 관련된 객체를 만들어서 데이터를 가져옴
            var str: String? = null
            val buf = StringBuffer()
            do{
                str = br.readLine()
                if(str!=null){ buf.append(str) }
            }while (str!=null)
            // 전체가 객체로 묶여있기 때문에 객체형태로 가져옴
            val root = JSONObject(buf.toString())
            Log.d("스킬JSON데이터1",root.toString())
            val response = root.getJSONObject("data").getJSONObject("${id}")

            val data2 = response.getJSONArray("spells")
            Log.d("스킬JSON데이터1",response.toString())
            Log.d("스킬JSON데이터2",response.getString("spells"))
            Log.d("스킬JSON데이터3",response.getString("allytips"))
            Log.d("스킬JSON데이터4",data2.getString(index1))
            // 화면에 출력
            runOnUiThread {
                // 페이지 수만큼 반복하여 데이터를 불러온다.
                for(i in 0 until data2.length()){
                    // 쪽수 별로 데이터를 읽는다.
                    val jObject = data2.getJSONObject(index1)
                    binding.skilName.text = "${jObject.getString("name")}"
                    binding.skilDetail.text = "${jObject.getString("description")}"

                }
            }
        }
        // 함수를 통해 데이터를 불러온다.
        fun JSON_Parse(obj:JSONObject, data : String): String {
            // 원하는 정보를 불러와 리턴받고 없는 정보는 캐치하여 "없습니다."로 리턴받는다.
            return try { obj.getString(data)
            } catch (e: Exception) {
                "없습니다."
            }
        }
    }


}





