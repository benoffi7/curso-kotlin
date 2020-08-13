package com.coffeeandcookies.cursokotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.coffeeandcookies.cursokotlin.R
import com.coffeeandcookies.cursokotlin.data.Superhero
import com.squareup.picasso.Picasso

class SuperHeroAdapter : RecyclerView.Adapter<SuperHeroAdapter.ViewHolder>() {

    var superheros: MutableList<Superhero>  = ArrayList()
    lateinit var context: Context

    fun SuperHeroAdapter (superheros : MutableList<Superhero>, context: Context){
        this.superheros = superheros
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.row_superhero, parent, false))
    }

    override fun getItemCount(): Int {
        return superheros.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = superheros.get(position)
        holder.bind(item, context)
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val superheroName = view.findViewById(R.id.tvSuperhero) as TextView
        val realName = view.findViewById(R.id.tvRealName) as TextView
        val publisher = view.findViewById(R.id.tvPublisher) as TextView
        val avatar = view.findViewById(R.id.ivAvatar) as ImageView

        fun bind(superhero:Superhero, context: Context){
            superheroName.text = superhero.superhero
            realName.text = superhero.realName
            publisher.text = superhero.publisher
            loadUrl(superhero.photo)

            itemView.setOnClickListener { Toast.makeText(context, superhero.photo, Toast.LENGTH_SHORT).show() }

        }

        fun loadUrl(url: String)
        {
            Picasso.get().load(url).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(avatar);
        }
    }


}