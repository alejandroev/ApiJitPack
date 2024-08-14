package co.dito.abako.apijitpack.domain.general.usecase

import co.dito.abako.apijitpack.data.model.response.general.MasterTypeRequest
import co.dito.abako.apijitpack.domain.general.GeneralRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchMasterIdUseCase @Inject constructor(
    private val generalRepository: GeneralRepository
) {

    suspend operator fun invoke(
        type: MasterTypeRequest,
        master: String
    ) : Flow<String> = generalRepository.fetchMasterId(
        type = type,
        master = master
    )
}