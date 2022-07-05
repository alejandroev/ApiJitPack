package co.dito.abako.apijitpack.data.model.request.general

import com.google.gson.annotations.SerializedName

data class CancelDocumentRequest(
    @SerializedName("Movimiento") val movement: Double,
    @SerializedName("IdUsuario") val idUser: Double,
    @SerializedName("Documento") val document: Double,
    @SerializedName("ReferenciaValidacion") val validationReference: String
)
