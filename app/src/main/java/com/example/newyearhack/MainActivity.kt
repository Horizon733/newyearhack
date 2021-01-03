package com.example.newyearhack



import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.newyearhack.databinding.ActivityMainBinding
import com.example.newyearhack.home.HomeActivity
import com.example.newyearhack.signup.SignupActivity


class MainActivity : AppCompatActivity() {
    lateinit var loginPreference: SharedPreferences
    var MY_PREF = "my_pref"
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        loginPreference = getSharedPreferences(MY_PREF, MODE_PRIVATE)

        if (loginPreference.getString("tag", "notok") == "notok") {
            val edit = loginPreference.edit()
            edit.putString("tag", "ok")
            edit.commit()

            val fragment : Fragment = Splash()
            val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.fragment_container, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        } else if (loginPreference.getString("tag", null) == "ok") {
            val i = Intent(this, SignupActivity::class.java)
            startActivity(i)
            finish()
        }

    }



}