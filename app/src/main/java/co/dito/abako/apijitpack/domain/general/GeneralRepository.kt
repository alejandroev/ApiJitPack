package co.dito.abako.apijitpack.domain.general

import co.dito.abako.apijitpack.data.common.WrappedResponse
import co.dito.abako.apijitpack.data.model.request.general.CancelDocumentRequest
import co.dito.abako.apijitpack.data.model.request.general.GpsTourRequest
import co.dito.abako.apijitpack.data.model.request.general.GpsTourRequestOld
import co.dito.abako.apijitpack.data.model.response.delivery.GpsTourResponse
import co.dito.abako.apijitpack.data.model.response.general.ExchangeRateSyncResponse
import co.dito.abako.apijitpack.data.model.response.general.MessageResponse
import co.dito.abako.apijitpack.domain.BaseResult
import kotlinx.coroutines.flow.Flow

interface GeneralRepository {

    suspend fun ping(
        url: String
    ): Flow<BaseResult<String, WrappedResponse<String>>>

    suspend fun fetchExchangeRate(): Flow<BaseResult<ExchangeRateSyncResponse, WrappedResponse<String>>>

    suspend fun gpsTourResponse(
        gpsTourRequest: GpsTourRequest
    ): Flow<GpsTourResponse>

    suspend fun cancelDocumentResponse(
        cancelDocumentRequest: CancelDocumentRequest
    ): Flow<MessageResponse>
}