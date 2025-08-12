package com.and.flightbooking.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.and.flightbooking.Domain.FlightModel
import com.and.flightbooking.Domain.LocationModel
import com.and.flightbooking.Repository.MainRepository

class MainViewModel : ViewModel() {

    private val repository = MainRepository()

    fun loadLocation(): LiveData<MutableList<LocationModel>>{
        return repository.loadLocation()
    }

    fun loadFiltered(from:String, to:String):
            LiveData<MutableList<FlightModel>> {
        return repository.loadFiltered(from,to)
    }
}