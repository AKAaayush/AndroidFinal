package com.aayush.resturant_management_system.RMS.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class FoodItem (
@PrimaryKey(autoGenerate = false)
        val _id : String = "",
        val food_name : String? = null,
        val food_price : String? = null,
        val food_desc : String? = null,
        val food_image : String? = null
)