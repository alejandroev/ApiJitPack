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
    @SerializedName("idArt") val idArticle: Int,
    @SerializedName("codArt") val codArt: String,
    @SerializedName("art") val art: String,
    @SerializedName("idMc") val idMc: Int,
    @SerializedName("idCt") val idCt: Int,
    @SerializedName("iva") val iva: Double,
    @SerializedName("dsct") val dsct: Double,
    @SerializedName("otImp") val otImp: Double,
    @SerializedName("otImpPorc") val otImpPorc: Double,
    @SerializedName("emb") val emb: Double,
    @SerializedName("car") val car: String?,
    @SerializedName("img") val img: String?,
    @SerializedName("ean") val ean: String?,
    @SerializedName("idDto") val idDto: Double,
    @SerializedName("prcs") val prcs: String?,
)