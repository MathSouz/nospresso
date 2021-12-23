package br.com.cwi.nespresso_app.data.network

import br.com.cwi.nespresso_app.data.entity.accessories.AccessoryCategoryResponse
import br.com.cwi.nespresso_app.data.entity.coffee.CategoryResponse
import br.com.cwi.nespresso_app.data.entity.coffee.CoffeeResponse
import br.com.cwi.nespresso_app.data.entity.coffee.DetailedCoffeeResponse
import br.com.cwi.nespresso_app.data.entity.machine.MachineResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface NespressoApi {

    @GET("/capsulas")
    suspend fun getCoffees(): List<CategoryResponse>

    @GET("/maquinas")
    suspend fun getMachines(): List<MachineResponse>

    @GET("/acessorios")
    suspend fun getAccessories(): List<AccessoryCategoryResponse>

    @GET("/cafes/{id}")
    suspend fun getDetailedCoffee(@Path("id") id : Int) : DetailedCoffeeResponse
}