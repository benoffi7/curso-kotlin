package com.coffeeandcookies.cursokotlin.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.coffeeandcookies.cursokotlin.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        //busco en el archivo R (recursos) uno del tipo ventana (layout) y que coincida con el nombre del archivo XML
        //establecemos la relación entre Kt con un XML
        setContentView(R.layout.activity_main)
        buttonAceptar.setOnClickListener {
            revisarCajatexto()
        }
        buttonSuperHeroes.setOnClickListener()
        {
            val intent : Intent = Intent(this,ListSuperHeroActivity::class.java)
            startActivity(intent)
        }


    }

    fun revisarCajatexto()
    {
        if (editTextTextPersonName.text.isEmpty())
        {
            Toast.makeText(this,"No puede estar vacio!",Toast.LENGTH_SHORT).show();
        }
        else
        {
            //ir a otra pantalla
            val intent = Intent(this, MiNombreActivity::class.java)
            intent.putExtra("name", editTextTextPersonName.text.toString())
            intent.putExtra("numero",1)
            startActivity(intent)
        }
    }
}