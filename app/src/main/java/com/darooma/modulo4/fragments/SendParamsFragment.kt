package com.darooma.modulo4.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.darooma.modulo4.R
import com.darooma.modulo4.databinding.FragmentSendParamsBinding
import com.darooma.modulo4.ejercicios.componentesGraficos.animallist.Animal

class SendParamsFragment : Fragment(R.layout.fragment_send_params){

    private lateinit var binding : FragmentSendParamsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSendParamsBinding.bind(view)
        binding.btnSend.setOnClickListener {
        parentFragmentManager.beginTransaction()
            .addToBackStack("ReceiveFragment")
            .replace(R.id.fragmentContainerView,
                ReceiveParamsFragment.newInstance(
                    "Juan Herrera",
                    Animal("Lobo", "Blanco", "urlfalsa")
                )
            )
            .commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SendParamsFragment()
    }
}