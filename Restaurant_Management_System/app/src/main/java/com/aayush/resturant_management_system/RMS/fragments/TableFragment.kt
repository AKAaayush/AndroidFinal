package com.aayush.resturant_management_system.RMS.fragments

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils.replace
import android.text.method.TextKeyListener.clear
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.FragmentTransaction
import com.aayush.resturant_management_system.R
import com.aayush.resturant_management_system.RMS.`object`.TableActivity
import com.aayush.resturant_management_system.RMS.entity.Table
import com.aayush.resturant_management_system.RMS.entity.User
import com.aayush.resturant_management_system.RMS.repository.TableRepository
import com.aayush.resturant_management_system.RMS.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class TableFragment : Fragment() {
        private lateinit var user_email : EditText
        private lateinit var people : EditText
        private lateinit var date : DatePicker
        private lateinit var time : Spinner
        private lateinit var btn_table : Button

//
//      fun onCreate(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
//        super.onCreate(savedInstanceState)
//        val view = inflater.inflate(R.layout.fragment_table, container, false)
//
//        user_email = view.findViewById(R.id.user_email)
//        time = view.findViewById(R.id.time)
//        people = view.findViewById(R.id.people)
//        date = view.findViewById(R.id.date)
//          btn_table = view.findViewById(R.id.btn_table)
//
//          btn_table.setOnClickListener(){
////              Toast.makeText(context, "error Booked", Toast.LENGTH_SHORT).show()
////
////              tablebooking()
//              startActivity(context, TableActivity::class.java))
//          }
//
//        return view
//    }

//    override fun onCreate(inflater: LayoutInflater, container: ViewGroup?,
//                          savedInstanceState: Bundle?): View?  {
//
//
//
//        return inflater.inflate(R.layout.fragment_table, container, false)
//
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_table = view.findViewById(R.id.btn_table)
        user_email = view.findViewById(R.id.user_email)
        time = view.findViewById(R.id.time)
        people = view.findViewById(R.id.people)
        date = view.findViewById(R.id.date)
        btn_table.setOnClickListener() {
            tablebooking()

        }
    }
    private  fun tablebooking() {
        val user_email = user_email.text.toString()
        val people = people.text.toString()
        val date = date.toString()
        val time = time.toString()

        val table = Table(user_email = user_email, people = people, date = date, time = time)
        CoroutineScope(Dispatchers.IO).launch {
            val repository = TableRepository()
            val response = repository.registerTable(table)
            if (response.success == true) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Table Booked", Toast.LENGTH_SHORT).show()
                    clear()
                }
            } else {
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "error Booked", Toast.LENGTH_SHORT).show()
                }
            }

        }



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_table, container, false)

        return view;
    }
    private fun clear() {
        user_email.setText("")
        people.setText("")

    }


}