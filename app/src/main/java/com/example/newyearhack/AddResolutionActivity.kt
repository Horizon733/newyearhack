package com.example.newyearhack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.newyearhack.databinding.ActivityAddResolutionBinding

class AddResolutionActivity : AppCompatActivity() {
    private lateinit var addResolutionBinding: ActivityAddResolutionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addResolutionBinding = ActivityAddResolutionBinding.inflate(layoutInflater)
        setContentView(addResolutionBinding.root)
        //setSupportActionBar(addResolutionBinding.toolbar)
        val items = listOf("Plant a Tree", "Daily Sprint", "Eat Healthy", "Custom Resolution")
        val adapter = ArrayAdapter(this, R.layout.drop_down_list, items)
        addResolutionBinding.resolutionDd.setAdapter(adapter)


        val items1 = listOf("kg", "cm", "mm")
        val adapter1 = ArrayAdapter(this, R.layout.drop_down_list, items1)
        addResolutionBinding.measurement.setAdapter(adapter1)
        val items2 = listOf("days", "months", "years")
        val adapter2 = ArrayAdapter(this, R.layout.drop_down_list, items2)
        addResolutionBinding.timeAt.setAdapter(adapter2)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.add_resolution_menu,menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
         super.onOptionsItemSelected(item)
        val id = item.itemId
        when(id){
            R.id.save->{
                Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show()
                finish()
                true
            }
            R.id.cancel->{
                finish()
                true}
        }
        return true

    }




}