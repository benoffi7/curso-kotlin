package com.coffeeandcookies.cursokotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_mi_nombre.*

class MiNombreActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mi_nombre)
        val bundle = intent.extras
        val nombre = bundle?.get("name")
        val numero = bundle?.get("numero")

        tvGreeting.text = getString(R.string.welcome)+" $nombre $numero"

        btnBack.setOnClickListener { finish() }
    }
}