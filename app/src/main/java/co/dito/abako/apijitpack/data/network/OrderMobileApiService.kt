package co.dito.abako.apijitpack.data.network

import co.dito.abako.apijitpack.data.model.request.general.CancelDocumentRequest
import co.dito.abako.apijitpack.data.model.request.offer.VirtualOfferRequest
import co.dito.abako.apijitpack.data.model.request.order.APIOrderRequest
import co.dito.abako.apijitpack.data.model.request.order.FollowUpOrderRequest
import co.dito.abako.apijitpack.data.model.request.report.DocumentReportRequest
import co.dito.abako.apijitpack.data.model.response.general.MessageResponse
import co.dito.abako.apijitpack.data.model.response.offer.VirtualOfferResponse
import co.dito.abako.apijitpack.data.model.response.order.APIOrderResponse
import co.dito.abako.apijitpack.data.model.response.order.FollowUpOrderResponse
import co.dito.abako.apijitpack.data.model.response.report.DocumentReportResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface OrderMobileApiService {

    @POST("OfertasVirtuales/ValidarOferta")
    suspend fun virtualOfferValid(@Body virtualOfferRequest: VirtualOfferRequest): VirtualOfferResponse

    @POST("Pedidos/InsertarPedidoF000")
    suspend fun insertOrder(@Body apiOrderRequest: APIOrderRequest): APIOrderResponse

    @POST("OperacionesDocumentos/AnularDocumentos")
    suspend fun cancelDocument(@Body cancelDocumentRequest: CancelDocumentRequest): MessageResponse

    @POST("Informes/GetInformeDocumento")
    suspend fun getReportDocument(@Body documentReportRequest: DocumentReportRequest): DocumentReportResponse

    @POST("Pedidos/SeguimientoPedido")
    suspend fun followUpOrder(@Body followUpOrderRequest: FollowUpOrderRequest) : List<FollowUpOrderResponse>?
}