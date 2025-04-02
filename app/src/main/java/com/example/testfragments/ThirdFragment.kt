package com.example.testfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.testfragments.databinding.FragmentThirdBinding


class ThirdFragment : Fragment() {


    private lateinit var binding: FragmentThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentThirdBinding.inflate(layoutInflater, container, false)
        binding.btnBackThird.setOnClickListener{
            findNavController().navigateUp()
        }

        return binding.root
    }


}