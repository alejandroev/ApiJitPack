package co.dito.abako.apijitpack.data.model.request.report

import com.google.gson.annotations.SerializedName

data class DocumentReportRequest(
    @SerializedName("idInforme") val reportId: Int = ORDER_INFORM,
    @SerializedName("idConsulta") val searchId: String,
    @SerializedName("idPersona") val personId: Int
)

const val ORDER_INFORM = 8