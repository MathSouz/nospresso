package br.com.cwi.nespresso_app.data.entity.machine

import com.squareup.moshi.Json

data class MachineListResponse (
    @Json(name = "maquinas") val machines : List<MachineResponse>
)