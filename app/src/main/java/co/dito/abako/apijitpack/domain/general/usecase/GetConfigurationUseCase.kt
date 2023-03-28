package co.dito.abako.apijitpack.domain.general.usecase

import co.dito.abako.apijitpack.data.model.response.configuration.APIConfigurationResponse
import co.dito.abako.apijitpack.domain.general.GeneralRepository
import kotlinx.coroutines.flow.Flow
import java.util.Date
import javax.inject.Inject

class GetConfigurationUseCase @Inject constructor(
    private val generalRepository: GeneralRepository
) {

    suspend operator fun invoke(date: Date, companyId: Int, isAll: Boolean) : Flow<List<APIConfigurationResponse>> =
        generalRepository.getConfiguration(date, companyId, isAll)
}