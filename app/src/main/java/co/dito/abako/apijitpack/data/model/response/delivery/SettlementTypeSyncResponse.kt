package co.dito.abako.apijitpack.data.model.response.delivery

import com.google.gson.annotations.SerializedName

/**
 * @param idTv = ID of value type
 * @param denm = Denomination
 * @param tp = Type
 * @param vr = Value
 */

data class SettlementTypeSyncResponse(
    @SerializedName("IdTv") val idTv: Int,
    @SerializedName("Denm") val denm: String,
    @SerializedName("Tp") val tp: String,
    @SerializedName("Vr") val vr: Int,
)
