package co.dito.abako.apijitpack.domain.support.usecase

import co.dito.abako.apijitpack.data.model.request.support.SupportRequest
import co.dito.abako.apijitpack.data.model.response.support.SupportResponse
import co.dito.abako.apijitpack.domain.support.FirebaseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SendSupportResponseUseCase @Inject constructor(private val firebaseRepository: FirebaseRepository) {

    suspend operator fun invoke(supportRequest: SupportRequest) : Flow<SupportResponse> =
        firebaseRepository.getSupportResponse(supportRequest)
}