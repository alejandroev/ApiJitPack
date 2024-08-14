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
    @SerializedName("idEmp") val idEmp: Int,
    @SerializedName("rzScl") val rzScl: String,
    @SerializedName("nmbCmn") val nmbCmn: String,
    @SerializedName("idnt") val idNt: String,
    @SerializedName("cod") val cod: String,
    @SerializedName("idCnl") val idCnl: Int,
    @SerializedName("idSeg") val idSeg: Int,
    @SerializedName("idZn") val idZn: Int,
    @SerializedName("idLP") val idLp: Int,
    @SerializedName("lon") val lon: Double,
    @SerializedName("lat") val lat: Double,
    @SerializedName("fp") val fp: Int,
    @SerializedName("cp") val cp: Double,
    @SerializedName("vncmnt") val vncmnt: Int,
    @SerializedName("frc") val frc: Int,
    @SerializedName("ini") val ini: Int,
    @JsonAdapter(DateJsonDeserializeOld::class) @SerializedName("fcIni") val fcIni: Date,
    @JsonAdapter(DateJsonDeserializeOld::class) @SerializedName("ultVt") val ultVt: Date,
    @JsonAdapter(DateJsonDeserializeOld::class) @SerializedName("fchltmpg") val fchltmpg: Date,
    @SerializedName("ultmpg") val ultmpg: Double,
    @SerializedName("abkClnt") val abkClnt: Boolean,
    @SerializedName("prcs") val prcs: String,
)