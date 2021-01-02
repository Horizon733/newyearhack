package com.example.newyearhack.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.example.newyearhack.R
import com.example.newyearhack.databinding.FragmentDashBoardBinding


class DashBoardFragment : Fragment() {
    private lateinit var dashBoardBinding: FragmentDashBoardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dashBoardBinding = FragmentDashBoardBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dashBoardBinding.progress.setOnTouchListener { v, event ->
           true
        }
        return dashBoardBinding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DashBoardFragment().apply {

            }
    }
}