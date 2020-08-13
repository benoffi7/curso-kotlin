package com.coffeeandcookies.cursokotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.coffeeandcookies.cursokotlin.R
import com.coffeeandcookies.cursokotlin.data.Superhero
import com.coffeeandcookies.cursokotlin.data.TaskEntity

class TaskAdapter : RecyclerView.Adapter<TaskAdapter.ViewHolder> ()
{

    var tasks: MutableList<TaskEntity>  = ArrayList()
    lateinit var context: Context

    fun TaskAdapter (tasks : MutableList<TaskEntity>, context: Context){
        this.tasks = tasks
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TaskAdapter.ViewHolder(
            layoutInflater.inflate(
                R.layout.row_task,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onBindViewHolder(holder: TaskAdapter.ViewHolder, position: Int) {
        val item = tasks.get(position)
        holder.bind(item, context)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val cbIsDone = view.findViewById(R.id.cbIsDone) as CheckBox
        val tvTask = view.findViewById(R.id.tvTask) as TextView

        fun bind(task:TaskEntity, context: Context)
        {
            cbIsDone.isChecked =task.isDone
            tvTask.text = task.name
        }
    }
}