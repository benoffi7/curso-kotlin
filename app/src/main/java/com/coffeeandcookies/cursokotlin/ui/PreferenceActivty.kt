package com.coffeeandcookies.cursokotlin.ui

import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.coffeeandcookies.cursokotlin.R
import com.coffeeandcookies.cursokotlin.util.SharedApp
import kotlinx.android.synthetic.main.activity_preferences.*
import kotlinx.android.synthetic.main.activity_preferences.view.*

class PreferenceActivty : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences)
        button_submit.setOnClickListener {  postValues() }
    }

    override fun onResume() {
        super.onResume()
        getValues()
    }

    fun getValues()
    {
        switch_KeepMeLoggedIn.isChecked = SharedApp.prefs.getByNameBool("KeepMeLoggedIn")!!
        et_age.setText(SharedApp.prefs.getByName("age"))
        et_email.setText(SharedApp.prefs.getByName("mail"))
        cb_sound.isChecked = SharedApp.prefs.getByNameBool("sound")!!
        //val rb = rg_gender.getChildAt(SharedApp.prefs.getByNameInt("gender")!!) as RadioButton
        //rb.isChecked = true
        //val rb = findViewById<RadioButton>(SharedApp.prefs.getByNameInt("gender_rb")!!)
        rg_gender.check(SharedApp.prefs.getByNameInt("gender_rb")!!)

    }

    fun postValues()
    {
        SharedApp.prefs.setByNameBool("KeepMeLoggedIn",switch_KeepMeLoggedIn.isChecked)
        SharedApp.prefs.setByNameBool("sound",cb_sound.isChecked)

        SharedApp.prefs.setByName("age",et_age.text.toString())
        SharedApp.prefs.setByName("mail",et_email.text.toString())

        /*
        val selectedIndex = rg_gender?.indexOfChild(
            rg_gender?.findViewById(
                rg_gender.checkedRadioButtonId
            )
        )

        if (selectedIndex != null)
        {
            SharedApp.prefs.setByNameInt("gender",selectedIndex)
        }
        */


        SharedApp.prefs.setByNameInt("gender_rb",rg_gender.checkedRadioButtonId)

        Toast.makeText(this,"Todo ok",Toast.LENGTH_SHORT).show()
    }
}