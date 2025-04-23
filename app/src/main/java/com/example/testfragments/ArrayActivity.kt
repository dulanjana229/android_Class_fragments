package com.example.testfragments

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testfragments.databinding.ActivityArrayBinding

class ArrayActivity : AppCompatActivity() {

    private lateinit var binding:ActivityArrayBinding

    private val mainViewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityArrayBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mainViewModel.getData()

//        val items = arrayOf("ABC1", "ABC2", "ABC3", "ABC4", "ABC5", "ABC6", "ABC7")
//
//        val adapter = ArrayAdapter(this, R.layout.simple_layout, R.id.textViewItem, items)
//
//        binding.arrayList.adapter = adapter


        val customAdapter:CustomAdapter = CustomAdapter()

        binding.recycleView.layoutManager = LinearLayoutManager(this)
        binding.recycleView.adapter = customAdapter

        mainViewModel.userListData.observe(this, {
            customAdapter.setUserList(it)
        })
    }
}