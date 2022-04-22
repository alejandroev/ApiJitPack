package co.dito.abako.apijitpack.data.model.request.geo

import com.google.gson.annotations.SerializedName

data class DllGeo(
    @SerializedName("idEmp") val idEmp: Int,
    @SerializedName("lon") val lon: Int,
    @SerializedName("lat") val lat: Int,
    @SerializedName("fc") val fc: String,
    @SerializedName("tp") val tp: String,
    @SerializedName("id") val id: Int
)
