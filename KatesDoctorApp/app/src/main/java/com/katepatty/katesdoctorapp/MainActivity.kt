package com.katepatty.katesdoctorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.katepatty.katesdoctorapp.fragment.AttentionFragment
import com.katepatty.katesdoctorapp.fragment.ContactFragment
import com.katepatty.katesdoctorapp.fragment.HomeFragment
import com.katepatty.katesdoctorapp.fragment.InfoFragment

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // can be done by lazy init
    val h = HomeFragment()
    val c = ContactFragment()
    val i = InfoFragment()
    val a = AttentionFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFragment(h)

        bottomNav.setOnNavigationItemReselectedListener {

            when(it.itemId){

                // see item id in menu
                // not drawable id
                R.id.home -> initFragment(h)
                R.id.clean -> initFragment(a)
                R.id.chat -> initFragment(i)
                R.id.contact -> initFragment(c)

            }

        }

    }

    // 初始的碎片畫面
    private fun initFragment(fragment: Fragment){
        // to pass k/v pairs
        //supportFragmentManager.getFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_wrapper, fragment)
            commit()
        }

    }


}