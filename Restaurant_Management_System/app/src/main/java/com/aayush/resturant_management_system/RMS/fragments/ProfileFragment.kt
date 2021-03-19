package com.aayush.resturant_management_system.RMS.fragments

import android.os.Bundle
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


class ProfileFragment : Fragment() {
    //binding
    private  lateinit var  profile : TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

                profile =view.findViewById(R.id.profile)
                return view;

        profileview()


        }

  private fun profileview(){
      val pf = profile.text.toString()
      val user= User(email=pf)


      CoroutineScope(Dispatchers.IO).launch {

          try{
              val repository = UserRepository()
              val response = repository.checkUser(user = user)
              if(response.success == true){
                  ServiceBuilder.token = "Bearer " + response.token
                  profile.setText(pf)

              }
      }
          catch (ex:Exception){

          }
      }



  }
    }



