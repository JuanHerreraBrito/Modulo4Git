package com.darooma.modulo4.ejercicios.componentesGraficos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import com.darooma.modulo4.R
import com.darooma.modulo4.databinding.ActivityLinearBinding
import com.darooma.modulo4.databinding.ActivitySelectionComponentBinding

class SelectionComponentActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySelectionComponentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //nuestro activity tiene el infrater
        // Inflar convierte en  una view que se puede usar
        //cuando se declara que se usaran binding, se crean por ejemplo
        //ActivitySelectionComponentBinding que llama a el layout
        binding = ActivitySelectionComponentBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //setContentView(R.layout.activity_selection_component) //uso anterior

        //primero de habilita binding en manifest
       // ActivityLinearBinding

        /*
        //Uso anterior
        val cbCreditCard = findViewById<CheckBox>(R.id.cbCreditCard)
        val btnsend = findViewById<Button>(R.id.btnSend)
        val rgSex = findViewById<RadioGroup>(R.id.rgSex)*/

        //CHECKBOX
        //se llama cuando chambia el check, regresa el view y el booleano
        //si no se ocupa se puede poner un guion bajo (aqui se quito paremetro view)
        binding.cbCreditCard.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, "isCkeched = $isChecked", Toast.LENGTH_SHORT).show()
        }

        //RADIOGROUP
        //Los ids se asignan como enteros, para identificar se usa un when como sigue...
        //Se podra obtener su valor ?
        binding.rgSex.setOnCheckedChangeListener { _, checkedId ->
            val idName = when(checkedId){
                R.id.rbMan -> {
                    binding.cbCreditCard.visibility = View.GONE

                }
                R.id.rbWoman -> binding.cbCreditCard.visibility = View.VISIBLE
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


        binding.btnSend.setOnClickListener {
            //CheckBox
            val cbStatus  = binding.cbCreditCard.isChecked
            Toast.makeText(this, "isCkeched = $cbStatus", Toast.LENGTH_SHORT).show()

            //RadioButtons
            val selectedRbSex = when(binding.rgSex.checkedRadioButtonId){
                R.id.rbMan -> "H"
                R.id.rbWoman -> "M"
                else -> "Desconocido"
            }
            Toast.makeText(this, "isCkeched = $selectedRbSex", Toast.LENGTH_SHORT).show()
        }
    }
}