package co.dito.abako.apijitpack.domain.delivery.usecase

import co.dito.abako.apijitpack.data.model.request.report.DocumentReportRequest
import co.dito.abako.apijitpack.data.model.response.report.DocumentReportResponse
import co.dito.abako.apijitpack.domain.general.GeneralRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetReportDocumentResponseUseCase @Inject constructor(
    private val generalRepository: GeneralRepository
) {

    suspend operator fun invoke(documentReportRequest: DocumentReportRequest) : Flow<DocumentReportResponse> =
        generalRepository.reportDocument(documentReportRequest)
}