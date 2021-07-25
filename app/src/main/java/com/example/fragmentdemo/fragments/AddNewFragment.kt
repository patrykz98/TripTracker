package com.example.fragmentdemo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.FrameLayout
import androidx.fragment.app.viewModels
import com.example.fragmentdemo.R
import com.example.fragmentdemo.databinding.FragmentAddNewBinding
import com.example.fragmentdemo.room.Trip
import com.example.fragmentdemo.viewmodel.TripViewModel

class AddNewFragment : Fragment() {

    private val viewModel: TripViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        viewModel = ViewModelProvider(this).get(TripViewModel::class.java)

        val view = inflater.inflate(R.layout.fragment_add_new, container, false)
        val addButton = view.findViewById<FrameLayout>(R.id.add_Button)
        val destination = view.findViewById<EditText>(R.id.destinationET)
        val kilometers = view.findViewById<EditText>(R.id.kilometersET)

        addButton.setOnClickListener{
            val destination = destination.text.toString()
            val kilometers = kilometers.text.toString()

            val trip = Trip(kilometers, destination, members = "Kawasaki", description = "Nic takiego")
            viewModel.insertTrip(trip)
        }

        // Inflate the layout for this fragment
        return view
    }


}