package co.dito.abako.apijitpack.data.model.response.client

import com.google.gson.annotations.SerializedName

/**
 * @param idZn = ID of zone
 * @param zn = Description of zone
 */
data class ZoneSyncResponse(
    @SerializedName("idZn") val idZn: Int,
    @SerializedName("zn") val zn: String,
)