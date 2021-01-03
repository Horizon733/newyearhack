package com.example.newyearhack.signup

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.newyearhack.MainActivity
import com.example.newyearhack.R
import com.example.newyearhack.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth


class RegisterFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private lateinit var registerBinding: FragmentRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding = FragmentRegisterBinding.inflate(layoutInflater)
        auth = FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val loginFragment = LoginFragment()
        registerBinding.loginLinkBtn.setOnClickListener {
           view?.findNavController()?.navigate(R.id.action_registerFragment_to_loginFragment2)
        }
        registerBinding.signUpBtn.setOnClickListener {
            registerUser()
        }
        return registerBinding.root
    }
    fun registerUser(){
        val email = registerBinding.emailEtRg.text.toString().trim()
        val pass1 = registerBinding.passwordEtRg.text.toString().trim()
        val pass2 = registerBinding.passwordConfirmEtRg.text.toString().trim()
        if(pass1.equals(pass2)){
            auth.createUserWithEmailAndPassword(email,pass2).addOnCompleteListener {
                    task ->
                if( !task.isSuccessful){
                    Log.e("Firebase","${task.result}")
                    Toast.makeText(context,"Error occured", Toast.LENGTH_SHORT).show()
                }else{
                    view?.findNavController()?.navigate(R.id.action_registerFragment_to_homeActivity)
                    (activity as SignupActivity).finish()
                }
            }
        }else{
            registerBinding.passwordConfirmTextInput.error = "Both Passwords Should Match"
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegisterFragment().apply {

            }
    }
}