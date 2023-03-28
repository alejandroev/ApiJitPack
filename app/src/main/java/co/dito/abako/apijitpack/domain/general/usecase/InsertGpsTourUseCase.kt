package co.dito.abako.apijitpack.domain.general.usecase

import co.dito.abako.apijitpack.data.model.request.general.GpsTourRequest
import co.dito.abako.apijitpack.data.model.response.delivery.GpsTourResponse
import co.dito.abako.apijitpack.domain.general.GeneralBackupRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class InsertGpsTourUseCase @Inject constructor(
    private val generalBackupRepository: GeneralBackupRepository
) {

    suspend operator fun invoke(gpsTourRequest: GpsTourRequest) : Flow<GpsTourResponse> =
        generalBackupRepository.gpsTourResponse(gpsTourRequest)
}