package com.darooma.modulo4.PracticaFinal

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import com.darooma.modulo4.R
import com.darooma.modulo4.databinding.ActivityHome2Binding
import com.darooma.modulo4.databinding.FragmentLoginBinding
import com.darooma.modulo4.tareaRegistro.Registro2Activity
import com.darooma.modulo4.utils.GeneralTools

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding : FragmentLoginBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        binding.tvToRegister.setOnClickListener {
            //Se maneja padre para cambiar de fragnen
            parentFragmentManager.beginTransaction()
                                    .addToBackStack("RegisterFragment")
                                    .replace(R.id.fragmentContainerLoginRegister, RegisterFragment.newInstance())
                                    .commit()
        }
        binding.btnLogin.setOnClickListener {
            //Check for correct values //update: check for correct login
            if (binding.etUsuario.text.isBlank() || binding.etPassword.text.isBlank()) {
                GeneralTools.sendAlert("Alerta", "Favor de llenar todos los campos", requireContext())
            }else{
                val homeIntent = Intent(requireContext(), HomeActivity::class.java).apply {
                    putExtra("EXTRA_USER", binding.etUsuario.text.toString())
                    putExtra("EXTRA_PASS", binding.etPassword.text.toString())
                }
                startActivity(homeIntent)
            }
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }

    /*private fun sendAlert(titulo: String, mensaje :String){
        val dialog = AlertDialog.Builder(requireContext())
            .setTitle(titulo)
            .setMessage(mensaje)
            *//*.setNegativeButton("Cancelar") { view, _ ->
                view.dismiss()
//                Poner accion al dar click en boton cancelar
            }*//*
            .setPositiveButton("Entendido") { view, _ ->
                view.dismiss()
//                Poner accion al dar click en boton Eliminar
            }
            .setCancelable(false)
            .create()
        dialog.show()
    }*/


}