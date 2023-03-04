package co.dito.abako.apijitpack.data.model.response.favorite

import co.dito.abako.apijitpack.data.model.response.general.MessageResponse
import com.google.gson.annotations.SerializedName

data class APIFavoriteResponse(
    @SerializedName("mensaje") val message: MessageResponse,
    @SerializedName("favoritos") val favorites: List<APIDetailFavoriteRequestResponse>
)
