package com.example.testfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.testfragments.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFirstBinding.inflate(layoutInflater,container,false)

        binding.btnSecond.setOnClickListener{

            val name = binding.editTextName.text.toString()
            val age = binding.editTextAge.text.toString()
            val email = binding.editTextEmail.text.toString()

            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(name,age,email)
            findNavController().navigate(action)
        }

        binding.btnThird.setOnClickListener{
            findNavController().navigate(R.id.action_firstFragment_to_thirdFragment)
        }

        return binding.root
    }

}