package co.dito.abako.apijitpack.data.model.response.article

import com.google.gson.annotations.SerializedName

/**
 * @param idArticle = ID of article
 * @param codArt = Code of article
 * @param art = Name of article
 * @param idMc = ID of mark
 * @param idCt = ID of category
 * @param iva = vat percentage
 * @param dsct = Discount rate
 * @param otImp = Other taxes
 * @param emb = packaging
 * @param car = features
 * @param img = Image of article
 * @param prcs = Process
 */

data class ArticleSyncResponse(
    @SerializedName("IdArt") val idArticle: Int,
    @SerializedName("CodArt") val codArt: String,
    @SerializedName("Art") val art: String,
    @SerializedName("IdMc") val idMc: Int,
    @SerializedName("IdCt") val idCt: Int,
    @SerializedName("IVA") val iva: Double,
    @SerializedName("Dsct") val dsct: Double,
    @SerializedName("OtImp") val otImp: Double,
    @SerializedName("Emb") val emb: Double,
    @SerializedName("Car") val car: String?,
    @SerializedName("Img") val img: String?,
    @SerializedName("Prcs") val prcs: String?,
)