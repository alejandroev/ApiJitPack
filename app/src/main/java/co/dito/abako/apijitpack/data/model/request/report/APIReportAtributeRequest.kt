package co.dito.abako.apijitpack.data.model.request.report

import com.google.gson.annotations.SerializedName

data class APIReportAtributeRequest(
    @SerializedName("parametros")
    val parametros: List<ParametroAtribute>
)

data class ParametroAtribute(
    @SerializedName("clave")
    val clave: String,
    @SerializedName("valor")
    val valor: String
)