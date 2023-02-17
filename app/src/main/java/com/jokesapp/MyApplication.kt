package com.jokesapp

import android.app.Application
import com.jokesapp.data.db.JokeDatabase
import com.jokesapp.domain.appmodule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@MyApplication)
            modules(appmodule)
        }
    }
}