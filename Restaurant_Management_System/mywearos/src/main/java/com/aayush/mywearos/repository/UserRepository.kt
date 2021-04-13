package com.aayush.mywearos.repository

import com.aayush.mywearos.api.ApiRequest
import com.aayush.mywearos.api.ServiceBuilder
import com.aayush.mywearos.api.UserApi
import com.aayush.mywearos.entity.User
import com.aayush.mywearos.response.LoginResponse

class UserRepository: ApiRequest() {
    val myApi= ServiceBuilder.buildServices(UserApi::class.java)


    suspend fun checkUser(user: User): LoginResponse {
        return apiRequest {
            myApi.checkUser(user)
        }
    }


}