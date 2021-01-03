package com.example.newyearhack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.view.Window
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.newyearhack.databinding.ActivitySplashBinding
import me.relex.circleindicator.CircleIndicator3

class Splash : Fragment(){
    private val actionbar = activity?.actionBar
    private lateinit var window:Window
    private lateinit var splashBinding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window = activity?.window!!
        splashBinding = ActivitySplashBinding.inflate(layoutInflater)
    }
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

        val adapter = ViewPager(activity as MainActivity,labels, images,window,color)
        val viewPager: ViewPager2 = view.findViewById(R.id.viewPager)
        viewPager.adapter = adapter


        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                view.setBackgroundResource(color[position])
                window.statusBarColor = ContextCompat.getColor(activity as MainActivity,color[position])
                if(position.equals(2)){
                    splashBinding.imNew.visibility = View.GONE
                    splashBinding.login.setText("Get Started")
                }else{
                    splashBinding.login.setOnClickListener {

                    }
                }
            }
        })

        val indicator: CircleIndicator3 = view.findViewById(R.id.circleIndicator)
        indicator.setViewPager(viewPager)

        return view
    }

}