package com.aayush.resturant_management_system.RMS.repository

import com.aayush.resturant_management_system.RMS.api.AddtoCartApi
import com.aayush.resturant_management_system.RMS.api.ApiRequest
import com.aayush.resturant_management_system.RMS.api.ServiceBuilder
import com.aayush.resturant_management_system.RMS.entity.AddCart
import com.aayush.resturant_management_system.RMS.response.AddtoCartResponse
import com.aayush.resturant_management_system.RMS.response.ForAddItemRespomse

class AddToCartRepository : ApiRequest(){
    val myApi= ServiceBuilder.buildServices(AddtoCartApi::class.java)
    suspend fun getallFavFoodItem(id:String): ForAddItemRespomse {
        return apiRequest {
            myApi.getAllFavProduct(ServiceBuilder.token!!,id)
        }
    }
    suspend fun AddFav(addFav: AddCart):AddtoCartResponse{
        return apiRequest {
            myApi.AddFavtheProduct(ServiceBuilder.token!!,addFav)
        }
    }
//    suspend fun getParticularNote():AddtoCartResponse{
//        return apiRequest {
//            myApi.getParticularFavPRoduct(ServiceBuilder.token!!,ServiceBuilder.id!!)
//        }
//    }
    suspend fun deleteFavProduct(noteId:String):AddtoCartResponse{
        return apiRequest {
            myApi.deleteFavPRoduct(ServiceBuilder.token!!,noteId)
        }
    }
}