package co.dito.abako.apijitpack.data.model.response.offer

import co.dito.abako.apijitpack.data.model.response.general.MessageResponse
import com.google.gson.annotations.SerializedName

data class VirtualOfferResponse(
    @SerializedName("mensaje") val message: MessageResponse,
    @SerializedName("ofertas") val offersResponse: List<OfferResponse>,
    @SerializedName("articulos") val articlesOffersResponse: List<ArticleOfferResponse>
)

data class OfferResponse(
    @SerializedName("id") val offerId: Int,
    @SerializedName("nombreOferta") val offerName: String,
    @SerializedName("tipoOtorga") val grantType: String,
    @SerializedName("cantidadOtorga") val grantQuantity: Double
)

data class ArticleOfferResponse(
    @SerializedName("id") val articleOfferId: Int,
    @SerializedName("idArticulo") val articleId: Int,
    @SerializedName("codigo") val code: String,
    @SerializedName("nombreArticulo") val articleName: String
)
