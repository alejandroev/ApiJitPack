package co.dito.abako.apijitpack.data.model.response.delivery

import co.dito.abako.apijitpack.data.model.response.general.MessageResponseOld
import com.google.gson.annotations.SerializedName

data class ReasonReturnDeliveryResponse(
    @SerializedName("Motivos") val reasons: List<ReasonSyncResponse>,
) : MessageResponseOld()
