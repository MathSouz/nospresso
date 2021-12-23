package br.com.cwi.nespresso_app.data.mapper

import br.com.cwi.nespresso_app.data.entity.accessories.AccessoriesResponse
import br.com.cwi.nespresso_app.domain.entity.Accessory

class AccessoryMapper : DomainMapper<AccessoriesResponse, Accessory>{
    override fun toDomain(from: AccessoriesResponse): Accessory = Accessory(from.id, from.name, from.imageUrl, from.price, from.description)


    override fun toDomain(from: List<AccessoriesResponse>): List<Accessory> = from.map { toDomain(it) }
}