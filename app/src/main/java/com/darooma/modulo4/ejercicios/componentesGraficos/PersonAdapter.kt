package com.darooma.modulo4.ejercicios.componentesGraficos

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.darooma.modulo4.R

//Adaptador ayuda a convertir
//adapatador de lista, que hereda de recyclerViewAdapter, se agrega nombre de view holder
//Se hereda de aqui por que estas ya contienen definidas la funcionalidades
class PersonAdapter(private var list:List<Person>) : RecyclerView.Adapter<PersonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        //se le pasa contexto de su view, es decir el diseño item_person
        return PersonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false))
    }

    //para saber cuantos elementos mostrara el componenete
    override fun getItemCount(): Int = list.size

    //por cada vista tiene que mostrar algo
    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.render(list[position])
    }
}

//el hoder es el encargado de unir datos con visual. Le llega diseño y elemento a mostrar, se encarga de como mostrar
class PersonViewHolder(view: View) : RecyclerView.ViewHolder(view){
    val tvName = view.findViewById<TextView>(R.id.tvName)
    fun render(person: Person) {
        tvName.text =  person.name
    }

}
