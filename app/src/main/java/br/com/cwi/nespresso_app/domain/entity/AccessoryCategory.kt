package br.com.cwi.nespresso_app.domain.entity

class AccessoryCategory(
    val category: String,
    val accessories: List<Accessory>,
): Type(ItemType.CATEGORY)