package com.darooma.modulo4.ejercicios2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.darooma.modulo4.R

class LinearEje2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear_eje2)

        this.title = "Uso de LinearLayout"

        val btnCallRelative = findViewById<Button>(R.id.btnCallRelative)
        btnCallRelative.setOnClickListener {
            val openRelativeLayout = Intent(this, RelativeEje2Activity::class.java).apply {

            }
            startActivity(openRelativeLayout)
        }
    }
}