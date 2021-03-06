package com.example.YourEmotions.fragment3

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.YourEmotions.R
import com.example.YourEmotions.utils.utils.Companion.diffUtil
import kotlinx.android.synthetic.main.item_video.view.*

class Fragment3Adapter():ListAdapter<VideoModel,Fragment3Adapter.ViewHolder>(diffUtil) {


    private var videoModel= ArrayList<VideoModel>()





    inner class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {

        val thumnail = itemView.thumbnailImageView

        fun bind(videoModel: VideoModel){
            itemView.titleTextView.text =videoModel.title
            itemView.subtitleTextrView.text = videoModel.subtitle
            Glide.with(thumnail).load(videoModel.thumb).into(thumnail)



        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_video,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(currentList[position])

    }


}