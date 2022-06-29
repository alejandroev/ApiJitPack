package co.dito.abako.apijitpack.data.model.request.delivery

import co.dito.abako.apijitpack.data.common.converters.DateJsonSerialize
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import java.util.Date

/**
 * @param idVnt = Id of sales
 * @param idPed = Id of order
 * @param idMot = Id of reason return
 * @param obs = Observation
 * @param fc = Creation date
 * @param usr = Id of user
 * @param lon = Longitude
 * @param lat = Latitude
 * @param rfv = Validation reference
 * @param dlls = List of articles to return
 */

data class SetCreditNoteRequest(
    @SerializedName("IdVnt") val idVnt: Int,
    @SerializedName("IdPed") val idPed: Int,
    @SerializedName("IdMot") val idMot: Int,
    @SerializedName("Obs") val obs: String,
    @JsonAdapter(DateJsonSerialize::class) @SerializedName("fc") val fc: Date,
    @SerializedName("Usr") val usr: Int,
    @SerializedName("Lon") val lon: Double,
    @SerializedName("Lat") val lat: Double,
    @SerializedName("Rfv") val rfv: String,
    @SerializedName("Dll") val dlls: List<SetCreditNoteDetailRequest>,
)