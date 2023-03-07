package co.dito.abako.apijitpack.domain.general

import co.dito.abako.apijitpack.data.common.WrappedResponse
import co.dito.abako.apijitpack.data.model.request.general.CancelDocumentRequest
import co.dito.abako.apijitpack.data.model.request.general.GpsTourRequest
import co.dito.abako.apijitpack.data.model.request.offer.VirtualOfferRequest
import co.dito.abako.apijitpack.data.model.request.report.DocumentReportRequest
import co.dito.abako.apijitpack.data.model.response.delivery.GpsTourResponse
import co.dito.abako.apijitpack.data.model.response.general.ExchangeRateSyncResponse
import co.dito.abako.apijitpack.data.model.response.general.MessageResponse
import co.dito.abako.apijitpack.data.model.response.offer.VirtualOfferResponse
import co.dito.abako.apijitpack.data.model.response.report.DocumentReportResponse
import co.dito.abako.apijitpack.data.model.response.report.ReportResponse
import co.dito.abako.apijitpack.data.model.response.report.Resultado
import co.dito.abako.apijitpack.domain.BaseResult
import kotlinx.coroutines.flow.Flow

interface GeneralRepository {

    suspend fun ping(
        url: String
    ): Flow<BaseResult<String, WrappedResponse<String>>>

    suspend fun getVirtualOfferResponse(
        virtualOfferRequest: VirtualOfferRequest
    ): Flow<VirtualOfferResponse>

    suspend fun fetchExchangeRate(): Flow<BaseResult<ExchangeRateSyncResponse, WrappedResponse<String>>>

    suspend fun gpsTourResponse(
        gpsTourRequest: GpsTourRequest
    ): Flow<GpsTourResponse>

    suspend fun reportDocument(
        documentReportRequest: DocumentReportRequest
    ): Flow<DocumentReportResponse>

    suspend fun reportResponse(
        documentReportRequest: DocumentReportRequest
    ): Flow<Resultado>
}
