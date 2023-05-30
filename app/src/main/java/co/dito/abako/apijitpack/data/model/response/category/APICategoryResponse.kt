package co.dito.abako.apijitpack.data.model.response.category

import com.google.gson.annotations.SerializedName

data class APICategoryResponse(
    @SerializedName("idCt") val categoryId: Int,
    @SerializedName("ct") val category: String,
    @SerializedName("img") val categoryImage: String?,
    @SerializedName( "idLn") val lineId: Int,
)