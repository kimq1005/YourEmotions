package com.example.YourEmotions.fragment3

data class VideoModel (
    val title:String,
    val sources: String,
    val subtitle: String,
    val thumb:String,
    val description:String
        )

data class VideoDto(
    val videos : List<VideoModel>
)