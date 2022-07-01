package co.dito.abako.apijitpack.data.model.request.delivery

import com.google.gson.annotations.SerializedName

data class LiquidationDetail(
    @SerializedName("IdTv") val idValueType: Double,
    @SerializedName("VC") val valueQuantity: Int,
)
