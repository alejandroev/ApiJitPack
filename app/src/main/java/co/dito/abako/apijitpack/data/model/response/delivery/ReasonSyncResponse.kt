package co.dito.abako.apijitpack.data.model.response.delivery

import com.google.gson.annotations.SerializedName

/**
 * @param idReasonReturn = Id of Reason
     * @param reasonReturn = Description of the reason
 */

data class ReasonSyncResponse(
    @SerializedName("IdMot") val idReasonReturn: Int,
    @SerializedName("Mot") val reasonReturn: String,
)
