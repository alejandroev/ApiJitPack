package co.dito.abako.apijitpack.data.model.request.person

import com.google.gson.annotations.SerializedName

data class CRUDExistingPerson(
    @SerializedName("idPersona") val idPerson: Int,
    @SerializedName("accion") val action: String,
    @SerializedName("persona") val person: List<*>
)
