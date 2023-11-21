package com.example.lol_lain.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lol_lain.R
import com.example.lol_lain.data.SpeilData

class SpeilAdapter
  /*  (var items : ArrayList<SpeilData>) : RecyclerView.Adapter<SpeilAdapter.ViewHolder> () {
    //  movie_item.xml과 연결한 뷰 홀더 반환
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpeilAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.spell_list, parent, false)
        return ViewHolder(itemView)
    }

    // position번째 데이터와 xml 연결
    override fun onBindViewHolder(holder: SpeilAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.setItem(item)
    }

    // 아이템 갯수 반환
    override fun getItemCount() = items.count()

    // 데이터와 xml 연결
    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun setItem(item : SpeilData) {

            // 이미지 url 읽어서 넣기
            Glide.with(itemView).load(item.poster).into(itemView.poster)
        }
    }
}*/