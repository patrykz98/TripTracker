package com.example.fragmentdemo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentdemo.DataObject
import com.example.fragmentdemo.R
import com.example.fragmentdemo.RecyclerViewAdapter
import com.example.fragmentdemo.databinding.ActivityMainBinding
import com.example.fragmentdemo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val recyclerHorizontalView = view.findViewById<RecyclerView>(R.id.horizontal_rv_home)

        val data: MutableList<DataObject> = ArrayList()
        for (i in 1..10)
            data.add(DataObject("Trip $i"))

        val layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)

        val adapter = RecyclerViewAdapter(data)

//        binding.horizontalRvHome.layoutManager = layoutManager
//        binding.horizontalRvHome.setHasFixedSize(true)
//        binding.horizontalRvHome.adapter = adapter

        recyclerHorizontalView.layoutManager = layoutManager
        recyclerHorizontalView.setHasFixedSize(true)
        recyclerHorizontalView.adapter = adapter


        return view
    }




}