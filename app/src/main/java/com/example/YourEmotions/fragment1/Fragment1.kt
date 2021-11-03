package com.example.YourEmotions.fragment1

import android.annotation.SuppressLint
import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.YourEmotions.EmotionsDB.EmotionsDataBase
import com.example.YourEmotions.EmotionsDB.EmotionsEntity
import com.example.YourEmotions.R
import com.example.YourEmotions.SecondAactivity
import com.example.YourEmotions.utils.App
import com.example.YourEmotions.utils.utils.Companion.TAG
import kotlinx.android.synthetic.main.fragment_1.*

class Fragment1 : Fragment() {


    lateinit var emotionsList: List<EmotionsEntity>

    lateinit var emotiondb :EmotionsDataBase



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





        emotiondb= EmotionsDataBase.getinstance(App.instance)!!

        Log.d(TAG, "onViewCreated: ${arrayListOf<Emotions_item>()} ")
        emotionsGetAll()
//        emotionsaying_RecyclerView.apply {
//
//            fragment1Adapter = fragment1_Adapter()
//            adapter = fragment1_Adapter()
//            layoutManager = GridLayoutManager(App.instance ,2,GridLayoutManager.VERTICAL,false)
//
//
//
//        }
    }
    @SuppressLint("StaticFieldLeak")
    private fun emotionsGetAll() {
        val emotionsgetTask= (object :AsyncTask<Unit,Unit,Unit>() {
            override fun doInBackground(vararg p0: Unit?) {
                emotionsList = emotiondb.EmotionsDAO().emotionsgetAll()
            }

            override fun onPostExecute(result: Unit?) {
                super.onPostExecute(result)

                emtionsRecyclerView()
            }

        }).execute()
    }

    private fun emtionsRecyclerView() {
        val fragment1Adapter = fragment1_Adapter()
        fragment1Adapter.submitlist(emotionsList)

        emotionsaying_RecyclerView.apply {
            layoutManager = GridLayoutManager(App.instance,2,GridLayoutManager.VERTICAL,false)
            adapter = fragment1Adapter
        }
    }


}