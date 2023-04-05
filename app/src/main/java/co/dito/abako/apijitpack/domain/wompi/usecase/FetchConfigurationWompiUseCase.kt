package co.dito.abako.apijitpack.domain.wompi.usecase

import co.dito.abako.apijitpack.data.model.request.wompi.WompiRequest
import co.dito.abako.apijitpack.domain.wompi.WompiRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchConfigurationWompiUseCase @Inject constructor(
    private val wompiRepository: WompiRepository
) {

    suspend operator fun invoke(wompiRequest: WompiRequest, redirectUrl: String) : Flow<String> =
        wompiRepository.fetchConfigurationWompi(wompiRequest, redirectUrl)
}