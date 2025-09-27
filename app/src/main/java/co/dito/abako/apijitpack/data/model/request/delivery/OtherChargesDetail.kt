package co.dito.abako.apijitpack.data.model.request.delivery

import com.google.gson.annotations.SerializedName

data class OtherChargesDetail(
    @SerializedName("idOC") val idOtherCharges: Double,
    @SerializedName("cant") val quantity: Int,
    @SerializedName("vr") val value: Double,
    @SerializedName("op") val operation: Double,
    @SerializedName("obs") val observation: String
)
