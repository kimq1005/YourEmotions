package com.example.YourEmotions

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Fragment1 : Fragment() {

    companion object{
        fun newInstance() : Fragment1{
            return Fragment1()
        }
    }

    //프래그먼트를 안고 있는 엑티비티에 붙었을때
    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    //프레그먼트와 레이아웃을 연결시켜주는 곳!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?, ): View?
    {

        return inflater.inflate(R.layout.fragment_1, container, false)
    }

}