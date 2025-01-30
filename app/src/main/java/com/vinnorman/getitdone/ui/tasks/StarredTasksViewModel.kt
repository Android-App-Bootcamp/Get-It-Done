package com.vinnorman.getitdone.ui.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vinnorman.getitdone.data.TaskRepository
import com.vinnorman.getitdone.data.model.Task
import kotlinx.coroutines.launch

class StarredTasksViewModel(private val repository: TaskRepository) : ViewModel() {

    val starredTasks = repository.getStarredTasks()

    fun updateTask(task: Task) {
        viewModelScope.launch {
            repository.updateTask(task)
        }
    }

}