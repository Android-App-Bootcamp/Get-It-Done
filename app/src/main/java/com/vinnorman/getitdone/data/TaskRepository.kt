package com.vinnorman.getitdone.data

import com.vinnorman.getitdone.data.database.TaskDao
import com.vinnorman.getitdone.data.model.Task
import kotlinx.coroutines.flow.Flow

class TaskRepository(private val taskDao: TaskDao) {

    suspend fun createTask(task: Task) {
        taskDao.createTask(task)
    }

    fun getTasks(): Flow<List<Task>> {
        return taskDao.getAllTasks()
    }

    suspend fun updateTask(task: Task) {
        taskDao.updateTask(task)
    }

    suspend fun deleteTask(task: Task) {
        taskDao.deleteTask(task)
    }

}