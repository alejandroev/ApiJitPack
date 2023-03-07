package co.dito.abako.apijitpack.domain.order

import co.dito.abako.apijitpack.data.model.request.general.CancelDocumentRequest
import co.dito.abako.apijitpack.data.model.request.offer.VirtualOfferRequest
import co.dito.abako.apijitpack.data.model.request.order.APIOrderRequest
import co.dito.abako.apijitpack.data.model.request.report.DocumentReportRequest
import co.dito.abako.apijitpack.data.model.response.general.MessageResponse
import co.dito.abako.apijitpack.data.model.response.offer.VirtualOfferResponse
import co.dito.abako.apijitpack.data.model.response.order.APIOrderResponse
import co.dito.abako.apijitpack.data.model.response.report.DocumentReportResponse
import co.dito.abako.apijitpack.data.model.response.report.HistoryReportResponse
import kotlinx.coroutines.flow.Flow

interface OrderRepository {

    suspend fun virtualOfferValid(virtualOfferRequest: VirtualOfferRequest): Flow<VirtualOfferResponse>

    suspend fun insertOrder(apiOrderRequest: APIOrderRequest): Flow<APIOrderResponse>

    suspend fun fetchHistoryClient(
        documentReportRequest: DocumentReportRequest
    ): Flow<HistoryReportResponse?>

    suspend fun cancelDocumentResponse(
        cancelDocumentRequest: CancelDocumentRequest
    ): Flow<MessageResponse>
}