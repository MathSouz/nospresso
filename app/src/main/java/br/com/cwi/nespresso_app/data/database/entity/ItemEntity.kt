package br.com.cwi.nespresso_app.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ItemEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val urlImage: String?,
    val unitPrice: Double,
    val description: String?,
    val type: String
    )