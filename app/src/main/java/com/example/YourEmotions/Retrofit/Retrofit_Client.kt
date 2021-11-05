package com.example.YourEmotions.Retrofit


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit_Client {

    private var retrofitClient:Retrofit? =null

    fun getClient(baseUrl: String):Retrofit{

       val RetrofitClient = Retrofit.Builder()
           .addConverterFactory(GsonConverterFactory.create())
           .baseUrl(baseUrl)
           .build()

        return RetrofitClient

    }

}