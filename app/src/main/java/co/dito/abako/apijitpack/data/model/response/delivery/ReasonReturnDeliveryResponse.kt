package co.dito.abako.apijitpack.data.model.response.delivery

import co.dito.abako.apijitpack.data.model.response.general.MessageResponseOld
import com.google.gson.annotations.SerializedName

/**
 * @param reasons = reasons for the return de order
 */

data class ReasonReturnDeliveryResponse(
    @SerializedName("Motivos") val reasons: List<ReasonSyncResponse>,
) : MessageResponseOld()
