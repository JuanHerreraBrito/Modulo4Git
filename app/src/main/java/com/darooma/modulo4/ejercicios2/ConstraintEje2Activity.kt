package com.darooma.modulo4.ejercicios2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.darooma.modulo4.R

class ConstraintEje2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_eje2)

        this.title = "Uso de ConstraintLayout"

        val checkBox = findViewById<CheckBox>(R.id.cbTieneMascota)
        val spinnerAnimals = findViewById<Spinner>(R.id.spMascotas)
        val btnIrAReciclerView = findViewById<Button>(R.id.btnAReciclerView)

        checkBox.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, "isCkeched = $isChecked", Toast.LENGTH_SHORT).show()
            if (isChecked){
                spinnerAnimals.visibility = View.VISIBLE
            }else{
                spinnerAnimals.visibility = View.GONE
            }
        }

        val datosMascotas = arrayListOf("Perro", "Gato", "Tortuga", "Pajarito", "Hamster", "Conejo", "Pollo", "Pavo", "Ganso", "Puerquito", "Tigre")
        val adapterMascotas =  ArrayAdapter(this, android.R.layout.simple_spinner_item, datosMascotas)

        adapterMascotas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerAnimals.adapter = adapterMascotas

        spinnerAnimals.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val itemSelected = datosMascotas[position]
                Toast.makeText(this@ConstraintEje2Activity, "Tu mascota es un  $itemSelected", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(this@ConstraintEje2Activity, "Nada seleccionado", Toast.LENGTH_SHORT).show()
            }

        }

        btnIrAReciclerView.setOnClickListener {
            val intentRecicler = Intent(this, ReciclerEje2Activity::class.java).apply {
            }
            startActivity(intentRecicler)
        }
    }
}