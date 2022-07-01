package co.dito.abako.apijitpack.data.model.request.delivery

import com.google.gson.annotations.SerializedName

data class SettlementDeliveryRequest(
    @SerializedName("Id") val idSettlement: Double,
    @SerializedName("DllLiq") val settlementDetail: List<SettlementDetail>,
    @SerializedName("DllOc") val otherCharges: List<OtherChargesDetail>
)
