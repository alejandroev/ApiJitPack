package co.dito.abako.apijitpack.data.model.response.delivery

import co.dito.abako.apijitpack.data.model.response.general.MessageResponseOld
import com.google.gson.annotations.SerializedName

data class GpsTourResponse(
    @SerializedName("Estado") val state: MessageResponseOld,
    @SerializedName("MsgId") val idMessage: Int,
    @SerializedName("MsgStr") val Message: String
)
