package com.vinnorman.getitdone

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class GetItDoneApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@GetItDoneApplication)
            modules(appModule)
        }
    }
}