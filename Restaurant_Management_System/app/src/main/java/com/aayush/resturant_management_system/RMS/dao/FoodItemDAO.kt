package com.aayush.resturant_management_system.RMS.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.aayush.resturant_management_system.RMS.entity.FoodItem


@Dao
interface FoodItemDAO {
    @Insert
    suspend fun AddProdcut(list:List<FoodItem>?)

    @Query("select * from FoodItem")
    suspend fun getproduct(): List<FoodItem>?

    @Query("Delete from FoodItem")
    suspend fun deleteFoodItem()

    @Insert
    suspend fun insertfoodItem(fooditem: MutableList<FoodItem>?)

    @Query("delete from FoodItem")
    suspend fun dropTable()
}