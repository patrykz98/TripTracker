package com.example.fragmentdemo.room

import android.app.Application
import androidx.lifecycle.LiveData
import kotlinx.coroutines.*

class TripRepository (application: Application){

    private var tripDao: TripDao

    init {
        val database = TripDatabase
            .getInstance(application.applicationContext)

        tripDao = database!!.tripDao()
    }

    fun insertTrip(trip: Trip):Job =
        CoroutineScope(Dispatchers.IO).launch {
            tripDao.insert(trip)
        }

    fun updateTrip(trip: Trip):Job =
        CoroutineScope(Dispatchers.IO).launch {
            tripDao.update(trip)
        }

    fun deleteTrip(trip: Trip):Job =
        CoroutineScope(Dispatchers.IO).launch {
            tripDao.delete(trip)
        }

    fun getAllTripAsync(): Deferred<LiveData<List<Trip>>> =
        CoroutineScope(Dispatchers.IO).async {
            tripDao.getAllTrips()
        }

    fun deleteAllRows() =
        CoroutineScope(Dispatchers.IO).launch {
            tripDao.delteAllRows()
        }

}