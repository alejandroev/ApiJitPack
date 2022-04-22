package co.dito.abako.apijitpack.data.model.response.client

import com.google.gson.annotations.SerializedName

/**
 * @param idZn = ID of zone
 * @param zn = Description of zone
 */
data class ZoneSyncResponse(
    @SerializedName("IdZn") val idZn: Int,
    @SerializedName("Zn") val zn: String,
)