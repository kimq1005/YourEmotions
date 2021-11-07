package com.example.YourEmotions.fragment2

import android.annotation.SuppressLint
import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.YourEmotions.App
import com.example.YourEmotions.EmotionsDB.EmotionsDataBase
import com.example.YourEmotions.EmotionsDB.EmotionsEntity
import com.example.YourEmotions.R
import kotlinx.android.synthetic.main.emotionssaying_item.*
import kotlinx.android.synthetic.main.fragment_2.*

@SuppressLint("StaticFieldLeak")
class Fragment2 : Fragment() {

    lateinit var emotionsdb:EmotionsDataBase

    lateinit var emotionslist : List<EmotionsEntity>

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

        emotionsdb = EmotionsDataBase.getinstance(App.instance)!!



//        daotest_txt.setOnClickListener {
//            emotionsdb.EmotionsDAO().emotionsgetAll().observe(viewLifecycleOwner, Observer { it->
//                daotest_txt.text = it.toString()
//                Toast.makeText(App.instance,"dmdfszf",Toast.LENGTH_SHORT).show()
//            })
//        }


        save_Your_EmotionsBtn.setOnClickListener{
            val yoursaying = EmotionsEntity(0,YourSaying.text.toString())
            emotionsinsert(yoursaying)
            Toast.makeText(App.instance,"입력 완료",Toast.LENGTH_SHORT).show()

        }




    }

    private fun emotionsinsert(emotionsEntity: EmotionsEntity) {
        var emotionsinsert= (object :AsyncTask<Unit,Unit,Unit>(){
            override fun doInBackground(vararg p0: Unit?) {
                emotionsdb.EmotionsDAO().emotionsinsert(emotionsEntity)
            }

            override fun onPostExecute(result: Unit?) {
                super.onPostExecute(result)
                emotionsgetall()

            }


        }).execute()


    }

    private fun emotionsgetall() {
        var getalltask= (object:AsyncTask<Unit,Unit,Unit>(){
            override fun doInBackground(vararg p0: Unit?) {
                emotionslist = emotionsdb.EmotionsDAO().emotionsgetAll()
            }
        }).execute()
    }


}