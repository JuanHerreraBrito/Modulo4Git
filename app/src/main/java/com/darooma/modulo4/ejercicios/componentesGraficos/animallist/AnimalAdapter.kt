package com.darooma.modulo4.ejercicios.componentesGraficos.animallist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.recyclerview.widget.RecyclerView
import com.darooma.modulo4.R
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

//Se puede pasar contexto cuando se necesitan obtener otros parametros
//class AnimalAdapter(private val list:List<Animal>, val context : Context) : RecyclerView.Adapter<AnimalViewHolder>() {

//Recycler View es la que se encarga de como se manejan elementos, por eso se hereda
//constructor kotlin basta con poner parentesis
class AnimalAdapter(private val list:List<Animal>) : RecyclerView.Adapter<AnimalViewHolder>() {

    //Cuando variable o funcion es nula, se usa Unit (Es como un estandar para que no crashe)
    var onItemSelected : ((Animal) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        //Este necesita el diseño
        //Se puede sacar contecto de los Views
        //El metodo inflate convierte un xml a un view
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_animal2, parent, false)
        return AnimalViewHolder(view)
    }

    //Indica cuantos items crear
    override fun getItemCount(): Int = list.size

    //En este metodo le decimos que nombre se ponga en que parametro de la view inflada
    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        //render podria ser otro, pinta , bind
        holder.render(list[position], onItemSelected)
    }

}

//Cuando se crea herede, podria heredar animalViewHolder pero esta lo hereda
//este view es el diseño de cada item
class AnimalViewHolder(view: View) : RecyclerView.ViewHolder(view ){
    val root = view.findViewById<ConstraintLayout>(R.id.root)
    //EL view es la instancia del item, por eso se buscan dentro de el
    val ivAnimal = view.findViewById<ImageView>(R.id.ivAnimal)
    val tvAnimalName = view.findViewById<TextView>(R.id.tvAnimalName)

    fun render(animal: Animal, onItemSelected : ((Animal)->Unit)?) {
        tvAnimalName.text = animal.name

        root.setOnClickListener {
            onItemSelected?.invoke(animal)
        }
        //
        //Picasso.get().load("https://thumbs.dreamstime.com/z/vector-conjunto-de-animalitos-lindos-african-baby-beasts-avatar-personajes-infantiles-para-sala-elefante-mono-panda-león-niños-216065703.jpg")
        //Picasso.get().load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQV6D8fJZWgcW5SpV0ZnF8XTOmCcY1C1wCRPU9LJ-MzQFMPqiPkPw87OMcIQe7IM3WQVnw&usqp=CAU")
        Picasso.get().load(animal.url)
            .error(R.drawable.ic_launcher_foreground)
            .placeholder(R.drawable.img_android)
            .into(ivAnimal)
    }


}