package com.example.YourEmotions.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.YourEmotions.fragment1.Fragment1
import com.example.YourEmotions.fragment2.Fragment2
import com.example.YourEmotions.fragment3.Fragment3
import com.example.YourEmotions.fragment3.VideoModel

class utils {
    companion object{
        const val TAG:String ="로그"

        val diffUtil= object :DiffUtil.ItemCallback<VideoModel>(){
            override fun areItemsTheSame(oldItem: VideoModel, newItem: VideoModel): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: VideoModel, newItem: VideoModel): Boolean {
                return oldItem==newItem

            }

        }




    }
}


