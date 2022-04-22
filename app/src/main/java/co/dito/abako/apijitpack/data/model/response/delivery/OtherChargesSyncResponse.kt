package co.dito.abako.apijitpack.data.model.response.delivery

import com.google.gson.annotations.SerializedName

/**
 * @param idOC = ID of other charges
 * @param oc = Description
 */

data class OtherChargesSyncResponse(
    @SerializedName("IdOC") val idOC: Int,
    @SerializedName("Oc") val oc: String,
)