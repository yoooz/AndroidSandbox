package com.example.androidsandbox.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.androidsandbox.R
import com.example.androidsandbox.databinding.FragmentInputBinding
import com.example.androidsandbox.viewmodel.InputViewModel

class InputFragment : Fragment() {
    private val inputViewModel: InputViewModel by activityViewModels()
    private var _binding: FragmentInputBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        _binding = FragmentInputBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inputViewModel.input1.observe(viewLifecycleOwner, Observer { str1 -> binding.text1.text = str1 })
        inputViewModel.input2.observe(viewLifecycleOwner, Observer { str2 -> binding.text2.text = str2 })
        inputViewModel.input3.observe(viewLifecycleOwner, Observer { str3 -> binding.text3.text = str3 })
        inputViewModel.input4.observe(viewLifecycleOwner, Observer { str4 -> binding.text4.text = str4 })

        binding.button1.setOnClickListener {
            Toast.makeText(activity, binding.input1.text.toString(), Toast.LENGTH_SHORT).show()
        }
        binding.button2.setOnClickListener {
            Toast.makeText(activity, binding.input2.text.toString(), Toast.LENGTH_SHORT).show()
        }
        binding.button3.setOnClickListener {
            Toast.makeText(activity, binding.input3.text.toString(), Toast.LENGTH_SHORT).show()
        }
        binding.button4.setOnClickListener {
            Toast.makeText(activity, binding.input4.text.toString(), Toast.LENGTH_SHORT).show()
        }
        binding.button5.setOnClickListener {
            findNavController().navigate(R.id.action_inputFragment_to_nextFragment)
        }

        binding.input1.addTextChangedListener {
            inputViewModel.input1.value = it?.toString() ?: ""
        }
        binding.input2.addTextChangedListener {
            inputViewModel.input2.value = it?.toString() ?: ""
        }
        binding.input3.addTextChangedListener {
            inputViewModel.input3.value = it?.toString() ?: ""
        }
        binding.input4.addTextChangedListener {
            inputViewModel.input4.value = it?.toString() ?: ""
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}