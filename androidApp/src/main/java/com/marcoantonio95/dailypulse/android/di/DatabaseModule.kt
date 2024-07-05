package com.marcoantonio95.dailypulse.android.di

import org.koin.dsl.module
import com.marcoantonio95.dailypulse.db.DatabaseDriverFactory
import com.marcoantonio95.dailypulse.db.DailyPulseDatabase
import app.cash.sqldelight.db.SqlDriver
import org.koin.android.ext.koin.androidContext

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver() }

    single<DailyPulseDatabase> { DailyPulseDatabase(get()) }
}