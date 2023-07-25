package co.dito.abako.apijitpack.data.model.response.general

import com.google.gson.annotations.SerializedName

data class MasterIdResponse(
    @SerializedName("mensaje") val messageResponse: MessageResponse,
    @SerializedName("idMaestro") val masterId: String?
)

enum class MasterTypeRequest(val value: String) {
    PREFIX_ADDRESS("PREFIJODIRECCION"),
    NEIGHBORHOOD("BARRIO")
}