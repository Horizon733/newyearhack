package com.example.newyearhack.signup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.newyearhack.R
import com.example.newyearhack.signup.LoginFragment

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val loginFragment = LoginFragment()
        supportFragmentManager.beginTransaction().add(loginFragment,"Login").commit()
    }


}