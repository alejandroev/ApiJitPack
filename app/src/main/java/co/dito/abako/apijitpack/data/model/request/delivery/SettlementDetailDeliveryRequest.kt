package co.dito.abako.apijitpack.data.model.request.delivery

import com.google.gson.annotations.SerializedName

data class SettlementDetailDeliveryRequest(
    @SerializedName("IdTv") val idValueType: Int,
    @SerializedName("VC") val valueQuantity: Int,
)
