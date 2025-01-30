package com.vinnorman.getitdone.data

import com.vinnorman.getitdone.data.model.Task
import kotlinx.coroutines.flow.Flow

class TaskRepository(private val database: GetItDoneDatabase) {

    fun getTasks(): Flow<List<Task>> {
        return database.getTaskDao().getAllTasks()
    }

    fun getStarredTasks(): Flow<List<Task>> {
        return database.getTaskDao().getStarredTasks()
    }

    suspend fun addTask(task: Task) {
        database.getTaskDao().createTask(task)
    }

    suspend fun updateTask(task: Task) {
        database.getTaskDao().updateTask(task)
    }

}