package com.llinsoft.onecupappkmm.data.local

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.llinsoft.onecupappkmm.database.CoffeeDatabase

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(CoffeeDatabase.Schema, "coffee.db")
    }
}