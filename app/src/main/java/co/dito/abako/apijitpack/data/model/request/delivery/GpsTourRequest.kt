package co.dito.abako.apijitpack.data.model.request.delivery

import com.google.gson.annotations.SerializedName

data class GpsTourRequest(
    @SerializedName("Usr") val user: Double,
    @SerializedName("Dll") val detail: List<GpsTourDetailRequest>
)
