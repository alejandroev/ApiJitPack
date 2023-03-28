package co.dito.abako.apijitpack.data.model.response.report

import com.fasterxml.jackson.annotation.JsonProperty

data class APIHistoryReportResponse(
    val header: List<APIHistoryHeaderResponse> = emptyList(),
    val details: List<APIHistoryDetailResponse> = emptyList()
)

data class APIHistoryHeaderMasterResponse(
    @JsonProperty("Encabezado") val header: List<APIHistoryHeaderResponse>
)

data class APIHistoryHeaderResponse(
    @JsonProperty("Pedido") val orderConsecutive: Int,
    @JsonProperty("Fecha") val creationDate: String,
    @JsonProperty("Asesor") val adviserName: String,
    @JsonProperty("Total") val total: Double,
    @JsonProperty("Impuestos") val taxes: Double,
    @JsonProperty("IdpedidoVenta") val orderId: Int,
    @JsonProperty("Estado") val state: String
)

data class APIHistoryDetailMasterResponse(
    @JsonProperty("DetalleFactura") val details: List<APIHistoryDetailResponse>
)

data class APIHistoryDetailResponse(
    @JsonProperty("IdpedidoVenta") val orderId: Int,
    @JsonProperty("Codigo") val articleCode: String,
    @JsonProperty("Descripcion") val articleDescription: String,
    @JsonProperty("Cantidad") val quantity: Double,
    @JsonProperty("UM") val metricUnitCode: String,
    @JsonProperty("Precio") val price: Double,
    @JsonProperty("SubTotal") val subtotal: Double,
    @JsonProperty("Impuestos") val taxes: Double,
    @JsonProperty("imagen") val articleImage: String?,
)
