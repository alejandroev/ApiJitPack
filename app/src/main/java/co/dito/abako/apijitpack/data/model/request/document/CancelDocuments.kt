package co.dito.abako.apijitpack.data.model.request.document

import com.google.gson.annotations.SerializedName

data class CancelDocuments(
    @SerializedName("movimiento") val movement: Int,
    @SerializedName("idUsuario") val idUser: Int,
    @SerializedName("documento") val document: Int,
    @SerializedName("referenciaValidacion") val validationReference: String
)