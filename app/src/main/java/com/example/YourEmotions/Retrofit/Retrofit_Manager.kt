package com.example.YourEmotions.Retrofit

import android.util.Log
import com.example.YourEmotions.fragment3.Fragment3Adapter
import com.example.YourEmotions.fragment3.VideoDto
import com.example.YourEmotions.utils.utils.Companion.TAG
import retrofit2.Call
import retrofit2.Response

class Retrofit_Manager {


    private lateinit var fragment3Adapter : Fragment3Adapter

    companion object{
        val retrofitManager= Retrofit_Manager()
    }




    private var retrofitInterface: Retrofit_InterFace=
        Retrofit_Client.getClient("https://run.mocky.io/")
            .create(Retrofit_InterFace::class.java)


    fun GETLIST(){
        val call = retrofitInterface.getvideo()

        call.enqueue(object:retrofit2.Callback<VideoDto>{
            override fun onResponse(call: Call<VideoDto>, response: Response<VideoDto>) {
                response.body().let{videoDto ->
                fragment3Adapter.submitList(videoDto?.videos)

                }
            }

            override fun onFailure(call: Call<VideoDto>, t: Throwable) {
                Log.d(TAG, "onFailure: $t")
            }

        })
    }


}