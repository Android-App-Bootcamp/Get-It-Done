package com.vinnorman.getitdone.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vinnorman.getitdone.data.model.Task
import com.vinnorman.getitdone.data.TaskRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: TaskRepository) : ViewModel() {


    fun createTask(task: Task) {
        viewModelScope.launch {
            repository.addTask(task)
        }
    }
}