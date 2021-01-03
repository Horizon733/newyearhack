package com.example.newyearhack

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_splash.viewPager
import me.relex.circleindicator.CircleIndicator3

class Splash : Fragment(){

    companion object{
        fun newInstance(): Splash{
            return Splash()
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
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
        val color = listOf(
            R.color.firstSplash,
            R.color.secondSplash,
            R.color.thirdSplash
        )
        val view = inflater.inflate(R.layout.activity_splash, container, false)

        val adapter = ViewPager(labels, images)
        val viewPager: ViewPager2 = view.findViewById(R.id.viewPager)
        viewPager.adapter = adapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                view.setBackgroundResource(color[position])
            }
        })

        val indicator: CircleIndicator3 = view.findViewById(R.id.circleIndicator)
        indicator.setViewPager(viewPager)

        return view
    }

}