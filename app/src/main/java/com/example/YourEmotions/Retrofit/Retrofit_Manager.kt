package com.example.YourEmotions.Retrofit

import android.util.Log
import com.example.YourEmotions.fragment3.Fragment3Adapter
import com.example.YourEmotions.fragment3.VideoDto
import com.example.YourEmotions.fragment3.VideoModel
import com.example.YourEmotions.utils.utils.Companion.TAG
import com.google.gson.JsonArray
import retrofit2.Call
import retrofit2.Response

class Retrofit_Manager {


    lateinit var fragment3Adapter : Fragment3Adapter

    companion object{
        val retrofitManager= Retrofit_Manager()
    }




    private var retrofitInterface: Retrofit_InterFace=
        Retrofit_Client.getClient("https://run.mocky.io/")
            .create(Retrofit_InterFace::class.java)


    fun GEsTLIST(videoDto: ArrayList<VideoDto>){
        val call = retrofitInterface.getvideo()

        call.enqueue(object:retrofit2.Callback<VideoDto>{
            override fun onResponse(call: Call<VideoDto>, response: Response<VideoDto>) {
                response.body().let{videoD1to ->
                    fragment3Adapter.submitList(videoD1to?.videos)
                }

            }

            override fun onFailure(call: Call<VideoDto>, t: Throwable) {
                Log.d(TAG, "onFailure: $t")
            }

        })
    }




}