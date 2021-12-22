package br.com.cwi.nespresso_app.data.mapper

import br.com.cwi.nespresso_app.data.entity.coffee.DetailedCoffeeResponse
import br.com.cwi.nespresso_app.domain.entity.DetailedCoffee

class DetailedCoffeeMapper : DomainMapper<DetailedCoffeeResponse, DetailedCoffee> {

    override fun toDomain(from: DetailedCoffeeResponse): DetailedCoffee =
        DetailedCoffee(
            id = from.id,
            name = from.name,
            description = from.description,
            intensity = from.intensity,
            unitPrice = from.unitPrice,
            urlImage = from.urlImage,
            measures = from.measures,
            origin = from.origin,
            profile = from.profile,
            roasting = from.roasting
        )

    override fun toDomain(from: List<DetailedCoffeeResponse>): List<DetailedCoffee> =
        from.map { toDomain(it) }
}