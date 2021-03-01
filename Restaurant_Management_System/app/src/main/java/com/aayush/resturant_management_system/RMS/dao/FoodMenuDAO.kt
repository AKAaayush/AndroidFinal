package com.aayush.resturant_management_system.RMS.dao

import com.aayush.resturant_management_system.RMS.entity.FoodMenu
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FoodMenuDAO {
   @Query("Delete from FoodMenu")
    suspend fun deleteFoodMenu()







    @Insert
    suspend fun insertfoodmenu(foodmenu: MutableList<FoodMenu>?)
}