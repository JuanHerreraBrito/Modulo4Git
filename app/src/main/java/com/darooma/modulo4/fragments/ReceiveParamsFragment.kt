package com.darooma.modulo4.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.darooma.modulo4.R
import com.darooma.modulo4.databinding.FragmentReceiveParamsBinding
import com.darooma.modulo4.ejercicios.activities.FirstActivity
import com.darooma.modulo4.ejercicios.activities.SecondActivity
import com.darooma.modulo4.ejercicios.componentesGraficos.animallist.Animal

class ReceiveParamsFragment : Fragment(R.layout.fragment_receive_params) {

    private lateinit var  binding : FragmentReceiveParamsBinding
    private var name : String? = ""
    private var animal : Animal? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Toast.makeText(activity, "entra create", Toast.LENGTH_SHORT).show()
        //les checa que no es nulo
        arguments?.let {
            name = it.getString("ARG_NAME")
            animal = it.getSerializable("ARG_ANIMAL") as Animal
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(activity, "entra created", Toast.LENGTH_SHORT).show()
        binding = FragmentReceiveParamsBinding.bind(view)

        binding.tvName.text = name
        binding.tvAnimalName.text = animal?.name

        binding.btSendActivity.setOnClickListener {
            val intent = Intent(requireContext(), FirstActivity::class.java).apply{
                putExtra("EXTRANAME", name)
            }
            startActivity(intent, )
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(name : String, animal : Animal) =
            ReceiveParamsFragment().apply {
                //cada fragment tiene sus atributos
                arguments = Bundle().apply {
                    putString("ARG_NAME", name)
                    putSerializable("ARG_ANIMAL", animal)
                }
            }
    }
}