package co.dito.abako.apijitpack.data.model.request.report

import com.google.gson.annotations.SerializedName

data class DocumentReportRequestOld(
    @SerializedName("IdInforme") val idReport: Int,
    @SerializedName("IdConsulta") val idConsult: String,
    @SerializedName("IdPersona") val idPerson: Int
)
