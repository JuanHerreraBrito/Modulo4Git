package com.darooma.modulo4.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.darooma.modulo4.R
import com.darooma.modulo4.databinding.FragmentFirstBinding

class FragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
    }
}