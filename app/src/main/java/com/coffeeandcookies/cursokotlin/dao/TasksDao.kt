package com.coffeeandcookies.cursokotlin.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.coffeeandcookies.cursokotlin.data.TaskEntity

@Dao
interface TasksDao
{
    @Query("Select * from tasks_entity")
    fun getAllTasks(): MutableList<TaskEntity>

    @Insert
    fun addTask(taskEntity : TaskEntity):Long

    @Query("SELECT * FROM tasks_entity where id like :id")
    fun getTaskById(id: Long): TaskEntity

}