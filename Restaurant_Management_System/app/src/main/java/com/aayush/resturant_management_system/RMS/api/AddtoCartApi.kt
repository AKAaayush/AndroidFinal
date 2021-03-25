package com.aayush.resturant_management_system.RMS.api

import com.aayush.resturant_management_system.RMS.entity.AddCart
import com.aayush.resturant_management_system.RMS.response.AddtoCartResponse
import com.aayush.resturant_management_system.RMS.response.ForAddItemRespomse
import retrofit2.Response
import retrofit2.http.*

interface AddtoCartApi {
    @GET("fav/profuct/{id}")
    suspend fun getAllFavProduct(
        @Header("Authorization") token:String,
        @Path("id") userId:String
    ): Response<ForAddItemRespomse>

    @POST("add/fav")
    suspend fun AddFavtheProduct(
        @Header("Authorization") token:String,
        @Body addCart: AddCart
    ): Response<AddtoCartResponse>

    @GET("fav/product/by/{id}")
    suspend fun getParticularFavPRoduct(
        @Header("Authorization") token:String,
        @Path("id") userId:String
    ): Response<AddtoCartResponse>

    @DELETE("delete/bookmark/{PId}")
    suspend fun deleteFavPRoduct(
        @Header("Authorization") token:String,
        @Path("PId") PId:String
    ): Response<AddtoCartResponse>
}