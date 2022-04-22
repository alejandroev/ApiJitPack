package co.dito.abako.apijitpack.data.model.response.delivery

import com.google.gson.annotations.SerializedName

/**
 * @param idMot = Id of Reason
     * @param mot = Description of the reason
 */

data class ReasonSyncResponse(
    @SerializedName("IdMot") val idMot: Int,
    @SerializedName("Mot") val mot: String,
)
