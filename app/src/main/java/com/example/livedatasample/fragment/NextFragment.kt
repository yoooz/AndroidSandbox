package com.example.livedatasample.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.livedatasample.R
import com.example.livedatasample.viewmodel.InputViewModel
import kotlinx.android.synthetic.main.fragment_next.*

class NextFragment: Fragment() {
    private val inputViewModel: InputViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        return inflater.inflate(R.layout.fragment_next, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inputViewModel.input1.observe(viewLifecycleOwner, Observer { str1 -> text1.text = str1 })
        inputViewModel.input2.observe(viewLifecycleOwner, Observer { str2 -> text2.text = str2 })
        inputViewModel.input3.observe(viewLifecycleOwner, Observer { str3 -> text3.text = str3 })
        inputViewModel.input4.observe(viewLifecycleOwner, Observer { str4 -> text4.text = str4 })
    }
}