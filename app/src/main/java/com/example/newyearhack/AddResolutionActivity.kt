package com.example.newyearhack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionMode
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import com.example.newyearhack.databinding.ActivityAddResolutionBinding

class AddResolutionActivity : AppCompatActivity() {
    private lateinit var addResolutionBinding: ActivityAddResolutionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addResolutionBinding = ActivityAddResolutionBinding.inflate(layoutInflater)
        setContentView(addResolutionBinding.root)
        //setSupportActionBar(addResolutionBinding.toolbar)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.add_resolution_menu,menu)
        return true
    }
    val actionModeCallback = object: ActionMode.Callback{
        override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.add_resolution_menu,menu)
            return true
        }

        override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            return false
        }

        override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
            return when(item?.itemId){
                R.id.save -> {
                    Toast.makeText(this@AddResolutionActivity,"Saved",Toast.LENGTH_SHORT).show()
                    mode?.finish()
                    true
                }
                else -> false
            }
        }
        override fun onDestroyActionMode(mode: ActionMode?) {

        }
    }


}