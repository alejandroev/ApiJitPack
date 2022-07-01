package co.dito.abako.apijitpack.data.model.request.delivery

import co.dito.abako.apijitpack.data.common.converters.DateJsonSerializeOld
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * @param idDelivery = ID of the delivery
 * @param date = Date of the last synchronization
 * @param idPerson = ID of the person logged in
 */

data class DeliveryDetailRequest(
    @SerializedName("IdEntrega") val idDelivery: Int,
    @JsonAdapter(DateJsonSerializeOld::class) @SerializedName("Fecha") val date: Date,
    @SerializedName("IdPersona") val idPerson: Int
)
