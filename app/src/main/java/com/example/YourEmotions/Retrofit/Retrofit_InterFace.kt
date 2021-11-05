package com.example.YourEmotions.Retrofit

import com.example.YourEmotions.fragment3.VideoDto
import retrofit2.Call
import retrofit2.http.GET

interface Retrofit_InterFace {

    @GET("v3/a8ad5783-8d50-4904-8fa0-a15ea7a4813b")
    fun getvideo() : Call<VideoDto>

}