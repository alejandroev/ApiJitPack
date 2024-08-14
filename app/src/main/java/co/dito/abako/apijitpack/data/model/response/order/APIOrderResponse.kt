package co.dito.abako.apijitpack.data.model.response.order

import co.dito.abako.apijitpack.data.model.response.general.MessageResponse
import com.google.gson.annotations.SerializedName

data class APIOrderResponse(
    @SerializedName("estado") val states: List<MessageResponse>,
    @SerializedName("idPed") val orderId: Int,
    @SerializedName("ped") val consecutive: Int
)
