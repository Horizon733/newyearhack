package com.example.newyearhack

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.item_page.view.*


class ViewPager(var activity: MainActivity, var labels : List<String>, private var images : List<Int>,var window: Window, var color:List<Int>) : RecyclerView.Adapter<ViewPager.ViewPagerHolder>(){

    inner class ViewPagerHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_page, parent, false)
        return ViewPagerHolder(view)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        val curImage = images[position]
        val curLabel = labels[position]
        val curColor = color[position]
        holder.itemView.viewImage.setImageResource(curImage);
        holder.itemView.viewLabel.setText(curLabel)
    }
}