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
import com.example.lol_lain.data.ItemListData
import com.example.lol_lain.data.SpeilData

class ItemAadpter(val profileList : ArrayList<ItemListData>) : RecyclerView.Adapter<ItemAadpter.CustemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAadpter.CustemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list3, parent, false)  // 연결될 액티비티

        return ItemAadpter.CustemViewHolder(view).apply {
            val intent = Intent(parent.context, LoL_DetailActivity::class.java)
            val gender = itemView.findViewById<ImageView>(R.id.speilImg) // 성별



            // 리사이클 클릭시 이벤트
            itemView.setOnClickListener(){
                val curPos : Int = adapterPosition // 현재 포지션
                val profile : ItemListData = profileList.get(curPos) // 객체형태로 전달


            }

        }
    }
    override fun getItemCount(): Int {
        return profileList.size
    }

    // 실제 연결해주는 메서드
    override fun onBindViewHolder(holder: ItemAadpter.CustemViewHolder, position: Int) {

//        holder.speilImg.setImageResource(profileList.get(position).img)
        val url = "https://ddragon.leagueoflegends.com/cdn/13.22.1/img/item/"+"${profileList.get(position).id}"+".png"
        Glide.with(holder.speilImg).load(url).placeholder(R.drawable.frame).error(R.drawable.error).into(holder.speilImg)

        holder.name.text = profileList.get(position).name
        holder.base.text = profileList.get(position).base
        holder.description.text = profileList.get(position).description
        holder.plaintext.text = profileList.get(position).plaintext
        holder.colloq.text = profileList.get(position).colloq



    }

    class CustemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val speilImg = itemView.findViewById<ImageView>(R.id.itemImg) // 이미지
        val id = itemView.findViewById<TextView>(R.id.itemId)
        val name = itemView.findViewById<TextView>(R.id.itemName)        // 이름
        val base = itemView.findViewById<TextView>(R.id.base)        //
        val description = itemView.findViewById<TextView>(R.id.description)
        val plaintext = itemView.findViewById<TextView>(R.id.plaintext)
        val colloq = itemView.findViewById<TextView>(R.id.colloq)


    }


}