package com.aayush.resturant_management_system.RMS.response

import com.aayush.resturant_management_system.RMS.entity.User

data class UserUpdateResponse (
    val success: Boolean? = null,
    val data: User? = null,
    val id: String?=null
)