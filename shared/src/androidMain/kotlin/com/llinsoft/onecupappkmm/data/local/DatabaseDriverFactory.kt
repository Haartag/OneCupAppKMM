package com.llinsoft.onecupappkmm.data.local

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.llinsoft.onecupappkmm.database.CoffeeDatabase

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(CoffeeDatabase.Schema, context, "coffee.db")
    }
}