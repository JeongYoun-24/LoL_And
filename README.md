# LoL_And
안드로이드 프로젝트 

# 소개
라이엇 API 를 이용한 안드로이드 프로젝트 입니다.


# 제작기간 & 참여 인원
<UL>
  <LI>11/11~ </LI>
  <LI>개인 프로젝트</LI>
</UL>




# 사용기술
![js](https://img.shields.io/badge/kotlin-7F52FF?style=for-the-badge&logo=JavaScript&logoColor=white)
![js](https://img.shields.io/badge/androidstudio-3DDC84?style=for-the-badge&logo=JavaScript&logoColor=white)

# 핵심 기능 및 페이지 소개

<H3>메인 페이지</H3>
<BR>
<img src="https://github.com/JeongYoun-24/LoL_And/assets/126854252/2e6f64b1-ff1b-4e05-8d6c-328ae4422ed4" height="350">
<img src="https://github.com/JeongYoun-24/LoL_And/assets/126854252/2e6ffc15-27cc-4616-b19e-aaeab5f210be" height="350">
<BR>

<BR>
<img src="https://github.com/JeongYoun-24/LoL_And/assets/126854252/6fe145f1-b069-4f1d-903f-0d8b0d079a31" height="350">
<BR>
<UL>
 <LI>기본 디폴트로 잡혀 있는 메인 페이지입니다. 
     메인 페이지는 챔피언 리스트를 리사이클뷰 어댑터를 통해 값을 전달하여 뿌려주고있습니다. 
     메인메이지 네비게이션 바를 만들어서 여러 액티비티 연결을 할수있도록 하였습니다.
 </LI>
</UL>
<BR>

<BR>
<androidx.drawerlayout.widget.DrawerLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/layout_drawer"
    android:background="@color/blu"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    android:paddingHorizontal="15dp"
    android:paddingVertical="20dp">
    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <ImageView
            android:id="@+id/btn_navi"
            android:layout_width="64dp"
            android:layout_height="61dp"
            android:layout_marginStart="16dp"
            android:layout_marginTop="16dp"
            android:src="@drawable/menu1"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

        <TextView
            android:id="@+id/textView"
            android:layout_width="111dp"
            android:layout_height="38dp"
            android:layout_marginStart="150dp"
            android:layout_marginTop="64dp"
            android:layout_marginEnd="150dp"
            android:text="챔피언 정보"
            android:textColor="#D5C649"
            android:textSize="20sp"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.0"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

        <EditText
            android:id="@+id/seletText"
            android:layout_width="174dp"
            android:layout_height="45dp"
            android:layout_marginBottom="8dp"
            android:ems="10"
            android:hint="챔피언 이름 입력"
            android:inputType="text"
            android:text=""
            app:layout_constraintBottom_toTopOf="@+id/scrollView2"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.502"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/textView"
            app:layout_constraintVertical_bias="0.041" />

        <ImageView
            android:id="@+id/seletImg"
            android:layout_width="61dp"
            android:layout_height="46dp"
            app:layout_constraintBottom_toBottomOf="@+id/seletText"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toEndOf="@+id/seletText"
            app:layout_constraintTop_toBottomOf="@+id/textView"
            app:srcCompat="@drawable/baseline_search_24" />

        <ImageView
            android:id="@+id/SumBtn"
            android:layout_width="70dp"
            android:layout_height="40dp"
            android:layout_marginTop="16dp"
            android:layout_marginEnd="40dp"
            android:text="소환사 정보"
            app:layout_constraintBottom_toBottomOf="@+id/btn_navi"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintVertical_bias="0.222"
            app:srcCompat="@drawable/img_5" />

        <!--<TextView
            android:id="@+id/textView3"
            android:layout_width="72dp"
            android:layout_height="19dp"
            android:layout_marginTop="44dp"
            android:text="소환사정보"
            android:textColor="#D5C649"
            app:layout_constraintEnd_toEndOf="@+id/SumBtn"
            app:layout_constraintTop_toTopOf="@+id/SumBtn" />-->

        <ScrollView
            android:id="@+id/scrollView2"
            android:layout_width="369dp"
            android:layout_height="480dp"
            android:layout_marginStart="1dp"
            android:layout_marginEnd="1dp"
            android:layout_marginBottom="48dp"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent">

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="vertical">

                <androidx.recyclerview.widget.RecyclerView
                    android:id="@+id/rv_profile"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_marginTop="8dp"
                    android:layout_marginBottom="8dp" />

                <androidx.recyclerview.widget.RecyclerView
                    android:id="@+id/rv_profile2"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:layout_marginTop="-8dp"
                    android:layout_marginBottom="8dp" />

                <androidx.recyclerview.widget.RecyclerView
                    android:id="@+id/rv_profile3"
                    android:layout_width="match_parent"
                    android:layout_height="215dp"
                    android:layout_marginTop="8dp"
                    android:layout_marginBottom="8dp" />

                <androidx.recyclerview.widget.RecyclerView
                    android:id="@+id/rv_profile4"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:layout_marginTop="8dp"
                    android:layout_marginBottom="8dp" />

                <androidx.recyclerview.widget.RecyclerView
                    android:id="@+id/rv_profile5"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:layout_marginTop="8dp"
                    android:layout_marginBottom="8dp" />

                <androidx.recyclerview.widget.RecyclerView
                    android:id="@+id/rv_profile6"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:layout_marginTop="8dp"
                    android:layout_marginBottom="8dp" />

                <androidx.recyclerview.widget.RecyclerView
                    android:id="@+id/rv_profile7"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:layout_marginTop="8dp"
                    android:layout_marginBottom="8dp" />

                <androidx.recyclerview.widget.RecyclerView
                    android:id="@+id/rv_profile8"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:layout_marginTop="8dp"
                    android:layout_marginBottom="8dp" />

                <androidx.recyclerview.widget.RecyclerView
                    android:id="@+id/rv_profile9"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:layout_marginTop="8dp"
                    android:layout_marginBottom="8dp" />

            </LinearLayout>
        </ScrollView>


    </androidx.constraintlayout.widget.ConstraintLayout>

    <com.google.android.material.navigation.NavigationView
        android:id="@+id/navieView"
        android:textColor="#D5C649"
        android:background="@color/blu"
        android:layout_width="wrap_content"
        android:layout_height="match_parent"
        android:layout_gravity="start"
        app:itemTextColor="@color/yeil"
        app:menu="@menu/nav_menu" />
</androidx.drawerlayout.widget.DrawerLayout>
<BR>


#메인액티비티 코드 
<코드가 길어 짧게 요약 >
<BR>
  // 라이엇 url api 에서 이미지 받아오기
 val Imgurl = "https://raw.communitydragon.org/latest/plugins/rcp-fe-lol-parties/global/default/button-search-hover.png"
 Glide.with(this).load(Imgurl).placeholder(R.drawable.frame).error(R.drawable.error).into(binding.seletImg)

//VERTICAL 세로 방향  HORIZONTAL 가로방향
        binding.rvProfile.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.rvProfile.setHasFixedSize(true)
        binding.rvProfile.adapter = ProfileAdapter(profileList)
        
       // 네이게이션 이벤트
        binding.btnNavi.setOnClickListener(){
            binding.layoutDrawer.openDrawer(GravityCompat.START) // START : left  END : right
        }
        binding.navieView.setNavigationItemSelectedListener(this)  
        
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
  <BR> 
  
#어댑터 코드 
<BR>
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
<BR>
