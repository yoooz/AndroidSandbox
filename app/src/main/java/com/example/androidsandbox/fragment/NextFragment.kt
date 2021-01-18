package com.example.androidsandbox.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.androidsandbox.R
import com.example.androidsandbox.databinding.FragmentNextBinding
import com.example.androidsandbox.viewmodel.InputViewModel

class NextFragment: Fragment() {
    private val inputViewModel: InputViewModel by activityViewModels()
    private var _binding: FragmentNextBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        _binding = FragmentNextBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inputViewModel.input1.observe(viewLifecycleOwner, Observer { str1 -> binding.text1.text = str1 })
        inputViewModel.input2.observe(viewLifecycleOwner, Observer { str2 -> binding.text2.text = str2 })
        inputViewModel.input3.observe(viewLifecycleOwner, Observer { str3 -> binding.text3.text = str3 })
        inputViewModel.input4.observe(viewLifecycleOwner, Observer { str4 -> binding.text4.text = str4 })

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_nextFragment_to_nextActivity)
        }
    }
}