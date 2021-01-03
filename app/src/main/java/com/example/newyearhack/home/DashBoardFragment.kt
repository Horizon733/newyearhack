package com.example.newyearhack.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newyearhack.R
import com.example.newyearhack.adapters.ActivitiesAdapter
import com.example.newyearhack.adapters.TaskAdapter
import com.example.newyearhack.databinding.FragmentDashBoardBinding
import io.radar.sdk.Radar


class DashBoardFragment : Fragment() {
    private lateinit var task:ArrayList<Tasks>
    private lateinit var activities:ArrayList<Activities>
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

        task = ArrayList<Tasks>()
        task.add(Tasks("Daily Sprint",87600,25,"month"))
        task.add(Tasks("Language Learning",87600,55,"month"))
        task.add(Tasks("Plant a Tree",87600,10,"month"))
        task.add(Tasks("Family Time",87600,5,"month"))
        val adapter = TaskAdapter(requireActivity(),task)
        val linearLayoutManager = LinearLayoutManager(activity)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        dashBoardBinding.resolutionList.adapter = adapter
        dashBoardBinding.resolutionList.layoutManager = linearLayoutManager


        activities = ArrayList<Activities>()
        activities.add(Activities("Planted a tomoto tree",R.drawable.ic_leaf_circle,2,2))
        activities.add(Activities("Language Learning",R.drawable.ic_leaf_circle,5,2))
        activities.add(Activities("Plant a Tree",R.drawable.ic_leaf_circle,10,2))
        activities.add(Activities("Family Time",R.drawable.ic_leaf_circle,20,2))
        val adapter_actvity = ActivitiesAdapter(requireActivity(),activities)
        val linearLayoutManager_v = LinearLayoutManager(activity)
        linearLayoutManager_v.orientation = LinearLayoutManager.VERTICAL
        dashBoardBinding.activitiesList.adapter = adapter_actvity
        dashBoardBinding.activitiesList.layoutManager = linearLayoutManager_v
        return dashBoardBinding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DashBoardFragment().apply {

            }
    }
}