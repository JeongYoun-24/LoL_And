package com.example.lol_lain.adpter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lol_lain.LoL_DetailActivity
import com.example.lol_lain.R
import com.example.lol_lain.data.SpeilData


class ChampionAdapters(val profileList : ArrayList<SpeilData>) : RecyclerView.Adapter<ChampionAdapters.CustemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChampionAdapters.CustemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.spell_list, parent, false)  // 연결될 액티비티

        return CustemViewHolder(view).apply {
            val intent = Intent(parent.context, LoL_DetailActivity::class.java)
            val gender = itemView.findViewById<ImageView>(R.id.speilImg) // 성별



            // 리사이클 클릭시 이벤트
            itemView.setOnClickListener(){
                val curPos : Int = adapterPosition // 현재 포지션
                val profile : SpeilData = profileList.get(curPos) // 객체형태로 전달



//                Toast.makeText(parent.context,"이름 : ${profile.name} \n 역활군 : ${profile.id} \n 스토리 : ${profile.cooldown} " , Toast.LENGTH_LONG).show()
            }

        }
    }
    override fun getItemCount(): Int {
        return profileList.size
    }

    // 실제 연결해주는 메서드
    override fun onBindViewHolder(holder: ChampionAdapters.CustemViewHolder, position: Int) {

//        holder.speilImg.setImageResource(profileList.get(position).img)
//        holder.speilImg.setImageResource(profileList.get(position).img)
        holder.id.text = profileList.get(position).id
        holder.name.text = profileList.get(position).name
        holder.description.text = profileList.get(position).description
        holder.cooldown.text = profileList.get(position).cooldown

        // 소환사 주문 id값을 들고와서 url 연결후 리사이클 뷰 이미지 칸에 넣어주기
        val url = "https://ddragon.leagueoflegends.com/cdn/13.22.1/img/spell/"+"${profileList.get(position).id}"+".png"
        Glide.with(holder.speilImg).load(url).placeholder(R.drawable.frame).error(R.drawable.error).into(holder.speilImg)

    }

    class CustemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val speilImg = itemView.findViewById<ImageView>(R.id.speilImg) // 이미지
        val id = itemView.findViewById<TextView>(R.id.speilId)
        val name = itemView.findViewById<TextView>(R.id.speilName)        // 이름
        val lain = itemView.findViewById<TextView>(R.id.tv_lain)        //
        val description = itemView.findViewById<TextView>(R.id.description)
        val cooldown = itemView.findViewById<TextView>(R.id.cooldown)


    }


}
