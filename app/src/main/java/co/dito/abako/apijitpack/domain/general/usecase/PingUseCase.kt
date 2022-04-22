package co.dito.abako.apijitpack.domain.general.usecase

import co.dito.abako.apijitpack.data.common.WrappedResponse
import co.dito.abako.apijitpack.domain.BaseResult
import co.dito.abako.apijitpack.domain.general.GeneralRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PingUseCase @Inject constructor(private val generalRepository: GeneralRepository) {

    suspend operator fun invoke(url: String): Flow<BaseResult<String, WrappedResponse<String>>> =
        generalRepository.ping(url)
}