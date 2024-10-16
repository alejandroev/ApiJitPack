package co.dito.abako.apijitpack.domain.delivery.usecase

import co.dito.abako.apijitpack.data.model.request.DocumentDayRequest
import co.dito.abako.apijitpack.data.model.request.DocumentDayResponse
import co.dito.abako.apijitpack.data.model.request.delivery.SetCreditNoteRequest
import co.dito.abako.apijitpack.data.model.response.delivery.CreditModelResponse
import co.dito.abako.apijitpack.data.model.response.delivery.DeliveryDetailResponseApi
import co.dito.abako.apijitpack.data.model.response.delivery.SetCreditNoteResponse
import co.dito.abako.apijitpack.domain.delivery.DeliveryRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class InsertCreditNoteRequestUseCase @Inject constructor(private val deliveryRepository: DeliveryRepository) {

    suspend operator fun invoke(setCreditNoteRequest: SetCreditNoteRequest): Flow<SetCreditNoteResponse> =
        deliveryRepository.setCreditNoteDetailRequest(setCreditNoteRequest)

    suspend fun setCreditNoteDetailRequestApi(setCreditNoteRequest: SetCreditNoteRequest): Flow<CreditModelResponse> =
        deliveryRepository.setCreditNoteDetailRequestApi(setCreditNoteRequest)

    suspend fun getEntregaDetalle(fecha:String, factura: String, usuario:String): Flow<DeliveryDetailResponseApi> =
        deliveryRepository.getEntregaDetalle(fecha,factura,usuario)

    suspend fun getDocumentosDiaActual(documentDayRequest: DocumentDayRequest): Flow<DocumentDayResponse> =
        deliveryRepository.getDocumentosDiaActual(documentDayRequest)

}