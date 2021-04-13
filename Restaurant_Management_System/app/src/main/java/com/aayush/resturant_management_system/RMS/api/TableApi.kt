package com.aayush.resturant_management_system.RMS.api

import com.aayush.resturant_management_system.RMS.entity.Table
import com.aayush.resturant_management_system.RMS.response.TableResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface TableApi {
    @POST("addtable")
    suspend fun tableAdd(@Body tables: Table): Response<TableResponse>

}