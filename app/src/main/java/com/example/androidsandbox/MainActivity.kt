package com.example.androidsandbox

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.androidsandbox.fragment.MainFragment

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
