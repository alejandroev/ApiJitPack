package co.dito.abako.apijitpack.data.model.response.article

import co.dito.abako.apijitpack.data.model.response.inventory.APIInventoryResponse
import co.dito.abako.apijitpack.data.model.response.price.APIMetricUnitResponse
import co.dito.abako.apijitpack.data.model.response.price.APIPriceArticleResponse
import com.google.gson.annotations.SerializedName

data class APIPromotionArticleResponse(
    @SerializedName("articulos") val articles: List<APIArticleResponse> = emptyList(),
    @SerializedName("detallePrecios") val pricesDetail: List<APIPriceArticleResponse> = emptyList(),
    @SerializedName("unidadMetrica") val metricUnits: List<APIMetricUnitResponse> = emptyList(),
    val inventory: List<APIInventoryResponse> = emptyList()
)
