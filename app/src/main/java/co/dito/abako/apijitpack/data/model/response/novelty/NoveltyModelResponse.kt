package co.dito.abako.apijitpack.data.model.response.novelty

import com.google.gson.annotations.SerializedName

data class NoveltyModelResponse(
    @SerializedName("novedades") var novedades: List<NoveltyModel> = emptyList(),
    @SerializedName("msgId") var msgId: Int = 0,
)

data class NoveltyModel(
    @SerializedName("idnv") val idnv: Int = 0,
    @SerializedName("nv") val nv: String = "",
    @SerializedName("tp") val tp: Int = 0,
    @SerializedName("ac") val ac: String = "",
)