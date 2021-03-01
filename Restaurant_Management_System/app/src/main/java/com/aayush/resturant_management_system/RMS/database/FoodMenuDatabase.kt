package com.aayush.resturant_management_system.RMS.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aayush.resturant_management_system.RMS.dao.FoodMenuDAO
import com.aayush.resturant_management_system.RMS.dao.UserDAO
import com.aayush.resturant_management_system.RMS.entity.FoodMenu
import com.aayush.resturant_management_system.RMS.entity.User


@Database(
        entities =[(User::class), (FoodMenu::class)],
        version = 1
)
abstract class
FoodMenuDatabase: RoomDatabase() {
    abstract fun getUserDAO(): UserDAO
    abstract fun getFoodMenuDAO(): FoodMenuDAO

    companion object{
        @Volatile
        private var instance:FoodMenuDatabase?= null
        fun getInstance(context: Context):FoodMenuDatabase{
            if(instance==null){
                synchronized(FoodMenuDatabase::class){
                    instance=buildDatabase(context)
                }
            }
            return instance!!
        }

        private fun buildDatabase(context: Context)=
                Room.databaseBuilder(
                        context.applicationContext,
                        FoodMenuDatabase::class.java,
                        "FoodMenuDB"
                ).build()
    }
}