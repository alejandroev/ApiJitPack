package co.dito.abako.apijitpack.data.model.request.workshop

import com.google.gson.annotations.SerializedName

data class WorkshopRequest(
    @SerializedName("idOrdenServicio") val idOrder: Int,
    @SerializedName("idPersona") val idPerson: Int
)
