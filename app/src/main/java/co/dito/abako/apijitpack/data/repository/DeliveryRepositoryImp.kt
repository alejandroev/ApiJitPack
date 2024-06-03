package co.dito.abako.apijitpack.data.repository

import co.dito.abako.apijitpack.data.model.request.delivery.CreditNoteRequest
import co.dito.abako.abako.abako.data.model.DllItemCredit
import co.dito.abako.apijitpack.data.common.utils.mappingTo
import co.dito.abako.apijitpack.data.model.request.DocumentDayRequest
import co.dito.abako.apijitpack.data.model.request.DocumentDayResponse
import co.dito.abako.apijitpack.data.model.request.delivery.DeliveryDetailRequest
import co.dito.abako.apijitpack.data.model.request.delivery.DeliveryRequest
import co.dito.abako.apijitpack.data.model.request.delivery.MasterDeliveryRequest
import co.dito.abako.apijitpack.data.model.request.delivery.ReasonReturnDeliveryRequest
import co.dito.abako.apijitpack.data.model.request.delivery.SetCreditNoteRequest
import co.dito.abako.apijitpack.data.model.request.delivery.SettlementDeliveryRequest
import co.dito.abako.apijitpack.data.model.request.delivery.toCreditNoteRequest
import co.dito.abako.apijitpack.data.model.response.delivery.CreditModelResponse
import co.dito.abako.apijitpack.data.model.response.delivery.DeliveryDetailResponse
import co.dito.abako.apijitpack.data.model.response.delivery.DeliveryDetailResponseApi
import co.dito.abako.apijitpack.data.model.response.delivery.DeliveryResponse
import co.dito.abako.apijitpack.data.model.response.delivery.MasterDeliveryResponse
import co.dito.abako.apijitpack.data.model.response.delivery.ReasonReturnDeliveryResponse
import co.dito.abako.apijitpack.data.model.response.delivery.SetCreditNoteResponse
import co.dito.abako.apijitpack.data.model.response.delivery.SettlementDeliveryResponse
import co.dito.abako.apijitpack.data.network.DeliveryOldApiService
import co.dito.abako.apijitpack.data.network.GeneralMobileApiService
import co.dito.abako.apijitpack.data.network.validResponse
import co.dito.abako.apijitpack.domain.delivery.DeliveryRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DeliveryRepositoryImp @Inject constructor(
    private val deliveryApiService: DeliveryOldApiService,
    private val generalMobileApiService: GeneralMobileApiService,
) : DeliveryRepository {

    override suspend fun getDeliveryResponse(deliveryRequest: DeliveryRequest): Flow<DeliveryResponse> {
        return flow {
            generalMobileApiService.getDeliveryResponse(fecha = "2022-01-01", idPersona = deliveryRequest.idPerson).let {
                emit(it)
            }
        }
    }

    override suspend fun getDeliveryDetailResponse(deliveryDetailRequest: DeliveryDetailRequest): Flow<DeliveryDetailResponse> {
        return flow {
            deliveryApiService.getDeliveryDetailResponse(deliveryDetailRequest).let {
                val response = it.mappingTo(DeliveryDetailResponse::class.java).apply {
                    validResponse()
                }
                emit(response)
            }
        }
    }

    override suspend fun getMasterDeliveryResponse(masterDeliveryRequest: MasterDeliveryRequest): Flow<MasterDeliveryResponse> {
        return flow {
            deliveryApiService.getMasterDeliveryResponse(masterDeliveryRequest).let {
                val response = it.mappingTo(MasterDeliveryResponse::class.java).apply {
                    validResponse()
                }
                emit(response)
            }
        }
    }

    override suspend fun getReasonReturnDeliveryResponse(reasonReturnDeliveryRequest: ReasonReturnDeliveryRequest): Flow<ReasonReturnDeliveryResponse> {
        return flow {
            deliveryApiService.getReasonReturnDeliveryResponse(reasonReturnDeliveryRequest).let {
                val response = it.mappingTo(ReasonReturnDeliveryResponse::class.java).apply {
                    validResponse()
                }
                emit(response)
            }
        }
    }


    override suspend  fun setCreditNoteDetailRequestApi(setCreditNoteRequest: SetCreditNoteRequest): Flow<CreditModelResponse> {
        return flow {
            generalMobileApiService.setCreditNotes(setCreditNoteRequest.toCreditNoteRequest()).let {
                it.estado.forEach { state ->
                    state.validResponse()
                }
                emit(it)
            }
        }
    }

    override suspend  fun getDocumentosDiaActual(documentDayRequest: DocumentDayRequest): Flow<DocumentDayResponse> {
        return flow {
            generalMobileApiService.getDocumentosDiaActual(documentDayRequest).let {
                emit(it)
            }
        }
    }

    override suspend  fun getEntregaDetalle(fecha:String, factura: String, usuario:String): Flow<DeliveryDetailResponseApi> {
        return flow {
            generalMobileApiService.getEntregaDetalle(fecha,factura,usuario).let {
                emit(it)
            }
        }
    }

    override suspend fun setCreditNoteDetailRequest(setCreditNoteRequest: SetCreditNoteRequest): Flow<SetCreditNoteResponse> {
        return flow {
            deliveryApiService.setCreditNoteResponse(setCreditNoteRequest).let {
                val response = it.mappingTo(SetCreditNoteResponse::class.java).apply {
                    validResponse()
                }
                response.states.forEach { state ->
                    state.validResponse()
                }
                emit(response)
            }
        }
    }

    override suspend fun setSettlementDeliveryRequest(settlementDeliveryRequest: SettlementDeliveryRequest): Flow<SettlementDeliveryResponse> {
        return flow {
            deliveryApiService.setSettlementDeliveryResponse(settlementDeliveryRequest).let {
                val response = it.mappingTo(SettlementDeliveryResponse::class.java).apply {
                    validResponse()
                }
                response.state.forEach { state ->
                    state.validResponse()
                }
                emit(response)
            }
        }
    }
}