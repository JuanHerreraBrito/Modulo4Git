package com.darooma.modulo4.ejercicios.componentesGraficos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import com.darooma.modulo4.R

class SelectionComponentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection_component)

        val cbCreditCard = findViewById<CheckBox>(R.id.cbCreditCard)
        val btnsend = findViewById<Button>(R.id.btnSend)
        val rgSex = findViewById<RadioGroup>(R.id.rgSex)

        //CHECKBOX
        //se llama cuando chambia el check, regresa el view y el booleano
        //si no se ocupa se puede poner un guion bajo (aqui se quito paremetro view)
        cbCreditCard.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, "isCkeched = $isChecked", Toast.LENGTH_SHORT).show()
        }

        //RADIOGROUP
        //Los ids se asignan como enteros, para identificar se usa un when como sigue...
        //Se podra obtener su valor ?
        rgSex.setOnCheckedChangeListener { _, checkedId ->
            val idName = when(checkedId){
                R.id.rbMan -> {
                    cbCreditCard.visibility = View.GONE

                }
                R.id.rbWoman -> cbCreditCard.visibility = View.VISIBLE
                else -> "Desconocido"
            }
            Toast.makeText(this, "Checked Id = $idName", Toast.LENGTH_SHORT).show()
        }

        //SPINNER
        val spinner = findViewById<Spinner>(R.id.spinner)
        val datos = arrayListOf("Puerto rico", "España", "México", "Dinamarca", "Estados Unidos", "Venezuela", "Colombia", "Puerto rico", "España", "México", "Dinamarca", "Estados Unidos", "Venezuela", "Colombia")
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, datos)

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adaptador

        //se le pasa interfaz
        spinner.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //se saca posicion de los datos
                val intemSelected = datos[position]
                Toast.makeText(this@SelectionComponentActivity, "Item seleccionado $intemSelected", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                //el contexto es el activity
                Toast.makeText(this@SelectionComponentActivity, "Nada seleccionado", Toast.LENGTH_SHORT).show()
            }

        }


        btnsend.setOnClickListener {
            //CheckBox
            val cbStatus  = cbCreditCard.isChecked
            Toast.makeText(this, "isCkeched = $cbStatus", Toast.LENGTH_SHORT).show()

            //RadioButtons
            val selectedRbSex = when(rgSex.checkedRadioButtonId){
                R.id.rbMan -> "H"
                R.id.rbWoman -> "M"
                else -> "Desconocido"
            }
            Toast.makeText(this, "isCkeched = $selectedRbSex", Toast.LENGTH_SHORT).show()
        }
    }
}