package co.dito.abako.apijitpack.data.model.response.order

import com.google.gson.annotations.SerializedName

data class FollowUpOrderResponse(
    @SerializedName("orden") val order: Int,
    @SerializedName("tipo") val type: String,
    @SerializedName("id") val orderId: Int,
    @SerializedName("documento") val orderConsecutive: Int,
    @SerializedName("fecha") val creationDate: String,
    @SerializedName("observacion") val observation: String
)