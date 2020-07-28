package com.coffeeandcookies.cursokotlin

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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
            intent.putExtra("numero",3)
            startActivity(intent)
        }
    }
}