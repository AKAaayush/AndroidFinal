package com.aayush.resturant_management_system.RMS.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.aayush.resturant_management_system.RMS.entity.FoodItem


@Dao
interface FoodItemDAO {
    @Query("Delete from FoodItem")
    suspend fun deleteFoodItem()

    @Insert
    suspend fun insertfoodItem(fooditem: MutableList<FoodItem>?)
}