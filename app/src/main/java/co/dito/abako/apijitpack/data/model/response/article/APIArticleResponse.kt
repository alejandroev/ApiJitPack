package co.dito.abako.apijitpack.data.model.response.article

import com.google.gson.annotations.SerializedName

data class APIArticleResponse(
    @SerializedName("idArt") val articleId: Int,
    @SerializedName("codArt") val articleCode: String,
    @SerializedName("art") val articleDescription: String,
    @SerializedName("idMc") val brandId: Int,
    @SerializedName("idCt") val categoryId: Int,
    @SerializedName("iva") val iva: Double,
    @SerializedName("dsct") val discountPercentage: Double,
    @SerializedName("otImp") val otherTaxes: Double,
    @SerializedName("emb") val packaging: Double,
    @SerializedName("imgFir") val articleImageURL: String?,
    @SerializedName("rtng") val rtng: Int?,
    @SerializedName("insig") val insig: String?,
    @SerializedName("idDto") val idDto: Int?,
    @SerializedName("prcs") val processType: String?
)