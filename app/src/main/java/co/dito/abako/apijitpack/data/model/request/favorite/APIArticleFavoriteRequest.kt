package co.dito.abako.apijitpack.data.model.request.favorite

import co.dito.abako.apijitpack.data.model.response.favorite.APIDetailFavoriteRequestResponse
import com.google.gson.annotations.SerializedName

data class APIArticleFavoriteRequest(
    @SerializedName("esTodo") val isAll : String,
    @SerializedName("fecha") val date: String,
    @SerializedName("agencia") val agency: String,
    @SerializedName("idEmpresa") val personId: Int,
    @SerializedName("articulos") val articles: List<APIDetailFavoriteRequestResponse>
)