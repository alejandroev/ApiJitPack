package co.dito.abako.apijitpack.data.model.request.delivery

import co.dito.abako.apijitpack.data.common.converters.DateJsonSerialize
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import java.util.Date

/**
 * @param date = Date of the last synchronization
 * @param idPerson = ID of the person logged in
 * @param isAll = General synchronization S otherwise N
 */
data class MasterDeliveryRequest(
    @JsonAdapter(DateJsonSerialize::class) @SerializedName("Fecha") val date: Date,
    @SerializedName("IdPersona") val idPerson: Int,
    @SerializedName("EsTodo") val isAll: String,
)
