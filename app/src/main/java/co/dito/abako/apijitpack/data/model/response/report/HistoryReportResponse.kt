package co.dito.abako.apijitpack.data.model.response.report

import com.fasterxml.jackson.annotation.JsonProperty

data class HistoryReportResponse(
    val header: List<HistoryHeaderResponse> = emptyList(),
    val details: List<HistoryDetailResponse> = emptyList()
)

data class HistoryHeaderMasterResponse(
    @JsonProperty("Encabezado") val header: List<HistoryHeaderResponse>
)

data class HistoryHeaderResponse(
    @JsonProperty("Pedido") val orderConsecutive: Int,
    @JsonProperty("Fecha") val creationDate: String,
    @JsonProperty("Asesor") val adviserName: String,
    @JsonProperty("Total") val total: Double,
    @JsonProperty("Impuestos") val taxes: Double,
    @JsonProperty("IdpedidoVenta") val orderId: Int,
    @JsonProperty("Estado") val state: String
)

data class HistoryDetailMasterResponse(
    @JsonProperty("DetalleFactura") val details: List<HistoryDetailResponse>
)

data class HistoryDetailResponse(
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
