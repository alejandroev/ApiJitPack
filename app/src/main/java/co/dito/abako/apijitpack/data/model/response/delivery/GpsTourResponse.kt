package co.dito.abako.apijitpack.data.model.response.delivery

import co.dito.abako.apijitpack.data.model.response.general.MessageResponse
import com.google.gson.annotations.SerializedName

data class GpsTourResponse(
    @SerializedName("estado") val state: MessageResponse,
    @SerializedName("msgId") val msgId: Int,
    @SerializedName("msgStr") val msgStr: String,
)
