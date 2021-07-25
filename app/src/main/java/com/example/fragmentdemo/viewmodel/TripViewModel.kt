package com.example.fragmentdemo.viewmodel

import android.app.Application
import android.app.Person
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.fragmentdemo.room.Trip
import com.example.fragmentdemo.room.TripRepository
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.runBlocking

class TripViewModel(application: Application):
    AndroidViewModel(application){

        private var tripRepository: TripRepository = TripRepository(application)
        private var allTrip: Deferred<LiveData<List<Trip>>> = tripRepository.getAllTripAsync()

        fun insertTrip(trip: Trip){
            tripRepository.insertTrip(trip)
        }

        fun updateTrip(trip: Trip){
            tripRepository.updateTrip(trip)
        }

        fun deleteTrip(trip: Trip){
            tripRepository.deleteTrip(trip)
        }

        fun getAllTrip(): LiveData<List<Trip>> = runBlocking {
            allTrip.await()
        }

        fun deleteAllRows(){
            tripRepository.deleteAllRows()
        }
}