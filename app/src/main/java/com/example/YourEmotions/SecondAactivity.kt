package com.example.YourEmotions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.example.YourEmotions.fragment1.Fragment1
import com.example.YourEmotions.fragment2.Fragment2
import com.example.YourEmotions.fragment3.Fragment3
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

import kotlinx.android.synthetic.main.activity_second_aactivity.*
import kotlinx.android.synthetic.main.main_toolbar.*

class SecondAactivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    private lateinit var fragment1: Fragment1
    private lateinit var fragment2: Fragment2
    private lateinit var fragment3: Fragment3


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_aactivity)


        menumenu.setOnClickListener {
            second_layoutdrawer.openDrawer(GravityCompat.START)
        }

        navi_view.setNavigationItemSelectedListener(this)

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

                }

                R.id.today_emotionsaying -> {
                    fragment2 = Fragment2.newInstance()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.myframelayout, fragment2)
                        .commit()

                }

                R.id.today_wisesaying -> {
                    fragment3 = Fragment3.newInstance()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.myframelayout, fragment3)
                        .commit()

                }
            }
            true
        }

        bottomnaviagtionview.setOnNavigationItemSelectedListener(mainonBottomNavItemSeletedListener)

        fragment1 = Fragment1.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.myframelayout,fragment1).commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {    //네비게이션 메뉴 아니템 클릭 시 수행
        when (item.itemId)
        {
            R.id.today_emotion-> Toast.makeText(this,"하이요",Toast.LENGTH_SHORT).show()

            R.id.today_emotionsaying-> Toast.makeText(this,"하이요",Toast.LENGTH_SHORT).show()

            R.id.today_wisesaying-> Toast.makeText(this,"하이요",Toast.LENGTH_SHORT).show()

        }
        second_layoutdrawer.closeDrawers()  //클릭했을시에 메뉴를 닫아줘

        return false
    }

    override fun onBackPressed() {

        if(second_layoutdrawer.isDrawerOpen(GravityCompat.START))
        {
            second_layoutdrawer.closeDrawers()
        }

        else{
            super.onBackPressed()
        }



    }

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



