package br.com.cwi.nespresso_app.data.repository

import br.com.cwi.nespresso_app.data.database.AppDatabase
import br.com.cwi.nespresso_app.data.database.entity.ItemEntity
import br.com.cwi.nespresso_app.domain.repository.CoffeeLocalRepository

class CoffeeLocalRepositoryImpl(appDatabase: AppDatabase) : CoffeeLocalRepository {
    private val dao = appDatabase.getItemDao()

    override fun add(coffeeEntity: ItemEntity) {
        dao.add(coffeeEntity)
    }

    override fun remove(coffeeEntity: ItemEntity) {
        dao.remove(coffeeEntity)
    }

    override fun getAll(): List<ItemEntity>? = dao.getAll()

}