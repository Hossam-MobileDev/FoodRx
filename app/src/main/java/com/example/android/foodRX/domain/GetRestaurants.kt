

package com.example.android.foodRX.domain

import com.example.android.foodRX.database.RestaurantDao
import com.example.android.foodRX.domain.model.Restaurant
import io.reactivex.Single
import java.util.concurrent.TimeUnit

class GetRestaurants(private val dataSource: RestaurantDao) {
  operator fun invoke(): Single<List<Restaurant>> {
    return dataSource.loadAllRestaurants()
        .delay(1000, TimeUnit.MILLISECONDS)
  }
}