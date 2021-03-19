package com.aayush.resturant_management_system.RMS.response

import com.aayush.resturant_management_system.RMS.entity.FoodItem

data class FoodItemResponse (
        val success : Boolean? = null,
        val data : MutableList<FoodItem>? = null
)