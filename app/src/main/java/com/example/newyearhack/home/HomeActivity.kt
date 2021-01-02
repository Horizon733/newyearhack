package com.example.newyearhack.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.newyearhack.R
import com.example.newyearhack.databinding.ActivityHomeBinding
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    private lateinit var homeBinding: ActivityHomeBinding
    val fragment2: Fragment = MedalsFragment()
    val fragment1: Fragment = DashBoardFragment()
    val fragment3: Fragment = MapsFragment()
    val fragment4: Fragment = SettingsFragment()
    var active: Fragment = fragment1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)
        supportFragmentManager.beginTransaction().add(R.id.views,fragment1,"dashboard").commit()
        supportFragmentManager.beginTransaction().add(R.id.views,fragment2,"medals").hide(fragment2).commit()
        supportFragmentManager.beginTransaction().add(R.id.views,fragment3,"sprint").hide(fragment3).commit()
        supportFragmentManager.beginTransaction().add(R.id.views,fragment4,"settings").hide(fragment4).commit()
        bottomNavigationView.background = null
        bottomNavigationView.menu.getItem(2).isEnabled = false
        homeBinding.bottomNavigationView.setOnNavigationItemSelectedListener {item->

            when(item.itemId){
                R.id.dashboard -> {
                    supportFragmentManager.beginTransaction().hide(active).show(fragment1).commit();
                    active = fragment1
                    true
                }

                R.id.medals -> {
                    supportFragmentManager.beginTransaction().hide(active).show(fragment2).commit();
                    active = fragment2
                    true
                }
                R.id.miSprint -> {
                    supportFragmentManager.beginTransaction().hide(active).show(fragment3).commit();
                    active = fragment3
                    true
                }
                R.id.miSettings -> {
                    supportFragmentManager.beginTransaction().hide(active).show(fragment4).commit();
                    active = fragment4
                    true
                }
                else -> {
                    supportFragmentManager.beginTransaction().hide(active).show(fragment1).commit();
                    active = fragment1
                    true
                }

            }
        }
    }


}