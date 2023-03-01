package co.dito.abako.apijitpack.data.model.response.inventory

import com.google.gson.annotations.SerializedName

/**
 * Created by hans fritz ortega on 10/7/17.
 */

data class APIInventoryResponse(
    @SerializedName("idArt") val articleId: Int,
    @SerializedName("stk") val stock: Double,
    @SerializedName("tst") val tst: Int?,
    @SerializedName("pd") val pd: Int?,
    @SerializedName("agc") val agency: String,
)