package com.coffeeandcookies.cursokotlin.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks_entity")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var name:String = "",
    var isDone:Boolean = false
)