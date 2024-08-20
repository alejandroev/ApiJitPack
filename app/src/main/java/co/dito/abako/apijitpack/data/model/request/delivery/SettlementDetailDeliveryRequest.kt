package co.dito.abako.apijitpack.data.model.request.delivery

import com.google.gson.annotations.SerializedName

data class SettlementDetailDeliveryRequest(
    @SerializedName("idTv") val idValueType: Int,
    @SerializedName("vc") val valueQuantity: Int,
)
