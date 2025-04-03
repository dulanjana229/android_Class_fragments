package com.example.testfragments.bottom_bar

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavHostController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.testfragments.R
import com.example.testfragments.databinding.ActivityBottomBarBinding

class BottomBarActivity : AppCompatActivity() {

    private lateinit var binding:ActivityBottomBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBottomBarBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val host = supportFragmentManager.findFragmentById(R.id.bottomFragmentContainerView) as NavHostFragment
        val navController = host.navController

        binding.bottomAppBar.setupWithNavController(navController)
    }
}