package com.example.fragmentdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fragmentdemo.databinding.ActivityMainBinding
import com.example.fragmentdemo.fragments.AddNewFragment
import com.example.fragmentdemo.fragments.HomeFragment
import com.example.fragmentdemo.fragments.PlansFragment
import com.example.fragmentdemo.fragments.SuggestionFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val homeFragment = HomeFragment()
    private val addNewFragment = AddNewFragment()
    private val suggestionFragment = SuggestionFragment()
    private val plansFragment = PlansFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(homeFragment)


        binding.bottomMenu.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.itemHome -> replaceFragment(homeFragment)
                R.id.itemAddNew -> replaceFragment(addNewFragment)
                R.id.itemSmthNew -> replaceFragment(suggestionFragment)
                R.id.itemTripPlan -> replaceFragment(plansFragment)
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment){
        if(fragment !=null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer, fragment)
            transaction.commit()

            binding.bottomMenu.setBackgroundColor(resources.getColor(R.color.purple_200))
        }
    }

}