package co.dito.abako.apijitpack.data.model.request.delivery

import com.google.gson.annotations.SerializedName

data class DeliveryLiquidationRequest(
    @SerializedName("Id") val idLiquidation: Double,
    @SerializedName("DllLiq") val liquidationDetail: List<LiquidationDetail>,
    @SerializedName("DllOc") val otherCharges: List<OtherChargesDetail>
)
