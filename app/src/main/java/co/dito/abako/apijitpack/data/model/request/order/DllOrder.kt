package co.dito.abako.apijitpack.data.model.request.order

import com.google.gson.annotations.SerializedName

data class DllOrder(
    @SerializedName("idArt") val idArt: Int,
    @SerializedName("cant") val cant: Int,
    @SerializedName("um") val um: String,
    @SerializedName("desc") val desc: Int,
    @SerializedName("dct") val dct: Int,
    @SerializedName("vr") val vr: Int
)
