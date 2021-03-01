package com.aayush.resturant_management_system.RMS.`object`

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.aayush.resturant_management_system.R
import com.aayush.resturant_management_system.RMS.entity.User

import com.aayush.resturant_management_system.RMS.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterActivity : AppCompatActivity() {
//    private lateinit var textView2: TextView
    private lateinit var signup_fullname: EditText
    private lateinit var signup_address: EditText
    private lateinit var signup_email: EditText
    private lateinit var signup_password: EditText
    private lateinit var signup_cfpassword: EditText
    private lateinit var btn_signup: Button
    private lateinit var  btn_signin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        signup_fullname = findViewById(R.id.signup_fullname)
        signup_address = findViewById(R.id.signup_address)
        signup_email = findViewById(R.id.signup_email)
        signup_password = findViewById(R.id.signup_password)
        btn_signup = findViewById(R.id.btn_signup)
        signup_cfpassword = findViewById(R.id.signup_cfpassword)
        btn_signin = findViewById(R.id.btn_signin)
//        textView2 = findViewById(R.id.textView2)

        //api
        btn_signup.setOnClickListener(){
            signupwithApi()
        }

        //open login activity
        btn_signin.setOnClickListener(){
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun signupwithApi() {

    val fullname=signup_fullname.text.toString()
    val address = signup_address.text.toString()
    val email=signup_email.text.toString()
    val password=signup_password.text.toString()
    val cfpassword=signup_cfpassword.text.toString()
    if(password==cfpassword){
        val user = User(name=fullname, email = email, address = address, password = password )
        CoroutineScope(Dispatchers.IO).launch {
            val repository= UserRepository()
            val response= repository.registerUSer(user)
            if (response.success == true) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@RegisterActivity, "Signup Successfull", Toast.LENGTH_SHORT).show()
                    clear()
                }
            }
            else {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@RegisterActivity, "Error Register", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    else{
        Toast.makeText(this, "Password and Confirm Password is unique", Toast.LENGTH_SHORT).show()
    }
}
    private fun clear() {
        signup_email.setText("")
        signup_fullname.setText("")
        signup_address.setText("")
        signup_password.setText("")
        signup_cfpassword.setText("")
    }




}