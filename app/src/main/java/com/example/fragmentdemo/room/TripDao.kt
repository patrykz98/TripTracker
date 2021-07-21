package com.example.fragmentdemo.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TripDao {

    @Insert
    fun insert(trip: Trip)

    @Update
    fun update(trip: Trip)

    @Delete
    fun delete(trip: Trip)

    @Query("SELECT * FROM trip_table")
    fun getAllTrips(): LiveData<List<Trip>>

    @Query("DELETE FROM trip_table")
    fun delteAllRows()


}