package co.dito.abako.apijitpack.data.model.request.inventory

import com.google.gson.annotations.SerializedName

data class Inventory(
    @SerializedName("proceso") val process: String,
    @SerializedName("id") val id: Int,
    @SerializedName("idPersona") val idPerson: Int,
    @SerializedName("detalleContado") val detailContact: List<DetailContactInventory>
)
