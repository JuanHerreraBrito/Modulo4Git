package com.darooma.modulo4.PracticaFinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.darooma.modulo4.R
import com.darooma.modulo4.databinding.ActivityHome2Binding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHome2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home2)
        binding = ActivityHome2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getStringExtra("EXTRA_USER")
        val name = intent.getStringExtra("EXTRA_NAME")
        val lastname = intent.getStringExtra("EXTRA_LASTNAME")
        val mail = intent.getStringExtra("EXTRA_MAIL")
        val sex = intent.getStringExtra("EXTRA_SEX")
        val pass = intent.getStringExtra("EXTRA_PASS")

        Toast.makeText(this, " $user, \n $name , $lastname \n $mail \n $sex \n $pass"
            , Toast.LENGTH_LONG).show()

        if (name.isNullOrBlank()) {
            binding.tvHome.text = "Usuario: $user, \n" +
                    "contraseña: $pass"
        }else {
            binding.tvHome.text = " Usuario: $user, \n" +
                    "Nombre: $name , $lastname \n" +
                    "Correo: $mail \n" +
                    "Sexo: $sex \n" +
                    "contraseña: $pass"
        }



    }
}