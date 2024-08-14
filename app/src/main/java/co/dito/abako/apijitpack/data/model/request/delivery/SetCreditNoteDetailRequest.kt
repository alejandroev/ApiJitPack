package co.dito.abako.apijitpack.data.model.request.delivery

import com.google.gson.annotations.SerializedName

/**
 * @param idArticle = Id of Article
 * @param quantity = Quantity to return
 */

data class SetCreditNoteDetailRequest(
    @SerializedName("IdArt") val idArticle: Int,
    @SerializedName("Cant") val quantity: Double,
    @SerializedName("prcs") val prcs: String = "0"
)
