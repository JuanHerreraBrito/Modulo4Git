package com.darooma.modulo4.PracticaFinal

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import com.darooma.modulo4.R
import com.darooma.modulo4.databinding.FragmentRegisterBinding
import com.darooma.modulo4.tareaRegistro.Registro2Activity
import com.darooma.modulo4.utils.GeneralTools

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var binding : FragmentRegisterBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterBinding.bind(view)
        binding.btnRegister.setOnClickListener {

                if (binding.etNombre.text.isBlank() || binding.etApellido.text.isBlank() ||
                    binding.etCorreo.text.isBlank() || binding.etPassword.text.isBlank() ||
                    binding.etUser.text.isBlank() ){
                    GeneralTools.sendAlert("Alerta", "Se deben llenar todos los campos", requireContext())
                }else if(!GeneralTools.isValidEmail(binding.etCorreo.text)){
                    GeneralTools.sendAlert("Alerta", "Insertar un correo valido", requireContext())
                }else if(binding.etUser.text.length < 5 ){
                    GeneralTools.sendAlert("Alerta", "El usuario debe tener minimo 5 carácteres", requireContext())
                }else if(binding.etPassword.text.length < 8 ){
                    GeneralTools.sendAlert("Alerta", "La contraseña debe tener al menos 8 carácteres" , requireContext())
                }else if(!binding.rbHombre.isChecked && !binding.rbMujer.isChecked){
                    GeneralTools.sendAlert("Alerta", "Favor de indicar el sexo" , requireContext())
                }else{
                    val homeIntent = Intent(requireContext(), HomeActivity::class.java).apply {
                        putExtra("EXTRA_USER", binding.etUser.text.toString())
                        putExtra("EXTRA_NAME", binding.etNombre.text.toString())
                        putExtra("EXTRA_LASTNAME", binding.etApellido.text.toString())
                        putExtra("EXTRA_MAIL", binding.etCorreo.text.toString())
                        if (binding.rbHombre.isChecked){
                            putExtra("EXTRA_SEX", "Hombre")
                        }else{
                            putExtra("EXTRA_SEX", "Mujer")
                        }
                        putExtra("EXTRA_PASS", binding.etPassword.text.toString())
                    }
                    startActivity(homeIntent)
                }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = RegisterFragment()
    }

}