package com.marcoantonio95.dailypulse.di

import com.marcoantonio95.dailypulse.db.DatabaseDriverFactory
import com.marcoantonio95.dailypulse.db.DailyPulseDatabase
import app.cash.sqldelight.db.SqlDriver
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory().createDriver() }

    single<DailyPulseDatabase> { DailyPulseDatabase(get()) }
}