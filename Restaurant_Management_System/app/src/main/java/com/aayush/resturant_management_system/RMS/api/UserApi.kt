package com.aayush.resturant_management_system.RMS.api


import com.aayush.resturant_management_system.RMS.entity.User
import com.aayush.resturant_management_system.RMS.response.LoginResponse
import com.aayush.resturant_management_system.RMS.response.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserApi {

    @POST("user/add")
    suspend fun userAdd(@Body users: User): Response<RegisterResponse>


    @POST("user/login")
    suspend fun checkUser(
      @Body user:User
    ): Response<LoginResponse>

}