package co.dito.abako.apijitpack.data.model.request.general

import com.google.gson.annotations.SerializedName

data class CancelDocumentRequest(
    @SerializedName("idUsuario") val idUser: Int,
    @SerializedName("documento") val document: Int,
    @SerializedName("referenciaValidacion") val validationReference: String,
    @SerializedName("movimiento") val movement: Int = MovementType.ORDER.code
)

enum class MovementType(val code: Int) {
    ORDER(67)
}