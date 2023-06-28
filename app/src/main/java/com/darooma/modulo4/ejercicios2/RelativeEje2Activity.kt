package com.darooma.modulo4.ejercicios2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioGroup
import android.widget.Toast
import com.darooma.modulo4.R

class RelativeEje2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative_eje2)

        this.title = "Uso de RelativeLayout"

        val animalFavorito = findViewById<Button>(R.id.btnSend)
        val perroOGato = findViewById<RadioGroup>(R.id.rgPerroOGato)
        val sendPerro = findViewById<ImageButton>(R.id.ibPerro)
        val sendGato = findViewById<ImageButton>(R.id.ibGato)

        animalFavorito.setOnClickListener {
            val texto = findViewById<EditText>(R.id.etFavorito)
            Toast.makeText(this, "El ${texto.text} es un gran animal!", Toast.LENGTH_SHORT).show()
        }

        perroOGato.setOnCheckedChangeListener { _, checkedId ->
            when(checkedId){
                R.id.rbPerro -> {
                    sendPerro.visibility = View.VISIBLE
                    sendGato.visibility = View.GONE

                }
                R.id.rbGato -> {
                    sendGato.visibility = View.VISIBLE
                    sendPerro.visibility = View.GONE
                }
                else -> "Desconocido"
            }
            //Toast.makeText(this, "Se eligió el = $cualEscogio", Toast.LENGTH_SHORT).show()
        }

        sendPerro.setOnClickListener {
            val intentPerroOGato = Intent(this, ConstraintEje2Activity::class.java).apply {

            }
            startActivity(intentPerroOGato)
        }

        sendGato.setOnClickListener {
            val intentPerroOGato = Intent(this, ConstraintEje2Activity::class.java).apply {

            }
            startActivity(intentPerroOGato)
        }

    }
}