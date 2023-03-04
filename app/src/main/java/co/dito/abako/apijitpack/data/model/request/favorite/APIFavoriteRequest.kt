package co.dito.abako.apijitpack.data.model.request.favorite

import co.dito.abako.apijitpack.data.model.response.favorite.APIDetailFavoriteRequestResponse
import com.google.gson.annotations.SerializedName

data class APIFavoriteRequest(
    @SerializedName("proceso") val process : FavoriteRequestType,
    @SerializedName("idPersona") val personId: Int,
    @SerializedName("dllFavorito") val favorites: List<APIDetailFavoriteRequestResponse> = emptyList()
)

enum class FavoriteRequestType {
    NEW,
    GET,
    DEL
}
