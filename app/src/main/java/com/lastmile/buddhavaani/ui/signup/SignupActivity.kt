package com.lastmile.buddhavaani.ui.signup

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.lastmile.buddhavaani.R
import com.lastmile.buddhavaani.databinding.ActivitySignupBinding
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {

    lateinit var binding:ActivitySignupBinding
    lateinit var userViewModel: SignupViewModel
    lateinit var context: Context

    lateinit var strUsername: String
    lateinit var strPassword: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        context = this@SignupActivity

        userViewModel = ViewModelProvider(this).get(SignupViewModel::class.java)

        binding.btnAddLogin.setOnClickListener {
            strUsername = binding.txtUsername.text.toString().trim()
            strPassword = binding.txtPassword.text.toString().trim()

            if(strUsername.isEmpty()){
                binding.txtUsername.error = "Please enter the username"
            } else if(strPassword.isEmpty()){
                binding.txtPassword.error = "Please enter the password"
            } else {
                userViewModel.insertData(context, strUsername, strPassword)
                binding.lblInsertResponse.text = "Inserted Successfully"
            }
        }


        binding.btnReadLogin.setOnClickListener {
            strUsername = binding.txtUsername.text.toString().trim()

            userViewModel.getUserDetails(context, strUsername)!!.observe(this, Observer {

                if (it == null) {
                    binding.lblReadResponse.text = "Data Not Found"
                    binding.lblUseraname.text = "-----"
                    binding.lblPassword.text = "------"
                } else {
                    binding.lblUseraname.text = it.Username
                    binding.lblPassword.text = it.Password

                    binding.lblReadResponse.text = "Data Found Successfully"
                }
            })
        }

    }


}