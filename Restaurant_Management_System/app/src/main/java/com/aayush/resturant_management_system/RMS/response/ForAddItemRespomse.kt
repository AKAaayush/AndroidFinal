package com.aayush.resturant_management_system.RMS.response

import com.aayush.resturant_management_system.RMS.entity.AddCart

class ForAddItemRespomse (
    val success:Boolean?=null,
    val msg:String?=null,
    val data:List<AddCart>?=null,
    val id:String?=null
)