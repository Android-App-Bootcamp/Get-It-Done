package com.vinnorman.getitdone.data

import android.content.Context
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vinnorman.getitdone.data.model.Task
import com.vinnorman.getitdone.data.model.TaskList
import org.koin.android.ext.koin.androidContext

@Database(
    entities = [
        Task::class,
        TaskList::class
    ],
    version = 3
)
abstract class GetItDoneDatabase : RoomDatabase() {

    abstract fun getTaskDao(): TaskDao

    companion object {

        private const val DB_NAME = "get-it-done-database"

        fun build(context: Context) = Room.databaseBuilder(
            context,
            GetItDoneDatabase::class.java,
            DB_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

}