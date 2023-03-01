package co.dito.abako.apijitpack.data.model.response.price

import com.google.gson.annotations.SerializedName

data class APIPriceMasterResponse(
    @SerializedName("detallePrecios") val pricesDetail: List<APIPriceArticleResponse> = emptyList(),
    @SerializedName("unidadMetrica") val metricUnits: List<APIMetricUnitResponse> = emptyList()
)
