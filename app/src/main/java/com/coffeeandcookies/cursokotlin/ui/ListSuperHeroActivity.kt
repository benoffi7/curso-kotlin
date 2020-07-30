package com.coffeeandcookies.cursokotlin.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.coffeeandcookies.cursokotlin.R
import com.coffeeandcookies.cursokotlin.adapter.SuperHeroAdapter
import com.coffeeandcookies.cursokotlin.data.Superhero

class ListSuperHeroActivity : AppCompatActivity()
{
    lateinit var mRecyclerView : RecyclerView
    val mAdapter : SuperHeroAdapter = SuperHeroAdapter()
    var superheros:MutableList<Superhero> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        //union activity <---> XML
        setContentView(R.layout.activity_listsuperhero)
        superheros.add(Superhero("Spiderman", "Marvel", "Peter Parker", "https://cursokotlin.com/wp-content/uploads/2017/07/spiderman.jpg"))
        superheros.add(Superhero("Daredevil", "Marvel", "Matthew Michael Murdock", "https://cursokotlin.com/wp-content/uploads/2017/07/daredevil.jpg"))
        superheros.add(Superhero("Wolverine", "Marvel", "James Howlett", "https://cursokotlin.com/wp-content/uploads/2017/07/logan.jpeg"))
        superheros.add(Superhero("Batman", "DC", "Bruce Wayne", "https://cursokotlin.com/wp-content/uploads/2017/07/batman.jpg"))
        superheros.add(Superhero("Thor", "Marvel", "Thor Odinson", "https://cursokotlin.com/wp-content/uploads/2017/07/thor.jpg"))
        superheros.add(Superhero("Flash", "DC", "Jay Garrick", "https://cursokotlin.com/wp-content/uploads/2017/07/flash.png"))
        superheros.add(Superhero("Green Lantern", "DC", "Alan Scott", "https://cursokotlin.com/wp-content/uploads/2017/07/green-lantern.jpg"))
        superheros.add(Superhero("Wonder Woman", "DC", "Princess Diana", "https://cursokotlin.com/wp-content/uploads/2017/07/wonder_woman.jpg"))

        //datos -> adaptador -> lista

        setUpRecyclerView()


    }

    fun setUpRecyclerView(){
        mRecyclerView = findViewById(R.id.rvSuperheroList)
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter.SuperHeroAdapter(superheros, this)
        mRecyclerView.adapter = mAdapter
    }
}