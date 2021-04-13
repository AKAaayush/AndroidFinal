package com.aayush.resturant_management_system.RMS.repository

import com.aayush.resturant_management_system.RMS.api.ApiRequest
import com.aayush.resturant_management_system.RMS.api.ServiceBuilder
import com.aayush.resturant_management_system.RMS.api.TableApi
import com.aayush.resturant_management_system.RMS.api.UserApi
import com.aayush.resturant_management_system.RMS.entity.Table
import com.aayush.resturant_management_system.RMS.entity.User
import com.aayush.resturant_management_system.RMS.response.RegisterResponse
import com.aayush.resturant_management_system.RMS.response.TableResponse

class TableRepository :ApiRequest(){
    val myApi= ServiceBuilder.buildServices(TableApi::class.java)

    suspend fun registerTable(table: Table): TableResponse {
        return apiRequest {
            myApi.tableAdd(table)
        }
    }
}