package com.example.livedatasample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InputViewModel: ViewModel() {
    var input1 = object : MutableLiveData<String>() {}
    var input2 = object : MutableLiveData<String>() {}
    var input3 = object : MutableLiveData<String>() {}
    var input4 = object : MutableLiveData<String>() {}
}