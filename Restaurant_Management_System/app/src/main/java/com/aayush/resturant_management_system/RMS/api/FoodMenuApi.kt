package com.aayush.resturant_management_system.RMS.api

import com.aayush.resturant_management_system.RMS.response.FoodMenuResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface FoodMenuApi {
    @GET("menu/display")
    suspend fun displayMenu(
            @Header("Authorization") token: String
    ): Response<FoodMenuResponse>
}