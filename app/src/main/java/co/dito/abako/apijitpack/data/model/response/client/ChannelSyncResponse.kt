package co.dito.abako.apijitpack.data.model.response.client

import com.google.gson.annotations.SerializedName

/**
 * @param idCnl = Id of channel
 * @param cnl = Description of channel
 */

data class ChannelSyncResponse(
    @SerializedName("IdCnl") val idCnl: Int,
    @SerializedName("Cnl") val cnl: String,
)