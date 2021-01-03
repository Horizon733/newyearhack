package com.example.newyearhack.signup

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.newyearhack.R
import com.example.newyearhack.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class LoginFragment : Fragment() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var fragmentLoginBinding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseAuth = FirebaseAuth.getInstance()
        fragmentLoginBinding = FragmentLoginBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  fragmentLoginBinding.root
        val registerFragment = RegisterFragment()
        fragmentLoginBinding.registerLinkBtn.setOnClickListener {
            view.findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
        fragmentLoginBinding.signInBtn.setOnClickListener {
            authUser()
        }
        fragmentLoginBinding.forgotPassword.setOnClickListener {
            forgotPassword()
        }
        return view
    }
    fun authUser(){
        val email = fragmentLoginBinding.emailEtLogin.text.toString().trim()
        val pass = fragmentLoginBinding.passwordEtLogin.text.toString().trim()
        if(email.isEmpty()){
            fragmentLoginBinding.emailEtLogin.error = "Please enter your email"
        }
        else if(pass.isEmpty()){
            fragmentLoginBinding.passwordEtLogin.error = "Please enter password"
        }
        else if (pass.isNotEmpty() && email.isNotEmpty()){
            firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener { task ->

                if (!task.isSuccessful) {
                    Log.e("Firebase login", "${task.exception}")
                    Toast.makeText(context, "Error occured", Toast.LENGTH_SHORT).show()
                } else if (task.isSuccessful) {
                    view?.findNavController()?.navigate(R.id.action_loginFragment_to_homeActivity)
                   (activity as SignupActivity).finish()
                }
            }
        }
    }
    fun forgotPassword(){
        val passwordResetFragment = PasswordResetFragment()
        activity?.supportFragmentManager?.beginTransaction()?.add(passwordResetFragment,"Password Reset")?.commit()
    }
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}