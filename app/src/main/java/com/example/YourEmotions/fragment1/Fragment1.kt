package com.example.YourEmotions.fragment1

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.YourEmotions.R
import com.example.YourEmotions.SecondAactivity
import com.example.YourEmotions.utils.App
import kotlinx.android.synthetic.main.fragment_1.*

class Fragment1 : Fragment() {

    private var fragment1Adapter = fragment1_Adapter()


    companion object{
        fun newInstance() : Fragment1 {
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val hihi = arrayListOf(
            Emotions_item("안녕 클레오파트라"),
            Emotions_item("안녕 클레오파트라"),
            Emotions_item("안녕 클레오파트라"),
            Emotions_item("안녕 클레오파트라"),
            Emotions_item("안녕 클레오파트라")
            )

        emotionsaying_RecyclerView.apply {
            fragment1Adapter = fragment1_Adapter()
            adapter = fragment1Adapter
            layoutManager = GridLayoutManager(App.instance ,2,GridLayoutManager.VERTICAL,false)
            fragment1Adapter.submitlist(hihi)

        }
    }



}