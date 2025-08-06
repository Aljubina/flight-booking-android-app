package com.and.flightbooking.ViewModel

import androidx.lifecycle.LiveData
import com.and.flightbooking.Activities.Domain.LocationModel
import com.and.flightbooking.Repository.MainRepository

class MainViewModel {
    private val repository = MainRepository()
    fun loadLocation(): LiveData<MutableList<LocationModel>>{
        return repository.loadLocation()
    }
}