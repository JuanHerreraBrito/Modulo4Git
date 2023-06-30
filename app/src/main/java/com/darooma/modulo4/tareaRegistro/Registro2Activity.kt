package com.darooma.modulo4.tareaRegistro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.darooma.modulo4.R

class Registro2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro2)
        this.setTitle("Tarea Ejercicio")

        val name = intent.getStringExtra("EXTRA_NAME")
        val lastName = intent.getStringExtra("EXTRA_LASTNAME")
        val mail = intent.getStringExtra("EXTRA_MAIL")
        val sex = intent.getStringExtra("EXTRA_SEX")
        val pass = intent.getStringExtra("EXTRA_PASS")
//Toast.makeText(this, "$name, $lastName, $mail,$sex, $pass ", Toast.LENGTH_SHORT).show()
        val nameTV = findViewById<TextView>(R.id.tvNombreDato)
        val mailTV = findViewById<TextView>(R.id.tvCorreoDato)
        val sexTV = findViewById<TextView>(R.id.tvSexoDato)
        val passTV = findViewById<TextView>(R.id.tvPasswordDato)

        nameTV.text = "$name $lastName"
        mailTV.text = mail
        sexTV.text = sex
        passTV.text = pass

    }
}