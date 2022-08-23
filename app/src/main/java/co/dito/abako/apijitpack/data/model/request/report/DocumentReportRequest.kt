package co.dito.abako.apijitpack.data.model.request.report

import com.google.gson.annotations.SerializedName

data class DocumentReportRequest(
    @SerializedName("idInforme") val idReport: Int,
    @SerializedName("idConsulta") val idConsult: String,
    @SerializedName("idPersona") val idPerson: Int
)
