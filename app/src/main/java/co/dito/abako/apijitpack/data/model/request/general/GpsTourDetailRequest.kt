package co.dito.abako.apijitpack.data.model.request.general

import com.google.gson.annotations.SerializedName

data class GpsTourDetailRequest(
    @SerializedName("idEmp") val idEmp: Int,
    @SerializedName("lon") val lon: Int,
    @SerializedName("lat") val lat: Int,
    @SerializedName("fc") val fc: String,
    @SerializedName("tp") val tp: String,
    @SerializedName("id") val id: Int
)
