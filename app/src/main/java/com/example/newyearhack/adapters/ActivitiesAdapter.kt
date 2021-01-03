package com.example.newyearhack.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newyearhack.R
import com.example.newyearhack.home.Activities

class ActivitiesAdapter (var context: Context, var activityList:MutableList<Activities>): RecyclerView.Adapter<ActivitiesAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_list_item, parent, false)
        return ActivitiesAdapter.TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val activities = activityList[position]
        holder.activity_name.setText(activities.task_name)
        holder.task_time.setText("${activities.time_taken} mins")
        holder.time_ago.setText("${activities.time_ago} hrs ago")
        holder.icon.setBackgroundResource(activities.icon)
    }

    override fun getItemCount(): Int {
        return activityList.size
    }



    class TaskViewHolder(view: View): RecyclerView.ViewHolder(view){
        val activity_name = view.findViewById<TextView>(R.id.activity_name)
        val task_time = view.findViewById<TextView>(R.id.activity_time)
        val time_ago = view.findViewById<TextView>(R.id.time_ago)
        val icon = view.findViewById<ImageView>(R.id.activity_image)
    }
}