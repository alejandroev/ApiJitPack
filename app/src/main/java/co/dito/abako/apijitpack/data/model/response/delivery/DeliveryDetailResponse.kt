package co.dito.abako.apijitpack.data.model.response.delivery

import co.dito.abako.apijitpack.data.model.response.general.MessageResponseOld
import com.google.gson.annotations.SerializedName

/**
 * @param deliveryDetail = List of deliveries
 */

data class DeliveryDetailResponse(
    @SerializedName("EntregaDetalle") val deliveryDetail: DeliveryDetailSyncResponse
) : MessageResponseOld()
