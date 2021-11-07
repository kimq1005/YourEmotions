package com.example.YourEmotions.fragment3

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.YourEmotions.App
import com.example.YourEmotions.R
import com.example.YourEmotions.Retrofit.Retrofit_Client
import com.example.YourEmotions.Retrofit.Retrofit_InterFace
import com.example.YourEmotions.databinding.Fragment31Binding
import com.example.YourEmotions.utils.utils
import kotlinx.android.synthetic.main.fragment_3_1.*
import retrofit2.Call
import retrofit2.Response

class fragment3_1: Fragment(R.layout.fragment_3_1) {

    lateinit var fragment3Adapter: Fragment3Adapter
    private var binding : Fragment31Binding?=null

    private var retrofitInterface: Retrofit_InterFace=
        Retrofit_Client.getClient("https://run.mocky.io/")
            .create(Retrofit_InterFace::class.java)

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragment31Binding = Fragment31Binding.bind(view)
        binding = fragment31Binding

        fragment3Adapter = Fragment3Adapter()
        fragment3_1_RecyclerView.apply{
            adapter = fragment3Adapter
            layoutManager = LinearLayoutManager(App.instance)

        }
        GETLIST()
    }


    private fun GETLIST(){

        val call = retrofitInterface.getvideo()

//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://run.mocky.io/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//
//        retrofit.create(Retrofit_InterFace::class.java).also{
//            it.getvideo()
//                .enqueue(object: Callback<VideoDto> {
//                    override fun onResponse(call: Call<VideoDto>, response: Response<VideoDto>) {
//
//                        response.body().let{videoDto->
////                            Log.d(TAG, "onResponse:${videoDto.toString()}")
//                            fragment3Adapter.submitList(videoDto?.videos)
//                        }
//
//
//                    }
//                    override fun onFailure(call: Call<VideoDto>, t: Throwable) {
//                        Log.d(TAG, "onFailure:$t")
//                    }
//                })
//        }

        call.enqueue(object:retrofit2.Callback<VideoDto>{
            override fun onResponse(call: Call<VideoDto>, response: Response<VideoDto>) {
                Log.d(utils.TAG, "onResponse: ${response.body()}")
                response.body().let{videoDto ->
                    fragment3Adapter.submitList(videoDto?.videos)
                }

            }

            override fun onFailure(call: Call<VideoDto>, t: Throwable) {
                Log.d(utils.TAG, "onFailure: $t")
            }

        })
    }
}