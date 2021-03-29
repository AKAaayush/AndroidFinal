package com.aayush.resturant_management_system.RMS.`object`

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.aayush.resturant_management_system.R
import com.aayush.resturant_management_system.RMS.api.ServiceBuilder
import com.aayush.resturant_management_system.RMS.entity.User
import com.aayush.resturant_management_system.RMS.fragments.HomeFragment
import com.aayush.resturant_management_system.RMS.fragments.ProfileFragment
import com.aayush.resturant_management_system.RMS.repository.UserRepository
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {

    //animation Variables
    private  lateinit var  topAnim : Animation
    private  lateinit var  bottomAnim : Animation

    private lateinit var  image : ImageView
    private  lateinit var  logo : TextView
    private lateinit var  slogan : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val sharedPref = getSharedPreferences("MyPref", AppCompatActivity.MODE_PRIVATE)
        val emailPref = sharedPref.getString("email", null)
        val passwordPref = sharedPref.getString("password", "")
        CoroutineScope(Dispatchers.Main).launch {
            delay(2500)

            if (emailPref != null) {
                withContext(Dispatchers.Main){
                    Toast.makeText(this@SplashActivity, "$emailPref + ", Toast.LENGTH_SHORT).show()
                    val repository = UserRepository()
                    val user = User(email = emailPref, password = passwordPref)
                    val response = repository.checkUser(user)
                    if (response.success == true) {
                        ServiceBuilder.token="Bearer ${response.token}"
                        ServiceBuilder.id=response.id
                        delay(500)
                        startActivity(Intent(this@SplashActivity, MainActivity::class.java)
                        )
                        finish()
                    }
                }
            }

//            startActivity(
//                Intent(
//                    this@SplashActivity,
//                    SliderActivity::class.java
//                )
//            )
            else {
                withContext(Dispatchers.Main){
                    startActivity(
                        Intent(
                            this@SplashActivity,
                            LoginActivity::class.java
                        )
                    )
                }
                finish()
            }        }

        //splash
        topAnim =AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim =AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        image = findViewById(R.id.imageView2)
        logo = findViewById(R.id.textView)
        slogan = findViewById(R.id.textView3)
        //animation
        image.animation = topAnim
        logo.animation = bottomAnim
        slogan.animation = bottomAnim
    }
}