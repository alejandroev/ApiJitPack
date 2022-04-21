package co.dito.abako.apijitpack.data.model.request.document

import com.google.gson.annotations.SerializedName

data class SetDocumentState(
    @SerializedName("movimiento") val movement: Int,
    @SerializedName("idUsuario") val idUser: Int,
    @SerializedName("documento") val document: Int,
    @SerializedName("estado") val state: String,
    @SerializedName("referenciaValidacion") val validationReference: String
)
