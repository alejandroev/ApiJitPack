package co.dito.abako.apijitpack.domain.general.usecase

import co.dito.abako.apijitpack.data.common.WrappedResponse
import co.dito.abako.apijitpack.data.model.response.general.ExchangeRateSyncResponse
import co.dito.abako.apijitpack.domain.BaseResult
import co.dito.abako.apijitpack.domain.general.GeneralBackupRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class ExchangeRateUseCase @Inject constructor(private val generalBackupRepository: GeneralBackupRepository) {

    suspend operator fun invoke(): Flow<BaseResult<ExchangeRateSyncResponse, WrappedResponse<String>>> =
        generalBackupRepository.fetchExchangeRate()
}