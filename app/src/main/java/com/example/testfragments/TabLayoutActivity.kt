package com.example.testfragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.testfragments.bottom_bar.FriendsFragment
import com.example.testfragments.bottom_bar.HomeFragment
import com.example.testfragments.bottom_bar.SettingsFragment
import com.example.testfragments.databinding.ActivityTabLayoutBinding
import com.google.android.material.tabs.TabLayoutMediator

class TabLayoutActivity : AppCompatActivity() {

    private lateinit var binding:ActivityTabLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTabLayoutBinding.inflate(layoutInflater)


        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val fragmentList = listOf(
            HomeFragment(),
            FriendsFragment(),
            SettingsFragment()
        )

        val fragmentAdapter = FragmentAdapter(fragmentList, supportFragmentManager, lifecycle)

        binding.pager.adapter = fragmentAdapter

        TabLayoutMediator(binding.tabLayout,binding.pager){tab,position->
            tab.text = when(position){
                0->"Home"
                1->"Friends"
                2->"Settings"
                else->""
            }
        }.attach()

    }
}