package co.dito.abako.apijitpack.data.model.response.delivery

import com.google.gson.annotations.SerializedName

/**
 * @param idTv = ID of value type
 * @param denm = Denomination
 * @param tp = Type
 * @param vr = Value
 */

data class SettlementTypeSyncResponse(
    @SerializedName("idTv") val idTv: Int,
    @SerializedName("denm") val denm: String,
    @SerializedName("tp") val tp: String,
    @SerializedName("vr") val vr: Int,
)
