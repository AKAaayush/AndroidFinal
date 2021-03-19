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
import com.aayush.resturant_management_system.RMS.entity.FoodItem
import com.aayush.resturant_management_system.RMS.entity.FoodMenu
import com.bumptech.glide.Glide

class FoodItemAdapter (
        private val data: ArrayList<FoodItem>,
        var iContext: Context
): RecyclerView.Adapter<FoodItemAdapter.ItemViewholder>() {
    private var listFoodItem: ArrayList<FoodItem> = data
    inner class ItemViewholder(val view: View) : RecyclerView.ViewHolder(view) {


        fun bind(foodItem: FoodItem, index: Int) {
            val fooditemname = view.findViewById<TextView>(R.id.fooditemname)
            val fooditemprice = view.findViewById<TextView>(R.id.fooditemprice)
            val fooditemdesc = view.findViewById<TextView>(R.id.fooditemdesc)
            val imageView = view.findViewById<ImageView>(R.id.fooditemimage)


            val _id=foodItem._id
            fooditemname.text = foodItem.food_name
            fooditemprice.text = foodItem.food_desc
            fooditemdesc.text = foodItem.food_price


            val imagePath = ServiceBuilder.loadImagepath() + foodItem.food_image
            if (!foodItem.food_image.equals("no-photo.png")) {
                Glide.with(iContext)
                        .load(imagePath)
                        .fitCenter()
                        .into(imageView)
            }


        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewholder {
        val view= LayoutInflater.from(parent.context)
                .inflate(R.layout.fooditemlayout, parent, false)
        return ItemViewholder(view)
    }

    override fun onBindViewHolder(holder: ItemViewholder, position: Int) {
        holder.bind(listFoodItem[position], position)

    }

    override fun getItemCount(): Int {
        return listFoodItem.size
    }



}