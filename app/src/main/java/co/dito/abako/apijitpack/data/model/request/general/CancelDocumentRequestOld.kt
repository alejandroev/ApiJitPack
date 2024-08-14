package co.dito.abako.apijitpack.data.model.request.general

import com.google.gson.annotations.SerializedName

data class CancelDocumentRequestOld(
    @SerializedName("Movimiento") val movement: Int,
    @SerializedName("IdUsuario") val idUser: Int,
    @SerializedName("Documento") val document: Int,
    @SerializedName("ReferenciaValidacion") val validationReference: String
)
