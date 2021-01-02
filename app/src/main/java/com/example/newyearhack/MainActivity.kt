package com.example.newyearhack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_splash.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    /*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val images = listOf(
            R.drawable.exercise,
            R.drawable.healthdiet,
            R.drawable.treeplant
        )
        val labels = listOf(
            "@string/exercise",
            "@string/healthDiet",
            "@string/treePlant"
        )

        val adapter = ViewPager(labels, images)
        viewPager.adapter = adapter
    }
    */

}