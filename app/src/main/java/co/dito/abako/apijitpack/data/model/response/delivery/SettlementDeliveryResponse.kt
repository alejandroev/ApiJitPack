package co.dito.abako.apijitpack.data.model.response.delivery

import co.dito.abako.apijitpack.data.model.response.general.MessageResponseOld
import com.google.gson.annotations.SerializedName

data class SettlementDeliveryResponse(
    @SerializedName("Estado") val state: List<MessageResponseOld>,
    @SerializedName("MsgId") val idMessage: Int,
    @SerializedName("MsgStr") val message: String
)
