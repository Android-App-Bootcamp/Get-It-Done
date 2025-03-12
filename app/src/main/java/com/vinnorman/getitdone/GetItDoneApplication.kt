package com.vinnorman.getitdone

import android.app.Application
import com.vinnorman.getitdone.data.TaskRepository
import com.vinnorman.getitdone.data.database.GetItDoneDatabase

class GetItDoneApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val database = GetItDoneDatabase.getDatabase(this)
        val taskDao = database.getTaskDao()
        taskRepository = TaskRepository(taskDao)
    }

    companion object {

        lateinit var taskRepository: TaskRepository

    }

}