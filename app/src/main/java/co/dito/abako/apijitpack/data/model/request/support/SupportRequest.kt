package co.dito.abako.apijitpack.data.model.request.support

import com.google.gson.annotations.SerializedName

data class SupportRequest(
    @SerializedName("codigoCodi") val codiCode: String,
    @SerializedName("tipoEvento") val eventType: String = "Error",
    @SerializedName("proceso") val process: String,
    @SerializedName("evento") val event: String,
    @SerializedName("fuente") val source: String = "3",
)
