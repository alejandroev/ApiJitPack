package co.dito.abako.apijitpack.data.model.request.delivery

import com.google.gson.annotations.SerializedName

data class SettlementDeliveryRequest(
    @SerializedName("Id") val deliveryId: Int,
    @SerializedName("DllLiq") val settlementDetail: List<SettlementDetailDeliveryRequest>,
    @SerializedName("DllOc") val otherCharges: List<OtherChargesDetail>
)
