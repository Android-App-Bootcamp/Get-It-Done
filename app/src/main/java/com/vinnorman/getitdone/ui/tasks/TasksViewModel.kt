package com.vinnorman.getitdone.ui.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vinnorman.getitdone.GetItDoneApplication
import com.vinnorman.getitdone.data.TaskRepository
import com.vinnorman.getitdone.data.model.Task
import kotlinx.coroutines.launch

class TasksViewModel : ViewModel() {

    private val repository: TaskRepository = GetItDoneApplication.taskRepository

    suspend fun fetchTasks(): List<Task> {
        val tasks = repository.getTasks()
        return tasks
    }

    fun updateTask(task: Task, onTaskCompleted: () -> Unit) {
        viewModelScope.launch {
            repository.updateTask(task)
            onTaskCompleted()
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            repository.deleteTask(task)
        }
    }
}