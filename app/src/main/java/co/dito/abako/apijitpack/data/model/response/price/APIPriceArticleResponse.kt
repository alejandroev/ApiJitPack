package co.dito.abako.apijitpack.data.model.response.price

import com.google.gson.annotations.SerializedName

data class APIPriceArticleResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("idArt") val articleId: Int,
    @SerializedName("um") val metricUnit: String,
    @SerializedName("idLp") val priceListId: Int,
    @SerializedName("pv") val salePrice: Double,
    @SerializedName("conv") val conversion: Int,
    @SerializedName("ps") val subtotalPrice: Double
)
