package com.aayush.resturant_management_system.RMS.response

import com.aayush.resturant_management_system.RMS.entity.ForAddItem

class AddtoCartResponse (val success:Boolean?=null,
                         val data:List<ForAddItem>?=null,
                         val msg:String?=null,
                         val id:String?=null)