package co.dito.abako.apijitpack.data.model.response.line

import co.dito.abako.apijitpack.data.model.response.category.APICategoryResponse
import com.google.gson.annotations.SerializedName

data class APILineResponse(
    @SerializedName("idLn") val lineId: Int,
    @SerializedName("ln") val line: String,
    @SerializedName("img") val lineImage: String?,
    @SerializedName("categorias") val categories: String,
    @SerializedName("listaCategorias") val categoriesList: List<APICategoryResponse>
)
