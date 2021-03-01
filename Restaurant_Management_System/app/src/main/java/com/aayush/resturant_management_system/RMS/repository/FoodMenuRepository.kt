package com.aayush.resturant_management_system.RMS.repository

import com.aayush.resturant_management_system.RMS.api.ApiRequest
import com.aayush.resturant_management_system.RMS.api.FoodMenuApi
import com.aayush.resturant_management_system.RMS.api.ServiceBuilder
import com.aayush.resturant_management_system.RMS.api.UserApi
import com.aayush.resturant_management_system.RMS.response.FoodMenuResponse


class FoodMenuRepository: ApiRequest() {
    private val FoodMenuApi = ServiceBuilder.buildServices(FoodMenuApi::class.java)

    suspend fun  getFoodMenuApiData(): FoodMenuResponse {
        return apiRequest {
            FoodMenuApi.displayMenu(ServiceBuilder.token!!)
        }
    }
}