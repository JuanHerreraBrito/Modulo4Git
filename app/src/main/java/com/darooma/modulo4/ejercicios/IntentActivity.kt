package com.darooma.modulo4.ejercicios

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.darooma.modulo4.R

class IntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        val btSend = findViewById<Button>(R.id.btsend)
        val btUrl = findViewById<Button>(R.id.btUrl)

        btSend.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto")
                putExtra(Intent.EXTRA_SUBJECT, "aviso urgente")
                putExtra(Intent.EXTRA_TEXT, "Esto es una prueba para enviar correo medinte intent implicito")
            }
            startActivity(Intent.createChooser(emailIntent, "Enviar email usando:"))
        }

        btUrl.setOnClickListener {
            val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"))
            startActivity(urlIntent)
        }
    }
}