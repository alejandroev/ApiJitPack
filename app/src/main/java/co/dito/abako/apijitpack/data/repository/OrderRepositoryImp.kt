package co.dito.abako.apijitpack.data.repository

import co.dito.abako.apijitpack.data.common.utils.BackEndException
import co.dito.abako.apijitpack.data.model.request.general.CancelDocumentRequest
import co.dito.abako.apijitpack.data.model.request.offer.VirtualOfferRequest
import co.dito.abako.apijitpack.data.model.request.order.APIOrderRequest
import co.dito.abako.apijitpack.data.model.request.order.FollowUpOrderRequest
import co.dito.abako.apijitpack.data.model.request.report.DocumentReportRequest
import co.dito.abako.apijitpack.data.model.response.general.MessageResponse
import co.dito.abako.apijitpack.data.model.response.offer.VirtualOfferResponse
import co.dito.abako.apijitpack.data.model.response.order.APIOrderResponse
import co.dito.abako.apijitpack.data.model.response.order.FollowUpOrderResponse
import co.dito.abako.apijitpack.data.model.response.report.APIHistoryDetailMasterResponse
import co.dito.abako.apijitpack.data.model.response.report.APIHistoryHeaderMasterResponse
import co.dito.abako.apijitpack.data.model.response.report.APIHistoryReportResponse
import co.dito.abako.apijitpack.data.model.response.report.mapper
import co.dito.abako.apijitpack.data.network.OrderMobileApiService
import co.dito.abako.apijitpack.data.network.validResponse
import co.dito.abako.apijitpack.domain.order.OrderRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class OrderRepositoryImp @Inject constructor(
    private val orderMobileApiService: OrderMobileApiService
) : OrderRepository {

    override suspend fun virtualOfferValid(virtualOfferRequest: VirtualOfferRequest): Flow<VirtualOfferResponse> {
        val response = orderMobileApiService.virtualOfferValid(virtualOfferRequest)
        response.message.validResponse()

        return flow {
            emit(response)
        }
    }

    override suspend fun insertOrder(apiOrderRequest: APIOrderRequest): Flow<APIOrderResponse> = flow {
        val response = orderMobileApiService.insertOrder(apiOrderRequest)
        response.states.forEach { it.validResponse() }
        emit(response)
    }

    override suspend fun cancelDocumentResponse(cancelDocumentRequest: CancelDocumentRequest): Flow<MessageResponse> {
        val response = orderMobileApiService.cancelDocument(cancelDocumentRequest)

        response.validResponse()
        return flow {
            emit(response)
        }
    }

    override suspend fun followUp(followUpOrderRequest: FollowUpOrderRequest): Flow<List<FollowUpOrderResponse>> = flow {
        val response = orderMobileApiService.followUpOrder(followUpOrderRequest)
        if (response.isNullOrEmpty()) {
            throw BackEndException("No se encontraron datos de seguimiento del pedido")
        }

        emit(response)
    }

    override suspend fun fetchHistoryClient(documentReportRequest: DocumentReportRequest): Flow<APIHistoryReportResponse?> = flow {
        val response = orderMobileApiService.getReportDocument(documentReportRequest)
        response.validResponse()
        if (response.header.isEmpty()) {
            emit(null)
            return@flow
        }

        val header = "<Encabezado>${response.header}</Encabezado>".mapper(APIHistoryHeaderMasterResponse::class.java)
        val detail = response.detail.mapper(APIHistoryDetailMasterResponse::class.java)
        emit(
            APIHistoryReportResponse(
                header = header.header,
                details = detail.details
            )
        )
    }

}