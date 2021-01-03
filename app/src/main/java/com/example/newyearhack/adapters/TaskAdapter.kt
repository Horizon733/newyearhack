package com.example.newyearhack.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newyearhack.R
import com.example.newyearhack.home.Tasks

class TaskAdapter (var context: Context, var taskList:MutableList<Tasks>): RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.resolution_item_list, parent, false)
        return TaskAdapter.TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = taskList[position]
        holder.task_name.setText(task.task_name)
        holder.progress.setText("${task.progress}")
        holder.unit.setText("days")
        holder.time.setText(mintoday(task.task_time))
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

 fun mintoday(time:Int):String{
     return "${time/24/60}"
 }

    class TaskViewHolder(view: View): RecyclerView.ViewHolder(view){
        val task_name = view.findViewById<TextView>(R.id.resolution)
        val progress = view.findViewById<TextView>(R.id.progresss)
        val unit = view.findViewById<TextView>(R.id.unit)
        val time = view.findViewById<TextView>(R.id.quote)
    }
}