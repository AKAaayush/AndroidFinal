package com.aayush.resturant_management_system.RMS.repository

import com.aayush.resturant_management_system.RMS.api.ApiRequest
import com.aayush.resturant_management_system.RMS.api.ServiceBuilder
import com.aayush.resturant_management_system.RMS.api.UserApi
import com.aayush.resturant_management_system.RMS.entity.User
import com.aayush.resturant_management_system.RMS.response.ImageResponse

import com.aayush.resturant_management_system.RMS.response.LoginResponse
import com.aayush.resturant_management_system.RMS.response.RegisterResponse
import com.aayush.resturant_management_system.RMS.response.UserUpdateResponse
import okhttp3.MultipartBody


class UserRepository: ApiRequest() {
    val myApi = ServiceBuilder.buildServices(UserApi::class.java)

    suspend fun registerUSer(user: User): RegisterResponse {
        return apiRequest {
            myApi.userAdd(user)
        }
    }

    suspend fun checkUser(user: User): LoginResponse {
        return apiRequest {
            myApi.checkUser(user)
        }
    }

    suspend fun getUser(id: String): LoginResponse {
        return apiRequest {
            myApi.viewUser(ServiceBuilder.token!!, id)
        }
    }


    suspend fun uploadImage(id: String, body: MultipartBody.Part)
            : ImageResponse {
        return apiRequest {
            myApi.uploadImage(ServiceBuilder.token!!, id, body)
        }
    }


    suspend fun updateUser(user: User): UserUpdateResponse {
        return apiRequest {
            myApi.updateUser(ServiceBuilder.token!!, user)
        }
    }
}



