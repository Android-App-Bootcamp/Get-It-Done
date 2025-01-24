package com.vinnorman.getitdone.ui.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vinnorman.getitdone.data.model.Task
import com.vinnorman.getitdone.data.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class TasksViewModel(private val repository: TaskRepository) : ViewModel() {

    fun getTasks(): Flow<List<Task>> {
        return repository.getTasks()
    }

    fun updateTask(task: Task) {
        viewModelScope.launch {
            repository.updateTask(task)
        }
    }

}