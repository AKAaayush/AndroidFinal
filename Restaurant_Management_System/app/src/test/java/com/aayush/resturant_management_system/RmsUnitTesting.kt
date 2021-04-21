package com.aayush.resturant_management_system

import com.aayush.resturant_management_system.RMS.api.ServiceBuilder
import com.aayush.resturant_management_system.RMS.entity.User
import com.aayush.resturant_management_system.RMS.repository.FoodItemRepository
import com.aayush.resturant_management_system.RMS.repository.UserRepository
import junit.framework.Assert
import kotlinx.coroutines.runBlocking
import org.junit.Test

class RmsUnitTesting {

    private var repository= UserRepository()


    @Test
    fun checkRegisterUSer() = runBlocking {
        val user =
            User(name = "this is test", email = "thidscx2ssa13@gmail.com", address = "KTM", password = "admin12")
        repository = UserRepository()
        val expectedResult = true
        val response = repository.registerUSer(user)
        val actualResult = response.success!!
        Assert.assertEquals(expectedResult, actualResult)
    }



    @Test
    fun loginUser() = runBlocking {
        val user = User(email = "aayush@gmail.com", password = "admin12")
        repository = UserRepository()
        val expectedResult = true
        val response = repository.checkUser(user)
        val actualResult = response.success
        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun getme() = runBlocking {
        val user = User(email = "aayush@gmail.com", password = "admin12")
        repository = UserRepository()
        val expectedResult = true
        val response = repository.checkUser(user)
        ServiceBuilder.token = "Bearer " + response.token
        ServiceBuilder.id = response.id
        if (response.success == true) {
            val actualResult = repository.getUser(ServiceBuilder.id!!).success
            Assert.assertEquals(expectedResult, actualResult)
        }
    }

    @Test
    fun getAllFood()= runBlocking {
        val user = User(email = "aayush@gmail.com", password = "admin12")
        repository = UserRepository()
        val expectedResult = true
        val response = repository.checkUser(user)
        ServiceBuilder.token = "Bearer " + response.token
        ServiceBuilder.id = response.id
        val repo=FoodItemRepository()
        val actualResult=repo.getFoodItemApiData().success
        Assert.assertEquals(expectedResult, actualResult)
    }
    @Test
    fun getAllFoodItem()= runBlocking {
        val user = User(email = "aayush@gmail.com", password = "admin12")
        repository = UserRepository()
        val expectedResult = true
        val response = repository.checkUser(user)
        ServiceBuilder.token = "Bearer " + response.token
        ServiceBuilder.id = response.id
        val repo=FoodItemRepository()
        val actualResult=repo.getallAddtoCart(ServiceBuilder.id!!).success
        Assert.assertEquals(expectedResult, actualResult)
    }
}