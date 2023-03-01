package co.dito.abako.apijitpack.data.model.response.article

import co.dito.abako.apijitpack.data.model.response.category.APICategoryResponse
import co.dito.abako.apijitpack.data.model.response.general.APICleanResponse
import co.dito.abako.apijitpack.data.model.response.inventory.APIInventoryResponse
import co.dito.abako.apijitpack.data.model.response.line.APILineResponse
import co.dito.abako.apijitpack.data.model.response.price.APIMetricUnitResponse
import co.dito.abako.apijitpack.data.model.response.price.APIPriceArticleResponse
import com.fasterxml.jackson.annotation.JsonIgnore
import com.google.gson.annotations.SerializedName

data class APIArticleMasterResponse(
    @SerializedName("articulos") val articlesResponse: List<APIArticleResponse>,
    @SerializedName("borrado") val cleansResponse: List<APICleanResponse>,
    @SerializedName("lineas") val lines: List<APILineResponse>,
    @SerializedName("categorias") val categories: List<APICategoryResponse>,
    @JsonIgnore val pricesDetail: List<APIPriceArticleResponse> = emptyList(),
    @JsonIgnore val metricUnits: List<APIMetricUnitResponse> = emptyList(),
    @JsonIgnore val inventories: List<APIInventoryResponse> = emptyList()
)
