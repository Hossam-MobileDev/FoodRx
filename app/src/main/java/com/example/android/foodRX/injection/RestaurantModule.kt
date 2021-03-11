

package com.example.android.foodRX.injection

import com.example.android.foodRX.database.RestaurantDatabase
import com.example.android.foodRX.domain.GetRestaurants
import com.example.android.foodRX.domain.SaveRestaurants
import com.example.android.foodRX.presentation.RestaurantViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val restaurantModule = module {
  single { RestaurantDatabase.getInstance(androidContext()).restaurantDao() }

  single { GetRestaurants(get()) }

  single { SaveRestaurants(get()) }

  viewModel {
    RestaurantViewModel(getRestaurants = get(),
        saveRestaurants = get())
  }
}