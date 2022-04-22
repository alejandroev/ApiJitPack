package co.dito.abako.apijitpack.data.model.request.delivery

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * @param idPerson = ID of the person logged in
 * @param date = Date of the last synchronization
 * @param isAll = General synchronization S otherwise N
 */

data class ReasonReturnDeliveryRequest(
    @SerializedName("IdPersona") val idPerson: Int,
    @SerializedName("FechaUltimaSincronizacion") val date: Date,
    @SerializedName("EsTodo") val isAll: String,
)
