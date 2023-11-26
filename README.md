# LoL_And
안드로이드 프로젝트 

# 소개
라이엇 API 를 이용한 안드로이드 프로젝트 입니다.


# 제작기간 & 참여 인원
<UL>
  <LI>11/11~ 11/24</LI>
  <LI>개인 프로젝트</LI>
</UL>




# 사용기술
![js](https://img.shields.io/badge/kotlin-7F52FF?style=for-the-badge&logo=JavaScript&logoColor=white)
![js](https://img.shields.io/badge/androidstudio-3DDC84?style=for-the-badge&logo=JavaScript&logoColor=white)
![js](https://img.shields.io/badge/sqlite-003B57?style=for-the-badge&logo=JavaScript&logoColor=white)


# 핵심 기능 및 페이지 소개

<H3>메인 페이지</H3>
<BR>
<img src="https://github.com/JeongYoun-24/LoL_And/assets/126854252/9e7217a7-3cae-40a5-bd25-7791ad600935" height="350">
<img src="https://github.com/JeongYoun-24/LoL_And/assets/126854252/1e3ab237-3f94-419e-a27a-c2e1f37059b4" height="350">
<BR>

<BR>
<img src="https://github.com/JeongYoun-24/LoL_And/assets/126854252/6b936bf2-0e11-4e9c-9cd4-b7010cba509e" height="350" >
<BR>
<UL>
 <LI>기본 디폴트로 잡혀 있는 메인 페이지입니다. 
     메인 페이지는 챔피언 리스트를 리사이클뷰 어댑터를 통해 값을 전달하여 뿌려주고있습니다. 
     메인메이지 네비게이션 바를 만들어서 여러 액티비티 연결을 할수있도록 하였습니다.
 </LI>
</UL>

#메인액티비티 

<img src="https://github.com/JeongYoun-24/LoL_And/assets/126854252/306b05a3-005c-48ab-90f3-6312f3396c4b" height="350" >

---

#메인액티비티 코드 

<details>
 <summary> 코드가 길어 짧게 요약 
 
 </summary> 
 
 ```
      // 라이엇 url api 에서 이미지 받아오기
        val Imgurl = "https://raw.communitydragon.org/latest/plugins/rcp-fe-lol-parties/global/default/button-search-hover.png"
        Glide.with(this).load(Imgurl).placeholder(R.drawable.frame).error(R.drawable.error).into(binding.seletImg)
```

---

```
// 네이게이션 메뉴 아이템 클릭시 수행 메서드
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this, LoginActivity::class.java) // 로그인 액티비티
        val intent2 = Intent(this, MainActivity::class.java) // 메인 액티비티
        val intent3 = Intent(this, My_Champion::class.java) // 챔피언 스펠 액티비티
        val intent4 = Intent(this, My_RuneActivity::class.java) // 챔피언 룬 액티비티
        val intent5 = Intent(this, My_ItemListActivity::class.java) // 챔피언 룬 액티비티
        when(item.itemId){
            R.id.login -> startActivity(intent)
            R.id.champion -> startActivity(intent2)
            R.id.championSpell -> startActivity(intent3)
            R.id.championRune -> startActivity(intent4)
            R.id.championItem -> startActivity(intent5)
        }
        binding.layoutDrawer.closeDrawers() //네이게이션 닫기
        return false
    }
```

```
//리사이클 뷰 와 연결된 어댑터 와 데이터 
        //VERTICAL 세로 방향  HORIZONTAL 가로방향
        binding.rvProfile.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.rvProfile.setHasFixedSize(true)
        binding.rvProfile.adapter = ProfileAdapter(profileList)
```
</details>

---

#챔피언 상세설명 액티비티 

<img src="https://github.com/JeongYoun-24/LoL_And/assets/126854252/9e7ce638-7d88-4b89-b587-debe2e055dae" height="350" >

---
#메인 액티비티에서 받아온 인텐트에서 값을 꺼내 데이터 보여주기

<details>
 <summary> 상세설명 액티비티 코드
 
 </summary> 
 
 ```
// 챔피언정보 액티비티에서 받아온 인텐트 에 객체정보를 받아 변환
        val bitmap: Bitmap? = intent.getParcelableExtra("gender")
        Log.d("이미지값??",bitmap.toString())

        // 챔피언 정보 이미지 값
       binding.ivProfile2.setImageBitmap(bitmap)

        // 챔피언 정보 이름,라인,스토리 ,
        binding.tvName2.text = intent.getStringExtra("name")
        binding.tvLain2.text = intent.getStringExtra("lain")
        binding.detail.text = intent.getStringExtra("detail")

     // 챔피언 의 아이디값을 인텐트로  받음
        val id = intent.getStringExtra("id")

        // 인텐트로 받아온 아이디 값으로 챔피언 스킬이미지 api url로 들고오기
        val url = "https://ddragon.leagueoflegends.com/cdn/13.22.1/img/spell/"+id+"Q"+".png"
        Glide.with(this).load(url).placeholder(R.drawable.frame).error(R.drawable.error).into(binding.qimg)
        val url2 = "https://ddragon.leagueoflegends.com/cdn/13.22.1/img/spell/"+id+"W"+".png"
        Glide.with(this).load(url2).placeholder(R.drawable.frame).error(R.drawable.error).into(binding.wimg)
        val url3 = "https://ddragon.leagueoflegends.com/cdn/13.22.1/img/spell/"+id+"E"+".png"
        Glide.with(this).load(url3).placeholder(R.drawable.frame).error(R.drawable.error).into(binding.eimg)
        val url4 = "https://ddragon.leagueoflegends.com/cdn/13.22.1/img/spell/"+id+"R"+".png"
        Glide.with(this).load(url4).placeholder(R.drawable.frame).error(R.drawable.error).into(binding.rimg)
```

</details>

 
#스레드 이용해서 데이터 가져오기


<details>
 <summary>  스레드 코드
 
 </summary> 
 
 // 스레드로 url api 정보 받아오기
 
inner class NetworkThread(val index1 :Int): Thread(){ 
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
                    if(index1 == 0){
                        val jObject = data2.getJSONObject(index1)
                        binding.skilName.text = "Q ${jObject.getString("name")}"
                        binding.skilDetail.text = "${jObject.getString("description")}"

                    }else if(index1 == 1 ){
                        // 쪽수 별로 데이터를 읽는다.
                        val jObject = data2.getJSONObject(index1)
                        binding.skilName.text = "W ${jObject.getString("name")}"
                        binding.skilDetail.text = "${jObject.getString("description")}"

                    }else if(index1 == 2 ){
                        // 쪽수 별로 데이터를 읽는다.
                        val jObject = data2.getJSONObject(index1)
                        binding.skilName.text = "E ${jObject.getString("name")}"
                        binding.skilDetail.text = "${jObject.getString("description")}"

                    }else if(index1 == 3 ){
                        // 쪽수 별로 데이터를 읽는다.
                        val jObject = data2.getJSONObject(index1)
                        binding.skilName.text = "R ${jObject.getString("name")}"
                        binding.skilDetail.text = "${jObject.getString("description")}"

                    }


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


</details>


---




#네비게이션에 연결된 액티비티 

<img src="https://github.com/JeongYoun-24/LoL_And/assets/126854252/614f83bb-03a4-4aea-87a1-3f14174f0db7" height="350" >

<img src="https://github.com/JeongYoun-24/LoL_And/assets/126854252/3a5ba1b4-a2b0-4991-aee1-9175176b8c2d" height="350" >

<img src="https://github.com/JeongYoun-24/LoL_And/assets/126854252/28c293ee-863f-4bbe-9491-f5966724738c" height="350" >

---

#소환사 정보 

<img src="https://github.com/JeongYoun-24/LoL_And/assets/126854252/55aad62f-a97a-4f0f-9cf1-e2b6cb22ecfc" height="350" >

#WEBView를 이용해서 화면에 보여주기


<details>
 <summary> 소환사정보 액티비티 코드 
 </summary> 

    // 자바 스크립트 허용
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.settings.loadWithOverviewMode = true
        binding.webView.settings.useWideViewPort = true
        binding.webView.settings.allowUniversalAccessFromFileURLs = true
        binding.webView.settings.javaScriptCanOpenWindowsAutomatically = true
        binding.webView.settings.domStorageEnabled = true
        binding.webView.settings.saveFormData = true
        WebView.setWebContentsDebuggingEnabled(true)


        binding.webView.setWebChromeClient(object : WebChromeClient() {
            override fun onConsoleMessage(consoleMessage: ConsoleMessage): Boolean {
                Log.e(
                    "Console.log",
                    consoleMessage.message() + " from line " + consoleMessage.lineNumber()
                            + " of " + consoleMessage.sourceId() + ""
                )
                return super.onConsoleMessage(consoleMessage)
            }
        })


        /* 웹뷰에서 새 창이 뜨지 않도록 방지하는 구문 */
        binding.webView.webViewClient = WebViewClient()
        binding.webView.webChromeClient = WebChromeClient()
        /* 링크 주소를 로드 */
        binding.webView.loadUrl("file:///android_asset/index.html")


</details>

---
<details>
 <summary> 리사이클 뷰 어댑터 코드 
 </summary> 
  
class ProfileAdapter(val profileList : ArrayList<Profiles>) : RecyclerView.Adapter<ProfileAdapter.CustemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lest, parent, false)  // 연결될 액티비티

        return CustemViewHolder(view).apply {
            val intent = Intent(parent.context, LoL_DetailActivity::class.java)

            val gender = itemView.findViewById<ImageView>(R.id.iv_profile) // 성별

            // 리사이클 클릭시 이벤트
            itemView.setOnClickListener {
                val curPos : Int = adapterPosition // 현재 포지션
                val profile : Profiles = profileList.get(curPos) // 객체형태로 전달

                val bitmap = (gender.drawable as BitmapDrawable).bitmap

                intent.putExtra("gender",bitmap)
                intent.putExtra("id",profile.id)
                intent.putExtra("name",profile.name)
                intent.putExtra("lain",profile.lain)
                intent.putExtra("detail",profile.detail)

                ContextCompat.startActivity(parent.context,intent,null)
            }
        }
    }
    override fun getItemCount(): Int {
        return profileList.size
    }

    // 실제 연결해주는 메서드
    override fun onBindViewHolder(holder: CustemViewHolder, position: Int) {
        holder.gender.setImageResource(profileList.get(position).gender)
        holder.name.text = profileList.get(position).name
        holder.lain.text = profileList.get(position).lain
    }
    class CustemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gender = itemView.findViewById<ImageView>(R.id.iv_profile) // 이미지
        val name = itemView.findViewById<TextView>(R.id.tv_name)        // 이름
        val lain = itemView.findViewById<TextView>(R.id.tv_lain)        // 라인
    }

}

// 데이터
class Profiles (val gender : Int, val name : String,val id : String, val lain :String, val detail : String)


</details>

---

챔피언 정보 api URI
[<https://ddragon.leagueoflegends.com/cdn/13.22.1/data/ko_KR/champion.json>](https://ddragon.leagueoflegends.com/cdn/13.22.1/data/ko_KR/champion.json)https://ddragon.leagueoflegends.com/cdn/13.22.1/data/ko_KR/champion.json

#사용 API 사이트 
[https://developer.riotgames.com/apis](https://developer.riotgames.com/apis)https://developer.riotgames.com/apis



# 프로젝트를 통해 느낀 점과 소감

처음으로 코틀린을 이용하여 안드로이드 앱을 만들었습니다. <br>
코틀린 언어를 이용해서 만들어 새로운 경험을 했습니다.<br> 
라이엇 API를 이용하여 앱을 만들었지만 라이엇 API가 많은 정보와 잦은 업데이트로 오류가 많이 떴습니다.<br>
JSON데이터를 받아오는 과정에서 요청시간과 초당 받을수있는 데이터 횟수가 정해져 있어 스레드를 이용해서 시간을 정해 받아왔습니다.<br>
처음해본 안드로이드 코틀린 프로젝트라서 코드가 정교하지 못해 많이 아쉽습니다.    <br>
그래서 다음에 만들때는 좀더 정교하고 API데이터를 활용하여 더욱더 완성도를 높인 프로젝트를 만들수있을것같습니다.<br>




