package com.coffeeandcookies.cursokotlin.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.coffeeandcookies.cursokotlin.dao.TasksDao
import com.coffeeandcookies.cursokotlin.data.TaskEntity

@Database(entities = arrayOf(TaskEntity::class), version = 1)
abstract class TasksDatabase : RoomDatabase() {
    abstract fun taskDao(): TasksDao
}