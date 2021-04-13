package com.aayush.resturant_management_system.RMS.api

import com.aayush.resturant_management_system.RMS.response.AddtoCartResponse
import com.aayush.resturant_management_system.RMS.response.FoodItemResponse
import com.aayush.resturant_management_system.RMS.response.LoginResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface FoodItemApi {
    @GET("fooditem/display")
    suspend fun displayFoodtem(
            @Header("Authorization") token : String

    ): Response<FoodItemResponse>

    @GET("food/single/{id}")
    suspend fun getallProduct(
        @Header("Authorization") token: String,
        @Path("id") userId:String
    ):Response<AddtoCartResponse>
    @Multipart
    @PUT("product/image/{id}")
    suspend fun uploadImage(
        @Header("Authorization") token:String,
        @Path("id") id:String,
        @Part file: MultipartBody.Part
    ): Response<LoginResponse>

}

