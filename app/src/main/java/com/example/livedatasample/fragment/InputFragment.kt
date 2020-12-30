package com.example.livedatasample.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.livedatasample.R
import com.example.livedatasample.viewmodel.InputViewModel
import kotlinx.android.synthetic.main.fragment_input.*

class InputFragment : Fragment() {
    private val inputViewModel: InputViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        return inflater.inflate(R.layout.fragment_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inputViewModel.input1.observe(viewLifecycleOwner, Observer { str1 -> text1.text = str1 })
        inputViewModel.input2.observe(viewLifecycleOwner, Observer { str2 -> text2.text = str2 })
        inputViewModel.input3.observe(viewLifecycleOwner, Observer { str3 -> text3.text = str3 })
        inputViewModel.input4.observe(viewLifecycleOwner, Observer { str4 -> text4.text = str4 })

        button1.setOnClickListener {
            Toast.makeText(activity, input1.text.toString(), Toast.LENGTH_SHORT).show()
        }
        button2.setOnClickListener {
            Toast.makeText(activity, input2.text.toString(), Toast.LENGTH_SHORT).show()
        }
        button3.setOnClickListener {
            Toast.makeText(activity, input3.text.toString(), Toast.LENGTH_SHORT).show()
        }
        button4.setOnClickListener {
            Toast.makeText(activity, input4.text.toString(), Toast.LENGTH_SHORT).show()
        }
        button5.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainer, NextFragment())
                ?.addToBackStack(null)?.commit()
        }

        input1.addTextChangedListener {
            inputViewModel.input1.value = it?.toString() ?: ""
        }
        input2.addTextChangedListener {
            inputViewModel.input2.value = it?.toString() ?: ""
        }
        input3.addTextChangedListener {
            inputViewModel.input3.value = it?.toString() ?: ""
        }
        input4.addTextChangedListener {
            inputViewModel.input4.value = it?.toString() ?: ""
        }
    }

}