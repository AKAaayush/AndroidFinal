package com.aayush.resturant_management_system.RMS.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aayush.resturant_management_system.R
import com.aayush.resturant_management_system.RMS.api.ServiceBuilder
import com.aayush.resturant_management_system.RMS.entity.FoodMenu
import com.bumptech.glide.Glide

class FoodMenuAdapter (
    private val data: ArrayList<FoodMenu>,
    var mContext: Context
    ): RecyclerView.Adapter<FoodMenuAdapter.HomeViewholder>() {
        private var listFoodMenu: ArrayList<FoodMenu> = data
        inner class HomeViewholder(val view: View) : RecyclerView.ViewHolder(view) {


            fun bind(foodMenu:FoodMenu, index: Int) {
                val menuname = view.findViewById<TextView>(R.id.mname)
                val mtitle = view.findViewById<TextView>(R.id.mtitle)
                val fooddesc = view.findViewById<TextView>(R.id.fooddesc)
                val foodprice = view.findViewById<TextView>(R.id.foodprice)
                val imageView = view.findViewById<ImageView>(R.id.imageView)

//
                val _id=foodMenu._id
                menuname.text = foodMenu.menu_name
                mtitle.text = foodMenu.menu_title
                fooddesc.text = foodMenu.menu_desc
                foodprice.text = foodMenu.menu_price


                val imagePath = ServiceBuilder.loadImagepath() + foodMenu.menu_image
                if (!foodMenu.menu_image.equals("no-photo.png")) {
                    Glide.with(mContext)
                        .load(imagePath)
                        .fitCenter()
                        .into(imageView)
                }
//            val student=Student(name.text.toString() ,age.text.toString(),gender,address)



            }
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewholder {
            val view= LayoutInflater.from(parent.context)
                .inflate(R.layout.foodmenulayout, parent, false)
            return HomeViewholder(view)
        }

        override fun onBindViewHolder(holder: HomeViewholder, position: Int) {
            holder.bind(listFoodMenu[position], position)

        }

        override fun getItemCount(): Int {
            return listFoodMenu.size
        }



    }