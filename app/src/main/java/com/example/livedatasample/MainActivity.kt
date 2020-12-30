package com.example.livedatasample

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.livedatasample.fragment.MainFragment

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = MainFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragmentContainer, fragment)
        transaction.commit()
    }
}
