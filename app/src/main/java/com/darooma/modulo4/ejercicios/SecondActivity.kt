package com.darooma.modulo4.ejercicios

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.darooma.modulo4.R
import java.util.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val name = intent.getStringExtra("EXTRA_NAME")
        val lastName = intent.getStringExtra("EXTRA_LASTNAME")
        val age = intent.getIntExtra("EXTRA_AGE", 0)
        val single = intent.getBooleanExtra("EXTRA_SINGLE", true)
        val average = intent.getDoubleExtra("EXTRA_AVERAGE", 0.0)
        val ratings = intent.getIntArrayExtra("EXTRA_RATINGS")
        val birthdayYear = intent.getShortExtra("EXTRA_BIRTHDAY_YEAR", 0)
        val friends = intent.getStringArrayExtra("EXTRA_FRIENDS")

        val tvName = findViewById<TextView>(R.id.tvName)
        val tvLastName = findViewById<TextView>(R.id.tvLastName)
        val tvAge = findViewById<TextView>(R.id.tvAge)
        val tvSingle = findViewById<TextView>(R.id.tvSingle)
        val tvAverage = findViewById<TextView>(R.id.tvAverage)
        val tvRatings = findViewById<TextView>(R.id.tvRatings)
        val tvBirthdayYear = findViewById<TextView>(R.id.tvBirthdayYear)
        val tvFriends = findViewById<TextView>(R.id.tvFriends)

        tvName.text = name
        tvLastName.text = lastName
        tvAge.text = "${age}"
        tvSingle.text = if (single) "Soltero/a" else "En una relación" //poner si es texto
        tvAverage.text = "" + average
        tvRatings.text = Arrays.toString(ratings)
        tvBirthdayYear.text = "${birthdayYear}"
        tvFriends.text = Arrays.toString(friends)

        val btBack = findViewById<Button>(R.id.btBack)
        //Al darle click genera intent con este booleano y regresalo
        btBack.setOnClickListener {
            val returnIntent = Intent().apply {
                putExtra("EXTRA_NAME", name)
                putExtra("EXTRA_LASTNAME", lastName)
                putExtra("EXTRA_AGE", age)
                putExtra("EXTRA_SINGLE", single)
                putExtra("EXTRA_AVERAGE", average)
                putExtra("EXTRA_RATINGS", ratings)
                putExtra("EXTRA_BIRTHDAY_YEAR", birthdayYear)
                putExtra("EXTRA_FRIENDS", friends)
            }
            //pide codigo de resultado
            setResult(RESULT_OK, returnIntent)
            finish()
        }


    }
}