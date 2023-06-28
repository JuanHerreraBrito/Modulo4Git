package com.darooma.modulo4.ejercicios2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.darooma.modulo4.R
import com.darooma.modulo4.ejercicios.componentesGraficos.Person
import com.darooma.modulo4.ejercicios.componentesGraficos.PersonAdapter

class ReciclerEje2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recicler_eje2)

        this.setTitle("Ejemplo Recicler View")

        //Se llama la vista del recicler
        val reciclerAnimal = findViewById<RecyclerView>(R.id.animalsList)

        //Se prepara adaptador para los animales
        val animalAdapter = AnimalAdapter(arrayListOf(
            Animal("1", "Pollo"),
            Animal("2", "Burro"),
            Animal("3", "Caballo"),
            Animal("4", "Gato"),
            Animal("5", "Tortuga"),
            Animal("6", "Perico"),
            Animal("7", "Tigre"),
            Animal("8", "Leon"),
            Animal("9", "Conejo")

        ))

        //Se agrega adaptador a vista
        reciclerAnimal.adapter = animalAdapter
        reciclerAnimal.layoutManager = LinearLayoutManager(this)

    }
}