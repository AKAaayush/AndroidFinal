package com.aayush.resturant_management_system.RMS.response

import com.aayush.resturant_management_system.RMS.entity.FoodMenu

data class FoodMenuResponse (
    val success: Boolean? = null,
    val data: MutableList<FoodMenu>? = null
)