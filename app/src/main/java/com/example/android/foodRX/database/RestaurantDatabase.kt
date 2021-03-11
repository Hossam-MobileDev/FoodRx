

package com.example.android.foodRX.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android.foodRX.domain.model.Restaurant

@Database(entities = [Restaurant::class], version = 1)
abstract class RestaurantDatabase : RoomDatabase() {

  abstract fun restaurantDao(): RestaurantDao

  companion object {
    @Volatile
    private var INSTANCE: RestaurantDatabase? = null

    fun getInstance(context: Context): RestaurantDatabase =
        INSTANCE ?: synchronized(this) {
          INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

    private fun buildDatabase(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            RestaurantDatabase::class.java, "Restaurant.db"
        ).build()
  }
}