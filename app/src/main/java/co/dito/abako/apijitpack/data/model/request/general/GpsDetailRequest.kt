package co.dito.abako.apijitpack.data.model.request.general

import com.google.gson.annotations.SerializedName

data class GpsDetailRequest(
    @SerializedName("idEmp") val idBusiness: Int,
    @SerializedName("lon") val longitude: Int,
    @SerializedName("lat") val latitude: Int,
    @SerializedName("fc") val creationDate: String,
    @SerializedName("tp") val type: String
)
