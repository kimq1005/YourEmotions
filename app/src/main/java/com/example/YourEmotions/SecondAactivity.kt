package com.example.YourEmotions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.YourEmotions.utils.myobject
import com.example.YourEmotions.utils.myobject.onBottomNavItemSeletedListener
import com.example.YourEmotions.utils.utils
import com.google.android.material.bottomnavigation.BottomNavigationView

import kotlinx.android.synthetic.main.activity_second_aactivity.*

class SecondAactivity : AppCompatActivity(){

    private lateinit var fragment1: Fragment1
    private lateinit var fragment2: Fragment2
    private lateinit var fragment3: Fragment3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_aactivity)


        bottomnaviselect()




    }

    fun bottomnaviselect(){

       val mainonBottomNavItemSeletedListener = BottomNavigationView.OnNavigationItemSelectedListener{
            when (it.itemId) {
                R.id.today_emotion -> {
                    fragment1 = Fragment1.newInstance()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.myframelayout, fragment1)
                        .commit()
                    Log.d(utils.TAG, "onNavigationItemSelected: 첫번째")
                }

                R.id.today_emotionsaying -> {
                    fragment2 = Fragment2.newInstance()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.myframelayout, fragment2)
                        .commit()
                    Log.d(utils.TAG, "onNavigationItemSelected: 두번째")
                }

                R.id.today_wisesaying -> {
                    fragment3 = Fragment3.newInstance()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.myframelayout, fragment3)
                        .commit()
                    Log.d(utils.TAG, "onNavigationItemSelected: 세번째")
                }
            }
            true
        }

        bottomnaviagtionview.setOnNavigationItemSelectedListener(mainonBottomNavItemSeletedListener)

        fragment1 = Fragment1.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.myframelayout,fragment1).commit()
    }







//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//
//        when (item.itemId) {
//            R.id.today_emotion -> {
//                Log.d(TAG, "onNavigationItemSelected: 첫번째")
//            }
//
//            R.id.today_emotionsaying -> {
//                Log.d(TAG, "onNavigationItemSelected: 두번째")
//            }
//
//            R.id.today_wisesaying -> {
//                Log.d(TAG, "onNavigationItemSelected: 세번째")
//            }
//        }
//        return true
//    }



}