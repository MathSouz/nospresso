package br.com.cwi.nespresso_app.data.entity.accessories

import com.squareup.moshi.Json

class AccessoryCategoryResponse(
    @Json(name = "categoria") val category: String,
    @Json(name = "itens") val items: List<AccessoriesResponse>
): AccessoryType(type = 0)