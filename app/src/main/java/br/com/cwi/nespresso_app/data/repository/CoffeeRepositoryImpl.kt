package br.com.cwi.nespresso_app.data.repository

import br.com.cwi.nespresso_app.data.entity.coffee.DetailedCoffeeResponse
import br.com.cwi.nespresso_app.data.mapper.*
import br.com.cwi.nespresso_app.data.network.NespressoApi
import br.com.cwi.nespresso_app.domain.entity.AccessoryCategory
import br.com.cwi.nespresso_app.domain.entity.CoffeeCategory
import br.com.cwi.nespresso_app.domain.entity.DetailedCoffee
import br.com.cwi.nespresso_app.domain.entity.Machine
import br.com.cwi.nespresso_app.domain.repository.CoffeeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CoffeeRepositoryImpl(
    private val api: NespressoApi
) : CoffeeRepository {

    override suspend fun getCoffees(): List<CoffeeCategory> {
        return withContext(Dispatchers.IO) {
            CategoryMapper().toDomain(api.getCoffees())
        }
    }

    override suspend fun getMachines(): List<Machine> {
        return withContext(Dispatchers.IO) {
            MachineMapper().toDomain(api.getMachines())
        }
    }

    override suspend fun getAccessories(): List<AccessoryCategory> {
        return withContext(Dispatchers.IO) {
            AccessoryCategoryMapper().toDomain(api.getAccessories())
        }
    }

    override suspend fun getDetailedCoffee(): List<DetailedCoffee> {
        return withContext(Dispatchers.IO) {
            DetailedCoffeeMapper().toDomain(api.getDetailedCoffee())
        }
    }
}