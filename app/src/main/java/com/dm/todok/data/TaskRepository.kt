package com.dm.todok.data

import com.dm.todok.model.Task

interface TaskRepository {
    suspend fun loadTasks(): List<Task>?
    suspend fun createTask(task: Task) : Task?
    suspend fun deleteTask(task: Task) : Boolean
    suspend fun updateTask(task: Task): Task?
}