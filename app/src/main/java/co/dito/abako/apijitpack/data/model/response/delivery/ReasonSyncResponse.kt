package co.dito.abako.apijitpack.data.model.response.delivery

import com.google.gson.annotations.SerializedName

/**
 * @param idReasonReturn = Id of Reason
     * @param reasonReturn = Description of the reason
 */

data class ReasonSyncResponse(
    @SerializedName("idMot") val idReasonReturn: Int,
    @SerializedName("mot") val reasonReturn: String,
)
