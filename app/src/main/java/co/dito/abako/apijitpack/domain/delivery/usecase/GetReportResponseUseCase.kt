package co.dito.abako.apijitpack.domain.delivery.usecase

import co.dito.abako.apijitpack.data.model.request.report.DocumentReportRequest
import co.dito.abako.apijitpack.data.model.response.report.Resultado
import co.dito.abako.apijitpack.domain.general.GeneralBackupRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetReportResponseUseCase @Inject constructor(
    private val generalBackupRepository: GeneralBackupRepository
) {
    suspend operator fun invoke(documentReportRequest: DocumentReportRequest): Flow<Resultado> =
        generalBackupRepository.reportResponse(documentReportRequest)
}