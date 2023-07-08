package com.darooma.modulo4.tareaRegistro

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.darooma.modulo4.R
import com.darooma.modulo4.utils.GeneralTools


class RegistroActivity : AppCompatActivity() {

    private lateinit var dialog : Dialog
    private var errorBoolean : Boolean = false
    private lateinit var errorText : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        this.setTitle("Tarea Ejercicio")

        val nombre = findViewById<EditText>(R.id.etNombre)
        val apellido = findViewById<EditText>(R.id.etApellido)
        val correo = findViewById<EditText>(R.id.etCorreo)
        val sexo = findViewById<RadioGroup>(R.id.rgSexo)
        val password = findViewById<EditText>(R.id.etPassword)
        val registrar = findViewById<Button>(R.id.btnRegister)


        this.dialog =  Dialog(this)

        registrar.setOnClickListener {
            if (nombre.text.isBlank() || apellido.text.isBlank() ||
                correo.text.isBlank() || password.text.isBlank()){
                openWinDialog("Favor de llenar todos los campos")
                //android:backgroundTint="@android:color/holo_red_light" //estaria bien cambiar tint
            }else if(!GeneralTools.isValidEmail(correo.text)){
                openWinDialog("Favor de insertar un correo valido")
            }else if(password.text.length < 8 ){
                openWinDialog("La contraseña es muy corta, debe contener mínimo 8 caracteres")
            }else if(sexo.checkedRadioButtonId == -1){
                openWinDialog("Favor de indicar si es Hombre o Mujer")
            }else{
                val registro2Intent = Intent(this, Registro2Activity::class.java).apply {
                    putExtra("EXTRA_NAME", nombre.text.toString())
                    putExtra("EXTRA_LASTNAME", apellido.text.toString())
                    putExtra("EXTRA_MAIL", correo.text.toString())
                    val selectedId: Int = sexo.checkedRadioButtonId
                    putExtra("EXTRA_SEX", findViewById<RadioButton>(selectedId).text)
                    putExtra("EXTRA_PASS", password.text.toString())
                }
                startActivity(registro2Intent)
            }
        }


    }

    private fun openWinDialog(error:String) {
        dialog.setContentView(R.layout.layout_dialog)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#80a9a9a9")))
        var textError = dialog.findViewById<TextView>(R.id.tvMensajeAlerta)
        textError.text = error
        val imageViewClose = dialog.findViewById<Button>(R.id.btnCerrarDialog)
        imageViewClose.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }


}