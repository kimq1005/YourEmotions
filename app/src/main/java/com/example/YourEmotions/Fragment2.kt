package com.example.YourEmotions

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup




class Fragment2 : Fragment() {

    companion object{
        fun newInstance() : Fragment2{
            return Fragment2()
        }
    }

    //프래그먼트를 안고 있는 엑티비티에 붙었을때
    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false)
    }

}