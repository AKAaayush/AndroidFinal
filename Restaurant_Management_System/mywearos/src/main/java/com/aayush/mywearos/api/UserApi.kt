package com.aayush.mywearos.api

import com.aayush.mywearos.entity.User
import com.aayush.mywearos.response.LoginResponse
import retrofit2.Response
import retrofit2.http.*

interface UserApi {



    @POST("user/login")
    suspend fun checkUser(
        @Body user: User
    ): Response<LoginResponse>




}