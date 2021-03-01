package com.aayush.resturant_management_system.RMS.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.aayush.resturant_management_system.RMS.entity.User


//room db
@Dao
interface UserDAO {
    @Insert
    suspend fun RegisterActivity(user: User)

//    @Query("select * from User where email=(:email) and password=(:password)")
//    suspend fun checkUser(email: String, password:String)
}