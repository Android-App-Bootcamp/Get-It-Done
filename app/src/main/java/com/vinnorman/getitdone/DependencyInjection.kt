package com.vinnorman.getitdone

import androidx.room.Room
import com.vinnorman.getitdone.data.GetItDoneDatabase
import com.vinnorman.getitdone.data.TaskRepository
import com.vinnorman.getitdone.ui.MainViewModel
import com.vinnorman.getitdone.ui.tasks.TasksViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { MainViewModel(repository = get()) }
    viewModel { TasksViewModel(repository = get()) }

    single { TaskRepository(database = get()) }

    single { GetItDoneDatabase.build(androidContext()) }

}