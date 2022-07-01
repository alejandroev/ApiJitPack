package co.dito.abako.apijitpack.data.model.request.delivery

import com.google.gson.annotations.SerializedName

data class OtherChargesDetail(
    @SerializedName("IdOC") val idOtherCharges: Double,
    @SerializedName("Cant") val quantity: Int,
    @SerializedName("Vr") val value: Double,
    @SerializedName("OP") val operation: Double,
    @SerializedName("OBS") val observation: String
)
