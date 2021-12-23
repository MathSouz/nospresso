package br.com.cwi.nespresso_app.data.mapper

import br.com.cwi.nespresso_app.data.entity.accessories.AccessoryCategoryResponse
import br.com.cwi.nespresso_app.domain.entity.AccessoryCategory

class AccessoryCategoryMapper: DomainMapper<AccessoryCategoryResponse, AccessoryCategory> {
    override fun toDomain(from: AccessoryCategoryResponse) = AccessoryCategory(
        from.category, AccessoryMapper().toDomain(from.items)
    )

    override fun toDomain(from: List<AccessoryCategoryResponse>) = from.map {
        toDomain(it)
    }

}