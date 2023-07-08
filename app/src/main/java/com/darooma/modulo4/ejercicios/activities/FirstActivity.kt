package com.darooma.modulo4.ejercicios.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.darooma.modulo4.R
import com.darooma.modulo4.ejercicios.componentesGraficos.animallist.Animal
import java.util.*

class ArrayOf<T>(t: T, t1: T, t2: T) {

}

class FirstActivity : AppCompatActivity() {

    //Metodo que ayuda para recibir información
    private val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        //se pueden manejar con result o con it, regularmente se agrega un nombre
        if (result.resultCode == RESULT_OK) {
            if(result.data?.getBooleanExtra("EXTRA_IS_ACTIVITY_BACK", false) == true){
                onBackPressedDispatcher.onBackPressed()
            }else{
                Toast.makeText(this, "result code es: ${result.resultCode} " +
                    " nombre = ${result.data?.getStringExtra("EXTRA_NAME")} " +
                    " apellidos = ${result.data?.getStringExtra("EXTRA_LASTNAME")} " +
                    " edad = ${result.data?.getIntExtra("EXTRA_AGE",0)}" +
                    " es soltero o soltera = ${result.data?.getBooleanExtra("EXTRA_SINGLE", true)}" +
                    " promedio = ${result.data?.getDoubleExtra("EXTRA_AVERAGE", 0.0)}" +
                    " calificaciones = " + Arrays.toString(result.data?.getIntArrayExtra("EXTRA_RATINGS")) +
                    " año de nacimiento = ${result.data?.getShortExtra("EXTRA_BIRTHDAY_YEAR",0)}" +
                    " amigos = " + Arrays.toString(result.data?.getStringArrayExtra("EXTRA_FRIENDS"))

                , Toast.LENGTH_LONG).show()
            }
        }else{
            Toast.makeText(this, "RESULTCODE = ${result.resultCode} - CANCELLED", Toast.LENGTH_SHORT).show()
        }
        //codigo de resultado
        //result.resultCode
        //los datos
        //
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val btnCall = findViewById<Button>(R.id.btCall)

        btnCall.setOnClickListener {
            val calif: IntArray = intArrayOf(10, 7, 9, 8)
            val amigos = arrayOf<String>("Pedro", "Juan", "Alex")
            val animal = Animal("Leon", "Amarillo", "https://okdiario.com/img/2019/08/10/-por-que-el-leon-es-el-rey-de-la-selva_-1-655x368.jpg")
            //se saca la clase del activity con ::
            val secondIntent = Intent(this, SecondActivity::class.java).apply {
                putExtra("EXTRA_NAME", "Juan Jose")
                putExtra("EXTRA_LASTNAME", "Herrera Brito")
                putExtra("EXTRA_AGE", 32)
                putExtra("EXTRA_SINGLE", true)
                putExtra("EXTRA_AVERAGE", 8.8)
                putExtra("EXTRA_RATINGS", calif)
                putExtra("EXTRA_BIRTHDAY_YEAR", "1991".toShort())//¿Por que no funciona solo 1991?
                putExtra("EXTRA_FRIENDS", amigos)
                putExtra("EXTRA_ANIMAL", animal)
            }
            //startActivity(secondIntent)
            //se manda con register.launch si esperamos algo
            register.launch(secondIntent)
        }
    }
}