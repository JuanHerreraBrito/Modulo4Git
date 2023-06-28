package com.darooma.modulo4.ejercicios2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import com.darooma.modulo4.R

class FrameEje2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_eje2)

        this.title = "Uso de FrameLayout"

        val btnCallLinear = findViewById<Button>(R.id.btnCallLinear)
        btnCallLinear.setOnClickListener {
            val openLinearLayout = Intent(this,LinearEje2Activity::class.java).apply {

            }
            startActivity(openLinearLayout)
        }
    }
}