package com.aayush.mywearos

import android.content.Intent
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.aayush.mywearos.api.ServiceBuilder
import com.aayush.mywearos.entity.User
import com.aayush.mywearos.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : WearableActivity() {

    private lateinit var login_email: EditText
    private lateinit var login_password: EditText
    private lateinit var btn_login: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login_email = findViewById(R.id.login_email)
        login_password = findViewById(R.id.login_password)
        btn_login = findViewById(R.id.btn_login)




        btn_login.setOnClickListener(){
            CoroutineScope(Dispatchers.IO).launch {
                val repository= UserRepository()
                val response=repository.checkUser(User(email = login_email.text.toString(),password = login_password.text.toString()))
                if(response.success==true){
                    ServiceBuilder.token="Bearer ${response.token}"
                    ServiceBuilder.id=response.id
                    withContext(Dispatchers.Main){
                        Toast.makeText(this@MainActivity, "${response.id}", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@MainActivity,HomeActivity::class.java))
                    }
                }
            }

//            val intent= Intent(this, BMIActivity::class.java)
//            startActivity(intent)
        }

        // Enables Always-on
        setAmbientEnabled()
    }
}