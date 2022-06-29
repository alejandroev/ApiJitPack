package co.dito.abako.apijitpack.data.model.request.delivery

import com.google.gson.annotations.SerializedName

/**
 * @param idArt = Id of Article
 * @param cant = Quantity to return
 */

data class SetCreditNoteDetailRequest(
    @SerializedName("IdArt") val idArt: Int,
    @SerializedName("Cant") val cant: Double
)
