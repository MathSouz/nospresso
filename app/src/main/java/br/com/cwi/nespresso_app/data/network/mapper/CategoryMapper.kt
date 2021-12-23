package br.com.cwi.nespresso_app.data.mapper

import br.com.cwi.nespresso_app.data.entity.coffee.CategoryResponse
import br.com.cwi.nespresso_app.domain.entity.CoffeeCategory

class CategoryMapper: DomainMapper<CategoryResponse, CoffeeCategory> {
    override fun toDomain(from: CategoryResponse) = CoffeeCategory(
        category = from.category,
        coffees = CoffeeMapper().toDomain(from.coffees)
    )

    override fun toDomain(from: List<CategoryResponse>) = from.map {
        toDomain(it)
    }

}