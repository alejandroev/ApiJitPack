package co.dito.abako.apijitpack.domain.delivery.usecase

import co.dito.abako.apijitpack.data.model.request.delivery.SetCreditNoteRequest
import co.dito.abako.apijitpack.data.model.response.delivery.SetCreditNoteResponse
import co.dito.abako.apijitpack.domain.delivery.DeliveryRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class InsertCreditNoteRequestUseCase @Inject constructor(private val deliveryRepository: DeliveryRepository) {

    suspend operator fun invoke(setCreditNoteRequest: SetCreditNoteRequest): Flow<SetCreditNoteResponse> =
        deliveryRepository.setCreditNoteDetailRequest(setCreditNoteRequest)
}