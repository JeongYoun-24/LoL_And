package com.example.lol_lain.adpter



import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.lol_lain.LoL_DetailActivity
import com.example.lol_lain.R
import com.example.lol_lain.data.Profiles


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

//                Toast.makeText(parent.context,"이름 : ${profile.name} \n 역활군 : ${profile.lain} \n 스토리 : ${profile.job} " , Toast.LENGTH_LONG).show()
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
//        holder.detail.text = profileList.get(position).detail


//       holder.gender.setOnClickListener{
//            val intent = Intent(holder.gender?.context, LoL_DetailActivity::class.java)
//            intent.putExtra("gender","이미지")
//            intent.putExtra("name",profileList.get(position).name)
//            intent.putExtra("lain",profileList.get(position).lain)
//            intent.putExtra("detail",profileList.get(position).detail)
//
//            ContextCompat.startActivity(holder.gender.context,intent,null)
//        }

    }


    class CustemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gender = itemView.findViewById<ImageView>(R.id.iv_profile) // 성별
        val name = itemView.findViewById<TextView>(R.id.tv_name)        // 이름
        val lain = itemView.findViewById<TextView>(R.id.tv_lain)        // 나이
//        val detail = itemView.findViewById<TextView>(R.id.detail)        // 직업


    }

}