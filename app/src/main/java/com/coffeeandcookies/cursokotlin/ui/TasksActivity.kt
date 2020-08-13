package com.coffeeandcookies.cursokotlin.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.coffeeandcookies.cursokotlin.R
import com.coffeeandcookies.cursokotlin.adapter.SuperHeroAdapter
import com.coffeeandcookies.cursokotlin.adapter.TaskAdapter
import com.coffeeandcookies.cursokotlin.data.TaskEntity
import com.coffeeandcookies.cursokotlin.util.SharedApp
import kotlinx.android.synthetic.main.activity_taks.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TasksActivity : AppCompatActivity()
{
    lateinit var recyclerView: RecyclerView
    lateinit var tasks: MutableList<TaskEntity>

    val mAdapter : TaskAdapter = TaskAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taks)
        tasks = ArrayList()
        getTasks()
        btnAddTask.setOnClickListener{ addTask(TaskEntity(name = etTask.text.toString()))   }
    }

    fun getTasks() {
        doAsync {
            tasks = SharedApp.database.taskDao().getAllTasks()
            uiThread {
                setUpRecyclerView(tasks)
            }
        }
    }

    //TODO actualizar si esta hecha y eliminar

    fun addTask(task:TaskEntity)
    {
        doAsync {
            val id = SharedApp.database.taskDao().addTask(task)
            //val recoveryTask = SharedApp.database.taskDao().getTaskById(id)
            uiThread {
                tasks.add(task)
                mAdapter.notifyItemInserted(tasks.size)
                clearFocus()
                hideKeyboard()
            }
        }
    }

    fun clearFocus(){
        etTask.setText("")
    }

    @SuppressLint("ServiceCast")
    fun Context.hideKeyboard() {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }




    fun setUpRecyclerView(tasks: MutableList<TaskEntity>)
    {

        recyclerView = findViewById(R.id.rvTask)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter.TaskAdapter(tasks,this)
        recyclerView.adapter = mAdapter

    }



}

