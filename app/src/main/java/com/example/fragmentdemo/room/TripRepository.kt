package com.example.fragmentdemo.room

import android.app.Application

class TripRepository (application: Application){

    private var tripDao: TripDao

    init {
        val database = TripDatabase
            .getInstance(application.applicationContext)

        tripDao = database!!.tripDao()
    }

}