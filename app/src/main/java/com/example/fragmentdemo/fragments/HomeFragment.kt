package com.example.fragmentdemo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentdemo.DataObject
import com.example.fragmentdemo.MainActivity
import com.example.fragmentdemo.R
import com.example.fragmentdemo.adapter.RecyclerViewAdapter
import com.example.fragmentdemo.databinding.FragmentHomeBinding
import com.example.fragmentdemo.room.Trip
import com.example.fragmentdemo.viewmodel.TripViewModel
import androidx.fragment.app.viewModels

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: TripViewModel by viewModels()
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var listOfTrip: LiveData<List<Trip>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val recyclerHorizontalView = view.findViewById<RecyclerView>(R.id.horizontal_rv_home)

//        val listOfTrip: MutableList<DataObject> = ArrayList()
//        for (i in 1..10)
//            listOfTrip.add(DataObject("Trip $i"))

        val layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.horizontal_rv_home)

        recyclerHorizontalView.layoutManager = layoutManager
        recyclerHorizontalView.setHasFixedSize(true)
//        recyclerHorizontalView.adapter = adapter

        listOfTrip = viewModel.getAllTrip()
        listOfTrip.observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty()){
                recyclerViewAdapter = RecyclerViewAdapter(it)
                recyclerView.adapter = recyclerViewAdapter
            }
        })

       // val adapter = RecyclerViewAdapter(listOfTrip)

//        binding.horizontalRvHome.layoutManager = layoutManager
//        binding.horizontalRvHome.setHasFixedSize(true)
//        binding.horizontalRvHome.adapter = adapter


        return view
    }


}

