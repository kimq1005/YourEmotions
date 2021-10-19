package com.example.YourEmotions

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mBackWait:Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        main_logo.setOnClickListener {
//            Handler().postDelayed({
//                nextfadePageGO(this)
////            },1000)
            nextfadePageGO(this)

        }

    }

    private fun nextfadePageGO(activity:Activity) {

        val intent = Intent(this,SecondAactivity::class.java)
        startActivity(intent)
        activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)

    }

    override fun onBackPressed() {
        if(System.currentTimeMillis()- mBackWait>=2000){
            mBackWait = System.currentTimeMillis()
            Snackbar.make(mainlayout,"오늘 너의 감성은 어땠니....",Snackbar.LENGTH_SHORT).show()
        }else{
            finish()
        }
    }
}