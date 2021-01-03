package com.example.newyearhack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_splash.*
import me.relex.circleindicator.CircleIndicator3

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment : Fragment = Splash()
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


    /*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val images = listOf(
            R.drawable.exercise,
            R.drawable.healthdiet,
            R.drawable.treeplant
        )
        val labels = listOf(
            getString(R.string.exercise),
            getString(R.string.healthDiet),
            getString(R.string.treePlant)
        )

        val adapter = ViewPager(labels, images)
        viewPager.adapter = adapter

        val indicator: CircleIndicator3 = findViewById(R.id.circleIndicator)
        indicator.setViewPager(viewPager)
    }

    */

}