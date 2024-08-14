package co.dito.abako.apijitpack.data.model.response.delivery

import com.google.gson.annotations.SerializedName

/**
 * @param idOtherChange = ID of other charges
 * @param otherChange = Description
 */

data class OtherChargesSyncResponse(
    @SerializedName("idOC") val idOtherChange: Int,
    @SerializedName("oc") val otherChange: String,
)