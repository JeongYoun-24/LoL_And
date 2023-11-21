package com.example.lol_lain.adpter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lol_lain.R
import org.json.JSONArray
import org.json.JSONObject

class CustomAdapter(private val datas: JSONObject) :
    RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {
    private val listStore = datas.getJSONArray("name")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_lest2, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(listStore)
    }

    override fun getItemCount(): Int {
        return listStore.length()
    }

    class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvStoreNm: TextView= view.findViewById(R.id.tv_name)
//        val tvStoreImg: ImageView = view.findViewById(R.id.c)

        fun bind(listStore: JSONArray) {
            val iObj = listStore.getJSONObject("$position".toInt())
            val name = iObj.getString("name")
            var imgUrl = iObj.getString("image")

            Log.d("챔피언 이름 ",name)

            tvStoreNm.text = name
//            Glide.with(itemView)
//                .load("http:"+ imgUrl)
//                .circleCrop()
//                .into(tvStoreImg)

        }

    }
}