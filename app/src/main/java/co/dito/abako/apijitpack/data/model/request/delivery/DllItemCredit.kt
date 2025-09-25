package co.dito.abako.abako.abako.data.model

import com.google.gson.annotations.SerializedName

data class DllItemCredit(
@SerializedName("idArt") val idArt: Int = 0,
@SerializedName("cant") val cant: Int = 0,
@SerializedName("prcs") val prcs: String = ""
)
