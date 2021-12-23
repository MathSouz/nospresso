package br.com.cwi.nespresso_app.domain.repository

import br.com.cwi.nespresso_app.data.database.entity.ItemEntity

interface CoffeeLocalRepository {
    fun add(coffeeEntity: ItemEntity)
    fun remove(coffeeEntity: ItemEntity)
    fun getAll(): List<ItemEntity>?
}
