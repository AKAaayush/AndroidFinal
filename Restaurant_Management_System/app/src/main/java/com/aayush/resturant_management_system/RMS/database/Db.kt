package com.aayush.resturant_management_system.RMS.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aayush.resturant_management_system.RMS.dao.AddtoCartDAO
import com.aayush.resturant_management_system.RMS.dao.FoodItemDAO
import com.aayush.resturant_management_system.RMS.dao.UserDAO
import com.aayush.resturant_management_system.RMS.entity.FoodItem
import com.aayush.resturant_management_system.RMS.entity.ForAddItem
import com.aayush.resturant_management_system.RMS.entity.User

@Database(
    entities = [(User::class), (FoodItem::class),(ForAddItem::class)],
    version = 1,
    exportSchema = false
)
abstract class Db: RoomDatabase() {
    abstract fun getUserDao(): UserDAO
    abstract fun getFoodItemDAO(): FoodItemDAO
    abstract fun getAddToCartDAO(): AddtoCartDAO
    companion object{
        @Volatile
        private var instance:Db?=null
        fun getInstance(context: Context):Db{
            if(instance==null){
                synchronized(Db::class){
                    instance=builderDatabase(context)
                }
            }
            return instance!!
        }

        private fun builderDatabase(context: Context)= Room.databaseBuilder(
            context.applicationContext,
            Db::class.java,
            "UserDatabse"
        ).build()
    }
}
