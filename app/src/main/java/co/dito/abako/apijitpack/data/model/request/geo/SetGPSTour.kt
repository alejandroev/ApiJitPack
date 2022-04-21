package co.dito.abako.apijitpack.data.model.request.geo

import com.google.gson.annotations.SerializedName

data class SetGPSTour(
    @SerializedName("usr") val usr: Int,
    @SerializedName("dll") val dll: List<DllGeo>
)