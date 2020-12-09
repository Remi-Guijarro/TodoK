package com.example.todogeoffreyremi.tasklist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todogeoffreyremi.R

class TaskListAdapter (val taskList: MutableList<Task>) : RecyclerView.Adapter<TaskListAdapter.TaskViewHolder>() {

    var onDeleteTask: ((Task) -> Unit)? = null
    var onEditTask: ((Task) -> Unit)? = null

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(task: Task) {
            itemView.apply { // `apply {}` permet d'éviter de répéter `itemView.*`
                val titleTextView = itemView.findViewById<TextView>(R.id.task_title)
                titleTextView.text = task.title

                val descriptionTestView = itemView.findViewById<TextView>(R.id.task_description)
                descriptionTestView.text = task.description
            }

            val deleteButton = itemView.findViewById<ImageButton>(R.id.task_delete)
            deleteButton.setOnClickListener {
                onDeleteTask?.invoke(task)
            }

            val editButton = itemView.findViewById<ImageButton>(R.id.task_edit)
            editButton.setOnClickListener {
                onEditTask?.invoke(task)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(itemView)
    }


    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(taskList[position])
    }
}