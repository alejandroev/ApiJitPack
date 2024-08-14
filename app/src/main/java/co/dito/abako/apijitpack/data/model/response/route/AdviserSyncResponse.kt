package co.dito.abako.apijitpack.data.model.response.route

import com.google.gson.annotations.SerializedName

/**
 * @param idAssr = ID of adviser
 * @param assr = Adviser first and last name
 * @param tlAssr = Telephone of adviser
 */

data class AdviserSyncResponse(
    @SerializedName("idAssr") val idAssr: Int,
    @SerializedName("assr") val assr: String,
    @SerializedName("tlAssr") val tlAssr: String
)