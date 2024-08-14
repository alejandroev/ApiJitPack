package co.dito.abako.apijitpack.data.model.response.favorite

import com.google.gson.annotations.SerializedName

data class APIDetailFavoriteRequestResponse(
    @SerializedName("idArticulo") val articleId: Int
)
