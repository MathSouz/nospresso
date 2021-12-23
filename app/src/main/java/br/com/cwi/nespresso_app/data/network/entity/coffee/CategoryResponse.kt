package br.com.cwi.nespresso_app.data.entity.coffee

import com.squareup.moshi.Json

data class CategoryResponse(
    @Json(name = "categoria") val category: String,
    @Json(name = "cafes") val coffees: List<CoffeeResponse>
): CapsuleType(type = 0)