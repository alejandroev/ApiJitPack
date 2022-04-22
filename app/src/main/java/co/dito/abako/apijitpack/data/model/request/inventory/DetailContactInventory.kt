package co.dito.abako.apijitpack.data.model.request.inventory

import com.google.gson.annotations.SerializedName

data class DetailContactInventory(
    @SerializedName("idArticulo") val idArticle: Int,
    @SerializedName("conteo") val count: Int
)
