package com.aayush.resturant_management_system.RMS.api

import com.aayush.resturant_management_system.RMS.response.FoodItemResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface FoodItemApi {
    @GET("fooditem/display")
    suspend fun displayFoodtem(
            @Header("Authorization") token : String

    ): Response<FoodItemResponse>
}