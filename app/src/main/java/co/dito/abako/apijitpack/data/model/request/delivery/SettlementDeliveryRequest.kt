package co.dito.abako.apijitpack.data.model.request.delivery

import com.google.gson.annotations.SerializedName

data class SettlementDeliveryRequest(
    @SerializedName("id") val deliveryId: Int,
    @SerializedName("dllLiq") val settlementDetail: List<SettlementDetailDeliveryRequest>,
    @SerializedName("dllOc") val otherCharges: List<OtherChargesDetail>
)
