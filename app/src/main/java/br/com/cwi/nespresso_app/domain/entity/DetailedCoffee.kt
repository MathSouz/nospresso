package br.com.cwi.nespresso_app.domain.entity

class DetailedCoffee(
    id: Int,
    name: String,
    urlImage: String?,
    unitPrice: Double,
    var description: String,
    var origin: String?,
    var roasting: String?,
    var profile: String?,
    var intensity: Int?,
    var measures: List<String>
): Product(
    id,
    name,
    urlImage,
    unitPrice
)