package br.com.cwi.nespresso_app.data.network

import br.com.cwi.nespresso_app.data.entity.accessories.AccessoryCategoryResponse
import br.com.cwi.nespresso_app.data.entity.coffee.CategoryResponse
import br.com.cwi.nespresso_app.data.entity.machine.MachineResponse
import retrofit2.http.GET

interface NespressoApi {

    @GET("/capsulas")
    suspend fun getCoffees(): List<CategoryResponse>

    @GET("/maquinas")
    suspend fun getMachines(): List<MachineResponse>

    @GET("/acessorios")
    suspend fun getAccessories(): List<AccessoryCategoryResponse>
}