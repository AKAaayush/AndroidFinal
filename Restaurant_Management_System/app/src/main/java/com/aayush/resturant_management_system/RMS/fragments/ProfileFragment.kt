package com.aayush.resturant_management_system.RMS.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.aayush.resturant_management_system.R
import com.aayush.resturant_management_system.RMS.api.ServiceBuilder
import com.aayush.resturant_management_system.RMS.entity.User
import com.aayush.resturant_management_system.RMS.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception


class ProfileFragment : Fragment() {
    //binding
    private  lateinit var  profile : TextView
    private lateinit var  profilename : TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        profile = view.findViewById(R.id.profile)
        profilename = view.findViewById(R.id.profilename)
        CoroutineScope(Dispatchers.IO).launch {
            try {

                val repositry = UserRepository()
                val response = repositry.getUser(ServiceBuilder.id!!)
                if (response.success == true) {
                    val data = response.data
                    Log.d("Data is: ", response.data!!.toString())
                    val name = "${data!!.name}"

                    withContext(Dispatchers.Main) {
                        profilename.text = name
                    }

                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(context, response.msg, Toast.LENGTH_SHORT).show()
                    }
                }

            } catch (e: Exception) {
                Log.d("25A:",e.localizedMessage)
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Here", Toast.LENGTH_SHORT).show()
                }
            }


        }

        return view;

//        profileview()


    }


//  private fun profileview(){
//      val pf = profile.text.toString()
//      val user= User(email=pf)
//
//
//      CoroutineScope(Dispatchers.IO).launch {
//
//          try{
//              val repository = UserRepository()
//              val response = repository.checkUser(user = user)
//              if(response.success == true){
//                  ServiceBuilder.token = "Bearer " + response.token
//                  profile.setText(pf)
//
//              }
//      }
//          catch (ex:Exception){
//
//          }
//      }
//
//
//
//  }
    }



