package com.darooma.modulo4.ejercicios.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.darooma.modulo4.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btCall = findViewById<Button>(R.id.btnCallfisrt)
        btCall.setOnClickListener{
            val firstIntent = Intent(this, FirstActivity::class.java)
            startActivity(firstIntent)
        }
    }


}