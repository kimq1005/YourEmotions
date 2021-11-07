package com.example.YourEmotions.fragment3

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.YourEmotions.App
import com.example.YourEmotions.R
import com.example.YourEmotions.Retrofit.Retrofit_Client
import com.example.YourEmotions.Retrofit.Retrofit_InterFace
import com.example.YourEmotions.Retrofit.Retrofit_Manager
import com.example.YourEmotions.databinding.Fragment3Binding
import com.example.YourEmotions.fragment1.fragment1_Adapter
import com.example.YourEmotions.utils.utils.Companion.TAG
import kotlinx.android.synthetic.main.fragment_3.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


class Fragment3 : Fragment(R.layout.fragment_3) {
    lateinit var fragment3Adapter :Fragment3Adapter
    

    private var retrofitInterface: Retrofit_InterFace =
        Retrofit_Client.getClient("https://run.mocky.io/")
            .create(Retrofit_InterFace::class.java)


    private var binding:Fragment3Binding? =null

    companion object{
        fun newInstance() : Fragment3 {
            return Fragment3()
        }
    }

    //프래그먼트를 안고 있는 엑티비티에 붙었을때
    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?,
//    ): View? {
//
//
//        return inflater.inflate(R.layout.fragment_3, container, false)
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        

        val fragment3Binding = Fragment3Binding.bind(view)
        binding = fragment3Binding



        fragment3Adapter = Fragment3Adapter()


        fragment3RecyclerView.apply{

            adapter = fragment3Adapter
            layoutManager =LinearLayoutManager(App.instance)
        }

        childFragmentManager.beginTransaction()
            .replace(R.id.childfragment,fragment3_1())
            .commit()



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
                Log.d(TAG, "onResponse: ${response.body()}")
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