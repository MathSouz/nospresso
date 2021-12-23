package br.com.cwi.nespresso_app.presentation.extension

import br.com.cwi.nespresso_app.data.database.entity.ItemEntity
import br.com.cwi.nespresso_app.domain.entity.Accessory
import br.com.cwi.nespresso_app.domain.entity.Coffee
import br.com.cwi.nespresso_app.domain.entity.Machine

fun Coffee.toItem() : ItemEntity = ItemEntity(
    this.id,
    this.name,
    this.urlImage,
    this.unitPrice,
    this.description,
    "Café")

fun Accessory.toItem() : ItemEntity = ItemEntity(
    this.id,
    this.name,
    this.urlImage,
    this.unitPrice,
    this.description,
    "Acessório")

fun Machine.toItem() : ItemEntity = ItemEntity(
    this.id,
    this.name,
    this.urlImage,
    this.unitPrice,
    this.description,
    "Máquina")
