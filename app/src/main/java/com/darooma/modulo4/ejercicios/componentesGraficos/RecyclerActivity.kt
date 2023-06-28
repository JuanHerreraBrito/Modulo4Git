package com.darooma.modulo4.ejercicios.componentesGraficos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.darooma.modulo4.R

class RecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        val rvPerson = findViewById<RecyclerView>(R.id.personList)
        val personAdapter = PersonAdapter(arrayListOf(
            Person("1", "Juan"),
            Person("2", "Pedro"),
            Person("3", "Bruno"),
            Person("4", "Maria"),
            Person("5", "Camilo"),
            Person("6", "Axel"),
            Person("7", "Panfilo"),
            Person("8", "Camilo"),
            Person("9", "Axel")

        ))

        rvPerson.adapter = personAdapter
        rvPerson.layoutManager = LinearLayoutManager(this)
    }
}