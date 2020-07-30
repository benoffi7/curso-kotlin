package com.coffeeandcookies.cursokotlin.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coffeeandcookies.cursokotlin.data.Persona
import com.coffeeandcookies.cursokotlin.R
import kotlinx.android.synthetic.main.activity_mi_nombre.*

class MiNombreActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mi_nombre)
        val bundle = intent.extras
        val nombre = bundle?.get("name")
        val numero = bundle?.get("numero")

        //tvGreeting.text = getString(R.string.welcome)+" $nombre $numero"

        btnBack.setOnClickListener { finish() }

        val miPersona = Persona("Gonzalo", 32)
        val mauro = Persona("Mauro", 29)
        val sapo = Persona("Pedro", 30)

        when (numero)
        {
            1-> tvGreeting.text = getString(R.string.welcome)+" ${miPersona.nombre}"
            2-> tvGreeting.text = getString(R.string.welcome)+" ${mauro.nombre}"
            3-> tvGreeting.text = getString(R.string.welcome)+" ${sapo.nombre}"
            else -> tvGreeting.text = "Nada de nada"
        }


    }
}