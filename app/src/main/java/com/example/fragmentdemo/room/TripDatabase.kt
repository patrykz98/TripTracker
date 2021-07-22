package com.example.fragmentdemo.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room
import android.content.Context


@Database(entities = [Trip::class], version = 1, exportSchema = false)
abstract class TripDatabase: RoomDatabase() {

    abstract fun tripDao(): TripDao

    companion object{
        private var instance: TripDatabase? = null

        fun getInstance(context: Context): TripDatabase?{
            if(instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    TripDatabase::class.java,
                    "trip_table")
                    .fallbackToDestructiveMigration()
                    .build()
                }
                return instance
            }

        fun deleteInstanceOfDatabase(){
            instance = null
        }

        }

}

