package com.example.fragmentdemo.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trip_table")
data class Trip(var kilometers: Int,
                var destination: String,
                var members: String,
                var description: String){

    @PrimaryKey(autoGenerate = true)
    var trip_id: Int = 0

}
