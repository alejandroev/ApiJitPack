package co.dito.abako.apijitpack.data.model.request.order

import com.google.gson.annotations.SerializedName

data class DllCmbOrder (
    @SerializedName("idArt") val idArt: Int,
    @SerializedName("cant") val cant: Int,
    @SerializedName("um") val um: String
)
