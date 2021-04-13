package com.aayush.mywearos.response

import com.aayush.mywearos.entity.User

data class LoginResponse (
    val success:Boolean?=null,
    val token:String?=null,
    val msg:String?=null,
    val data: User?=null,
    val id:String?=null
)