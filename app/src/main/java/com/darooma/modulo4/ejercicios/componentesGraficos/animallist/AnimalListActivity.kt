package com.darooma.modulo4.ejercicios.componentesGraficos.animallist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.darooma.modulo4.R

class AnimalListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_list)
        val list = findViewById<RecyclerView>(R.id.rvAnimales)

        val animalList = listOf(Animal("Leon", "Blanco", "https://pbs.twimg.com/profile_images/3449373369/5f48d88dcb71b52324fa30d832021bb2_400x400.jpeg"),
                                Animal("Jirafa", "Amarillo", "https://pbs.twimg.com/profile_images/3449373369/5f48d88dcb71b52324fa30d832021bb2_400x400.jpeg"),
                                Animal("Cocodrilo", "Verde", "https://pbs.twimg.com/profile_images/3449373369/5f48d88dcb71b52324fa30d832021bb2_400x400.jpeg"),
                                Animal("Murcielago", "Negro", "https://pbs.twimg.com/profile_images/3449373369/5f48d88dcb71b52324fa30d832021bb2_400x400.jpeg"),
                                Animal("Perico", "Verde", "https://pbs.twimg.com/profile_images/3449373369/5f48d88dcb71b52324fa30d832021bb2_400x400.jpeg"),
                                Animal("Camello", "Beige", "https://pbs.twimg.com/profile_images/3449373369/5f48d88dcb71b52324fa30d832021bb2_400x400.jpeg"),
                                Animal("Rana", "Rosa", "https://pbs.twimg.com/profile_images/3449373369/5f48d88dcb71b52324fa30d832021bb2_400x400.jpeg"))
        val adapter = AnimalAdapter(animalList)
        //it o renombrarlo como animal
        adapter.onItemSelected = { animal ->
            Toast.makeText(this, "${animal.name + " "+ animal.color}", Toast.LENGTH_SHORT).show()
        }
        list.adapter = adapter
        //Se manda como desplegarlo en un linearLaout
        //list.layoutManager = GridLayoutManager(this, 2)

        list.layoutManager = LinearLayoutManager(this)
        //list.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

    }
}