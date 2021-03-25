package com.aayush.resturant_management_system.RMS.repository

import com.aayush.resturant_management_system.RMS.api.ApiRequest
import com.aayush.resturant_management_system.RMS.api.FoodItemApi
import com.aayush.resturant_management_system.RMS.api.ServiceBuilder
import com.aayush.resturant_management_system.RMS.response.AddtoCartResponse
import com.aayush.resturant_management_system.RMS.response.FoodItemResponse

class FoodItemRepository : ApiRequest() {
    private val FoodItemApi = ServiceBuilder.buildServices(FoodItemApi::class.java)

    suspend fun  getFoodItemApiData() : FoodItemResponse {
        return  apiRequest {
            FoodItemApi.displayFoodtem(ServiceBuilder.token!!)
        }
    }
    suspend fun getallAddtoCart(id:String): AddtoCartResponse {
        return apiRequest {
            FoodItemApi.getallProduct(ServiceBuilder.token!!,id!!)
        }
    }
}