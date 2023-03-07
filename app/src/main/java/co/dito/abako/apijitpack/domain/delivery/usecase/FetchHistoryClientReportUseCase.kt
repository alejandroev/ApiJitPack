package co.dito.abako.apijitpack.domain.delivery.usecase

import co.dito.abako.apijitpack.data.model.request.report.DocumentReportRequest
import co.dito.abako.apijitpack.data.model.response.report.HistoryReportResponse
import co.dito.abako.apijitpack.domain.order.OrderRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class FetchHistoryClientReportUseCase @Inject constructor(
    private val orderRepository: OrderRepository
) {

    suspend operator fun invoke(documentReportRequest: DocumentReportRequest) : Flow<HistoryReportResponse?> =
        orderRepository.fetchHistoryClient(documentReportRequest)
}