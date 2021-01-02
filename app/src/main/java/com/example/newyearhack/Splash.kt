package com.example.newyearhack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import kotlinx.android.synthetic.main.activity_splash.viewPager

class Splash : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
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
        val view = inflater.inflate(R.layout.activity_splash, container, false)
        val adapter = ViewPager(labels, images)
        viewPager.adapter = adapter

        return view
    }
}