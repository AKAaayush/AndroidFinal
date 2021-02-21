package com.aayush.resturant_management_system.RMS.`object`

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.aayush.resturant_management_system.R

class RegisterActivity : AppCompatActivity() {

    private lateinit var  btn_signin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_signin = findViewById(R.id.btn_signin)

        //open login activity
        btn_signin.setOnClickListener(){
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}