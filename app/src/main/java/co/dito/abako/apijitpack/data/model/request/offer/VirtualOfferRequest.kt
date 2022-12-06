package co.dito.abako.apijitpack.data.model.request.offer

import co.dito.abako.apijitpack.data.common.converters.DateJsonSerialize
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import java.util.Date

data class VirtualOfferRequest(
    @SerializedName("idEmpresa") val companyId: Int,
    @SerializedName("idListaPrecios") val priceListId: Int,
    @SerializedName("idUsuario") val userId: Int,
    @JsonAdapter(DateJsonSerialize::class) @SerializedName("fecha") val date: Date,
    @SerializedName("dll") val virtualOfferDetailsRequest: List<VirtualOfferDetailRequest>
)

data class VirtualOfferDetailRequest(
    @SerializedName("idArticulo") val articleId: Int,
    @SerializedName("cantidad") val quantity: Double,
    @SerializedName("siglaUM") val metricUnit: String,
    @SerializedName("valor") val value: Double
)
