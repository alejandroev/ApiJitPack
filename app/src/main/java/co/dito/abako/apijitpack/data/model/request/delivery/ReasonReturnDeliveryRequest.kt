package co.dito.abako.apijitpack.data.model.request.delivery

import co.dito.abako.apijitpack.data.common.converters.DateTimeJsonSerialize
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * @param idPerson = ID of the person logged in
 * @param date = Date of the last synchronization
 * @param isAll = General synchronization S otherwise N
 */

data class ReasonReturnDeliveryRequest(
    @SerializedName("IdPersona") val idPerson: Int,
    @JsonAdapter(DateTimeJsonSerialize::class) @SerializedName("FechaUltimaSincronizacion") val date: Date,
    @SerializedName("EsTodo") val isAll: String,
)
