package com.example.YourEmotions.fragment2

import android.annotation.SuppressLint
import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.YourEmotions.EmotionsDB.EmotionsDataBase
import com.example.YourEmotions.EmotionsDB.EmotionsEntity
import com.example.YourEmotions.R
import com.example.YourEmotions.utils.App
import com.example.YourEmotions.utils.utils.Companion.TAG
import kotlinx.android.synthetic.main.fragment_2.*

(@SuppressLint("StaticFieldLeak")
class Fragment2 : Fragment() {

    lateinit var emotionsdb:EmotionsDataBase

    companion object{
        fun newInstance() : Fragment2 {
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

        return inflater.inflate(R.layout.fragment_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        save_Your_EmotionsBtn.setOnClickListener{


            val myemtions = EmotionsEntity(
                null,YourSaying.text.toString(),"김승현"
            )

            val emotionslist = EmotionsEntity.indices


            emotionsinsert(myemtions)
            Log.d(TAG, "흠한번 볼까용?: ")
        }


    }

    private fun emotionsinsert(emotionsEntity: EmotionsEntity) {
        var emotionsinsert= (object :AsyncTask<Unit,Unit,Unit>(){
            override fun doInBackground(vararg p0: Unit?) {
                emotionsdb.EmotionsDAO().emotionsinsert(emotionsEntity)
            }

            override fun onPostExecute(result: Unit?) {
                super.onPostExecute(result)
                emotionsdb.EmotionsDAO().emotionsgetAll()
            }


        })


    }


}