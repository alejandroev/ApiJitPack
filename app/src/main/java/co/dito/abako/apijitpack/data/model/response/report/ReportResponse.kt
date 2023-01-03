package co.dito.abako.apijitpack.data.model.response.report

import com.google.gson.annotations.SerializedName

data class ReportResponse(
    @SerializedName("formaPago") val payMode: String,
    @SerializedName("pendiente") val pending: Double,
    @SerializedName("cupo") val quota: Double
)
