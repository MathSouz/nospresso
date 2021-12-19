package br.com.cwi.nespresso_app.domain.entity

class CoffeeCategory(
    val category: String,
    val coffees: List<Coffee>,
): Type(ItemType.CATEGORY)