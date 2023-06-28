package com.darooma.modulo4.ejercicios.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.darooma.modulo4.R

class CicloVidaToastActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this, "Metodo OnCreate", Toast.LENGTH_SHORT).show()
        Log.e("CICLO DE VIDA", "OnCreate")
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "Metodo OnStart", Toast.LENGTH_SHORT).show()
        Log.e("CICLO DE VIDA", "OnStart")
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "Metodo OnResume", Toast.LENGTH_SHORT).show()
        Log.e("CICLO DE VIDA", "OnResume")
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "Metodo OnPause", Toast.LENGTH_SHORT).show()
        Log.e("CICLO DE VIDA", "OnPause")
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "Metodo OnStop", Toast.LENGTH_SHORT).show()
        Log.e("CICLO DE VIDA", "OnStop")
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "Metodo OnRestart", Toast.LENGTH_SHORT).show()
        Log.e("CICLO DE VIDA", "OnRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Metodo OnDestroy", Toast.LENGTH_SHORT).show()
        Log.e("CICLO DE VIDA", "OnDestroy")
    }
}