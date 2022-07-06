package co.dito.abako.apijitpack.domain.delivery.usecase

import co.dito.abako.apijitpack.data.common.WrappedResponse
import co.dito.abako.apijitpack.data.model.request.delivery.SetCreditNoteRequest
import co.dito.abako.apijitpack.data.model.response.delivery.SetCreditNoteResponse
import co.dito.abako.apijitpack.domain.BaseResult
import co.dito.abako.apijitpack.domain.delivery.DeliveryRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class InsertCreditNoteRequestUseCase @Inject constructor(private val deliveryRepository: DeliveryRepository) {

    suspend operator fun invoke(
        url: String,
        setCreditNoteRequest: SetCreditNoteRequest,
    ): Flow<BaseResult<SetCreditNoteResponse, WrappedResponse<SetCreditNoteResponse>>> =
        deliveryRepository.setCreditNoteDetailRequest(url, setCreditNoteRequest)
}