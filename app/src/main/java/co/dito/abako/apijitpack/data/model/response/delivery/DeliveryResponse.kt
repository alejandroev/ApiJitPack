package co.dito.abako.apijitpack.data.model.response.delivery

import co.dito.abako.apijitpack.data.model.response.general.MessageResponseOld
import com.google.gson.annotations.SerializedName

/**
 * @param deliveries List of deliveries
 */

data class DeliveryResponse(
    @SerializedName("Entregas") val deliveries: List<DeliverySyncResponse> = emptyList()
) : MessageResponseOld()