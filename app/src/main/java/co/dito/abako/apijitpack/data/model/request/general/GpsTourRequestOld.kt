package co.dito.abako.apijitpack.data.model.request.general

import com.google.gson.annotations.SerializedName

data class GpsTourRequestOld(
    @SerializedName("Usr") val user: Double,
    @SerializedName("Dll") val detailOld: List<GpsTourDetailRequestOld>
)
