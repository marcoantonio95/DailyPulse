package com.marcoantonio95.dailypulse.android

import android.app.Application
import com.marcoantonio95.dailypulse.android.di.viewModelsModule
import com.marcoantonio95.dailypulse.di.sharedKoinModules
import com.marcoantonio95.dailypulse.android.di.databaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DailyPulseApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModules + viewModelsModule + databaseModule

        startKoin {
            androidContext(this@DailyPulseApp)
            modules(modules)
        }
    }
}