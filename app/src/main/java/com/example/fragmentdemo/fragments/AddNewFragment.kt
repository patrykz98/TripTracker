package com.example.fragmentdemo.fragments

import com.example.fragmentdemo.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.fragmentdemo.room.Trip
import com.example.fragmentdemo.viewmodel.TripViewModel


class AddNewFragment : Fragment() {

    private val viewModel: TripViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_add_new, container, false)
        val addButton = view.findViewById<FrameLayout>(R.id.add_Button)
        val cancelButton = view.findViewById<FrameLayout>(R.id.cancel_Button)
        val destination = view.findViewById<EditText>(R.id.destinationET)
        val kilometers = view.findViewById<EditText>(R.id.kilometersET)

        addButton.setOnClickListener{
            val destination = destination.text.toString()
            val kilometers = kilometers.text.toString()

            val trip = Trip(kilometers, destination, members = "Kawasaki", description = "Nic takiego")
            viewModel.insertTrip(trip)

            Toast.makeText(context, "New trip note added!", Toast.LENGTH_SHORT).show()
        }

        return view
    }


}