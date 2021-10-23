package com.example.YourEmotions.fragment1

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.YourEmotions.R
import kotlinx.android.synthetic.main.emotionssaying_item.view.*

class fragment1_Adapter:RecyclerView.Adapter<fragment1_Adapter.fragment1_Viewholder>() {


    private var emotionsItem = ArrayList<Emotions_item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): fragment1_Viewholder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.emotionssaying_item,parent,false)

        return fragment1_Viewholder(view)
    }

    override fun onBindViewHolder(holder: fragment1_Viewholder, position: Int) {
        holder.bind(emotionsItem[position])
    }

    override fun getItemCount(): Int {
        return emotionsItem.size
    }


    class fragment1_Viewholder(itemView:View):RecyclerView.ViewHolder(itemView){

        fun bind(emotionsItem: Emotions_item){
            val youremotions = itemView.your_emotions_txt

            youremotions.text = emotionsItem.emotionsaying
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitlist(list: ArrayList<Emotions_item>){
        emotionsItem=list
        notifyDataSetChanged()
    }
}