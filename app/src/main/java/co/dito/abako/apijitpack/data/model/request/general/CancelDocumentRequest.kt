package co.dito.abako.apijitpack.data.model.request.general

import com.google.gson.annotations.SerializedName

data class CancelDocumentRequest(
    @SerializedName("movimiento") val movement: Int,
    @SerializedName("idUsuario") val idUser: Int,
    @SerializedName("documento") val document: Int,
    @SerializedName("referenciaValidacion") val validationReference: String
)
