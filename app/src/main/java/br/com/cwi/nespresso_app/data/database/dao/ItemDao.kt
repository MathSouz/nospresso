package br.com.cwi.nespresso_app.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.com.cwi.nespresso_app.data.database.entity.ItemEntity

@Dao
interface ItemDao {

    @Insert
    fun add(coffeeEntity: ItemEntity)

    @Delete
    fun remove(coffeeEntity: ItemEntity)

    @Query("SELECT * FROM ItemEntity")
    fun getAll(): List<ItemEntity>?
}