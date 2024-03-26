package co.dito.abako.apijitpack.data.model.response.offer

import co.dito.abako.apijitpack.data.model.response.general.MessageResponse
import com.google.gson.annotations.SerializedName

data class VirtualOfferResponse(
    @SerializedName("mensaje") val message: MessageResponse,
    @SerializedName("ofertas") val offersResponse: List<OfferResponse>,
    @SerializedName("articulos") val articlesOffersResponse: List<ArticleOfferResponse>,
    @SerializedName("articulosElegigos") val articlesSelectedResponse: List<ArticleSelectedResponse>
)

data class OfferResponse(
    @SerializedName("id") val offerId: Int,
    @SerializedName("nombreOferta") val offerName: String,
    @SerializedName("tipoOtorga") val grantType: String,
    @SerializedName("otorga") val otorga: Int,
    @SerializedName("cantidadOtorga") val grantQuantity: Double,
    @SerializedName("ofertasGanadas") val ofertasGanadas: Double
)

data class ArticleOfferResponse(
    @SerializedName("id") val articleOfferId: Int,
    @SerializedName("idArticulo") val articleId: Int,
    @SerializedName("codigo") val code: String,
    @SerializedName("nombreArticulo") val articleName: String
)

data class ArticleSelectedResponse(
    @SerializedName("id") val articleSelectedId: Int,
    @SerializedName("idArticulo") val articleId: Int
)
