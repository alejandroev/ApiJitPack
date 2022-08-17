package co.dito.abako.apijitpack.domain.general.usecase

import co.dito.abako.apijitpack.data.model.request.general.CancelDocumentRequest
import co.dito.abako.apijitpack.data.model.response.general.MessageResponse
import co.dito.abako.apijitpack.domain.general.GeneralRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class CancelDocumentUseCase @Inject constructor(
    private val generalRepository: GeneralRepository
) {

    suspend operator fun invoke(cancelDocumentRequest: CancelDocumentRequest): Flow<MessageResponse> =
        generalRepository.cancelDocumentResponse(cancelDocumentRequest)
}