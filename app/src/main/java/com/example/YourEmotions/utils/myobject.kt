package com.example.YourEmotions.utils

import androidx.appcompat.app.AppCompatActivity
import com.example.YourEmotions.fragment1.Fragment1
import com.example.YourEmotions.Fragment2
import com.example.YourEmotions.Fragment3
import com.example.YourEmotions.R
import com.google.android.material.bottomnavigation.BottomNavigationView

object myobject:AppCompatActivity() {

    private lateinit var fragment1: Fragment1
    private lateinit var fragment2: Fragment2
    private lateinit var fragment3: Fragment3


    val onBottomNavItemSeletedListener = BottomNavigationView.OnNavigationItemSelectedListener{
        when (it.itemId) {
            R.id.today_emotion -> {
                fragment1 = Fragment1.newInstance()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.bottomnaviagtionview,fragment1)
                    .commit()
            }

            R.id.today_emotionsaying -> {
                fragment2 = Fragment2.newInstance()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.bottomnaviagtionview,fragment2)
                    .commit()
            }

            R.id.today_wisesaying -> {
                fragment3 = Fragment3.newInstance()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.bottomnaviagtionview,fragment3)
                    .commit()
            }
        }
        true
    }

}