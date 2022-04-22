package co.dito.abako.apijitpack.data.model.request.delivery

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * @param date = Date of the last synchronization
 * @param idPerson = ID of the person logged in
 * @param isAll = General synchronization S otherwise N
 */
data class MasterDeliveryRequest(
    @SerializedName("Fecha") val date: Date,
    @SerializedName("IdPersona") val idPerson: Int,
    @SerializedName("EsTodo") val isAll: String,
)
