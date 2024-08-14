package co.dito.abako.apijitpack.data.model.response.delivery

import co.dito.abako.apijitpack.data.model.response.general.MessageResponse
import co.dito.abako.apijitpack.data.model.response.general.MessageResponseOld
import com.google.gson.annotations.SerializedName

/**
 * @param deliveries List of deliveries
 */

data class DeliveryResponse(
    @SerializedName("entregas") val deliveries: List<DeliverySyncResponse> = emptyList()
) : MessageResponse()