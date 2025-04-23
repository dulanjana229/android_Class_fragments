package com.example.testfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.testfragments.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val mainViewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFirstBinding.inflate(layoutInflater,container,false)

        mainViewModel.userData.observe(viewLifecycleOwner, Observer {
            binding.editTextName.setText(it.name.toString())
            binding.editTextAge.setText(it.age.toString())
            binding.editTextEmail.setText(it.email.toString())
        })

        val user = User("Dulanjana", 22, "Colombo", "dulanjana@gmail.com")
        mainViewModel.setDate(user)

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