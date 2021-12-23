package br.com.cwi.nespresso_app.domain.repository

import br.com.cwi.nespresso_app.data.entity.coffee.CoffeeResponse
import br.com.cwi.nespresso_app.domain.entity.AccessoryCategory
import br.com.cwi.nespresso_app.domain.entity.CoffeeCategory
import br.com.cwi.nespresso_app.domain.entity.DetailedCoffee
import br.com.cwi.nespresso_app.domain.entity.Machine

interface CoffeeRepository {
    suspend fun getCoffees(): List<CoffeeCategory>
    suspend fun getMachines(): List<Machine>
    suspend fun getAccessories(): List<AccessoryCategory>
    suspend fun getDetailedCoffee(id : Int): DetailedCoffee
}