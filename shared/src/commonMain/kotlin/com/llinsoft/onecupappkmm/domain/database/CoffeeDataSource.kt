package com.llinsoft.onecupappkmm.domain.database

interface CoffeeDataSource {
    suspend fun insertCoffee(coffee: Coffee)
    suspend fun getAllCoffee(): List<Coffee>
}