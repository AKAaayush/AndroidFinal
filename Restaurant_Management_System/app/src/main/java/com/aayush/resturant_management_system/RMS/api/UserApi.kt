package com.aayush.resturant_management_system.RMS.api


import com.aayush.resturant_management_system.RMS.entity.User
import com.aayush.resturant_management_system.RMS.response.LoginResponse
import com.aayush.resturant_management_system.RMS.response.RegisterResponse
import retrofit2.Response
import retrofit2.http.*

interface UserApi {

    @POST("user/add")
    suspend fun userAdd(@Body users: User): Response<RegisterResponse>


    @POST("user/login")
    suspend fun checkUser(
      @Body user:User
    ): Response<LoginResponse>

    @GET("user/display/{id}")
    suspend fun viewUser(
        @Header("Authorization") token: String,
        @Path("id") id: String
        // @Body user: User
    ): Response<LoginResponse>



}