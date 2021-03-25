package com.aayush.resturant_management_system.RMS.response

import com.aayush.resturant_management_system.RMS.entity.User

data class LoginResponse (
    val success:Boolean?=null,
    val token:String?=null,
    val msg:String?=null,
    val data: User?=null,
    val id:String?=null
)