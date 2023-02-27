package co.dito.abako.apijitpack.data.model.response.line

import com.google.gson.annotations.SerializedName

data class APILineResponse(
    @SerializedName("idLn") val lineId: Int,
    @SerializedName("ln") val line: String,
    @SerializedName("img") val lineImage: String,
    @SerializedName("categorias") val categories: String
)
