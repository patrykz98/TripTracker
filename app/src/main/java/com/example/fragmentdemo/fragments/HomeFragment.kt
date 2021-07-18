package com.example.fragmentdemo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragmentdemo.DataObject
import com.example.fragmentdemo.R
import com.example.fragmentdemo.databinding.ActivityMainBinding
import com.example.fragmentdemo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val data: MutableList<DataObject> = ArrayList()
        for (i in 1..10)
            data.add(DataObject("Test $i"))

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        //binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.horizontalRvHome.layoutManager = LinearLayoutManager(context)
        binding.horizontalRvHome.adapter

        return inflater.inflate(R.layout.fragment_home, container, false)
    }




}