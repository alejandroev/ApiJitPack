package co.dito.abako.apijitpack.data.model.response.general

import com.google.gson.annotations.SerializedName

data class ExchangeRateSyncResponse(
    @SerializedName("moneda") val money: String,
    @SerializedName("sigla") val initials: String,
    @SerializedName("valor") val value: Double,
)