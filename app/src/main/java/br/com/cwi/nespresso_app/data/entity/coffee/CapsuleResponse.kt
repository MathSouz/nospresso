package br.com.cwi.nespresso_app.data.entity.coffee

import com.squareup.moshi.Json

data class CapsuleResponse(
    @Json(name = "capsulas") val capsules: List<CategoryResponse>
)