package co.dito.abako.apijitpack.data.model.response.delivery

import com.google.gson.annotations.SerializedName

/**
 * @param idOtherChange = ID of other charges
 * @param otherChange = Description
 */

data class OtherChargesSyncResponse(
    @SerializedName("IdOC") val idOtherChange: Int,
    @SerializedName("Oc") val otherChange: String,
)