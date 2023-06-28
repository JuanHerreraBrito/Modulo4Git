package com.darooma.modulo4.ejercicios2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.darooma.modulo4.R
import com.darooma.modulo4.ejercicios.componentesGraficos.PersonViewHolder

//se determina que recibe una lista, del tipo de elementos recibidos
//hereda de recicler view adapter
class AnimalAdapter(private var list:List<Animal>) : RecyclerView.Adapter<AnimalViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        //se le pasa contexto de su view, es decir el diseño item_person
        //Se agrega item en el contexto
        return AnimalViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false))
    }

    //Se pasa la cantidad de items
    override fun getItemCount(): Int = list.size

    //Se agrega un render por cada elemento, implementado en el ViewHolder
    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.render(list[position])
    }

}

//Necesita una implementacion de View Holder y se crea "sola"
//hereda de  recicler view
class AnimalViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    //val ivAnimal = view.findViewById<ImageView>(R.id.ivAnimal)
    val tvName = view.findViewById<TextView>(R.id.tvName)

    //Se necesita agregar el render, del viewholder
    fun render(animal: Animal) {
        //ivAnimal.setImageResource((int)R.mipmap.ic_launcher)//No se pudo poner imagen
        tvName.text =  animal.name
    }

}
