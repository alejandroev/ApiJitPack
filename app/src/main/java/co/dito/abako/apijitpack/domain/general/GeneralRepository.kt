package co.dito.abako.apijitpack.domain.general

import co.dito.abako.apijitpack.data.common.WrappedResponse
import co.dito.abako.apijitpack.data.model.response.general.ExchangeRateSyncResponse
import co.dito.abako.apijitpack.domain.BaseResult
import kotlinx.coroutines.flow.Flow

interface GeneralRepository {

    suspend fun ping(
        url: String
    ): Flow<BaseResult<String, WrappedResponse<String>>>

    suspend fun fetchExchangeRate(): Flow<BaseResult<ExchangeRateSyncResponse, WrappedResponse<String>>>
}