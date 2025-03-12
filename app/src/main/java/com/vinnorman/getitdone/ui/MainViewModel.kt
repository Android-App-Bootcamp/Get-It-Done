package com.vinnorman.getitdone.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vinnorman.getitdone.GetItDoneApplication
import com.vinnorman.getitdone.data.TaskRepository
import com.vinnorman.getitdone.data.model.Task
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository: TaskRepository = GetItDoneApplication.taskRepository

    fun createTask(title: String, description: String?) {
        val task = Task(
            title = title,
            description = description
        )
        viewModelScope.launch {
            repository.createTask(task)
        }
    }

}