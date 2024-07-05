package com.marcoantonio95.dailypulse.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.marcoantonio95.dailypulse.db.DailyPulseDatabase

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver = AndroidSqliteDriver(DailyPulseDatabase.Schema, context, "DailyPulseDatabase.Database.db")
}