package co.dito.abako.apijitpack.data.model.response.client

import co.dito.abako.apijitpack.data.common.converters.DateJsonDeserializeOld
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * @param idEmp = ID of client
 * @param rzScl = Business name
 * @param nmbCmn = Common name
 * @param idNt = Identification number
 * @param cod = Code of client
 * @param idCnl = ID of channel
 * @param idSeg = ID follow-up
 * @param idZn = ID zone
 * @param idLp = ID price list
 * @param lon = Longitude
 * @param lat = Latitude
 * @param fp = Payment method 1 = Counted, 2 = Credit
 * @param cp = Quota
 * @param vncmnt = Number of days due
 * @param frc = Frequency
 * @param ini = Start
 * @param fcIni = Start date
 * @param ultVt = Last sale date
 * @param fchltmpg = Last payment date
 * @param ultmpg = Last payment
 * @param prcs = Process
 */

data class ClientSyncResponse(
    @SerializedName("IdEmp") val idEmp: Int,
    @SerializedName("RzScl") val rzScl: String,
    @SerializedName("NmbCmn") val nmbCmn: String,
    @SerializedName("Idnt") val idNt: String,
    @SerializedName("Cod") val cod: String,
    @SerializedName("IdCnl") val idCnl: Int,
    @SerializedName("IdSeg") val idSeg: Int,
    @SerializedName("IdZn") val idZn: Int,
    @SerializedName("IdLP") val idLp: Int,
    @SerializedName("Lon") val lon: Double,
    @SerializedName("Lat") val lat: Double,
    @SerializedName("FP") val fp: Int,
    @SerializedName("CP") val cp: Double,
    @SerializedName("Vncmnt") val vncmnt: Int,
    @SerializedName("Frc") val frc: Int,
    @SerializedName("Ini") val ini: Int,
    @JsonAdapter(DateJsonDeserializeOld::class) @SerializedName("FcIni") val fcIni: Date,
    @JsonAdapter(DateJsonDeserializeOld::class) @SerializedName("UltVt") val ultVt: Date,
    @JsonAdapter(DateJsonDeserializeOld::class) @SerializedName("Fchltmpg") val fchltmpg: Date,
    @SerializedName("ultmpg") val ultmpg: Double,
    @SerializedName("Prcs") val prcs: String,
)