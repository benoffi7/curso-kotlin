package com.coffeeandcookies.cursokotlin.util

import android.app.Application
import androidx.room.Room
import com.coffeeandcookies.cursokotlin.database.TasksDatabase

class SharedApp : Application()
{
    companion object {
        lateinit var prefs: Prefs
        lateinit var database: TasksDatabase
    }


    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
        database = Room.databaseBuilder(this,TasksDatabase::class.java,"tasks-db").build()
    }
}