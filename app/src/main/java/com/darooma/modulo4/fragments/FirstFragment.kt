package com.darooma.modulo4.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.darooma.modulo4.R
import com.darooma.modulo4.databinding.FragmentFirstBinding


class FirstFragment : Fragment(R.layout.fragment_first) {

    private lateinit var binding : FragmentFirstBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //como es un fragment se inicializa con un bind por que los activitys si tienes inflaters
        binding =  FragmentFirstBinding.bind(view)
        binding.tvTitle.text = "Prueba cambiada"
        binding.btNextFragment.setOnClickListener {
            //si ya hay un fragment se pone replace
            //se agrega commit
            parentFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, SecondFragment.newInstance())
                .addToBackStack("SecondFragment")
                .commit()
        }
    }

    companion object {
        //para isntancia por codigo
        @JvmStatic
        fun newInstance() = FirstFragment()
    }
}