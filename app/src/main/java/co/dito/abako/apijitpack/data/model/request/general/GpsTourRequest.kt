package co.dito.abako.apijitpack.data.model.request.general

import com.google.gson.annotations.SerializedName

data class GpsTourRequest(
    @SerializedName("usr") val idUser: Int,
    @SerializedName("dll") val dll: List<GpsDetailRequest>
)