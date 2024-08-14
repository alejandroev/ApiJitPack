package co.dito.abako.apijitpack.domain.delivery

import co.dito.abako.apijitpack.data.model.request.DocumentDayRequest
import co.dito.abako.apijitpack.data.model.request.DocumentDayResponse
import co.dito.abako.apijitpack.data.model.request.delivery.DeliveryDetailRequest
import co.dito.abako.apijitpack.data.model.request.delivery.DeliveryRequest
import co.dito.abako.apijitpack.data.model.request.delivery.MasterDeliveryRequest
import co.dito.abako.apijitpack.data.model.request.delivery.ReasonReturnDeliveryRequest
import co.dito.abako.apijitpack.data.model.request.delivery.SetCreditNoteRequest
import co.dito.abako.apijitpack.data.model.request.delivery.SettlementDeliveryRequest
import co.dito.abako.apijitpack.data.model.response.delivery.CreditModelResponse
import co.dito.abako.apijitpack.data.model.response.delivery.DeliveryDetailResponse
import co.dito.abako.apijitpack.data.model.response.delivery.DeliveryDetailResponseApi
import co.dito.abako.apijitpack.data.model.response.delivery.DeliveryResponse
import co.dito.abako.apijitpack.data.model.response.delivery.MasterDeliveryResponse
import co.dito.abako.apijitpack.data.model.response.delivery.ReasonReturnDeliveryResponse
import co.dito.abako.apijitpack.data.model.response.delivery.SetCreditNoteResponse
import co.dito.abako.apijitpack.data.model.response.delivery.SettlementDeliveryResponse
import kotlinx.coroutines.flow.Flow

interface DeliveryRepository {

    suspend fun getDeliveryResponse(deliveryRequest: DeliveryRequest): Flow<DeliveryResponse>

    suspend fun getDeliveryDetailResponse(deliveryDetailRequest: DeliveryDetailRequest): Flow<DeliveryDetailResponse>

    suspend fun getMasterDeliveryResponse(masterDeliveryRequest: MasterDeliveryRequest): Flow<MasterDeliveryResponse>

    suspend fun getReasonReturnDeliveryResponse(reasonReturnDeliveryRequest: ReasonReturnDeliveryRequest): Flow<ReasonReturnDeliveryResponse>

    suspend fun setCreditNoteDetailRequest(setCreditNoteRequest: SetCreditNoteRequest): Flow<SetCreditNoteResponse>

    suspend fun setSettlementDeliveryRequest(settlementDeliveryRequest: SettlementDeliveryRequest): Flow<SettlementDeliveryResponse>

    suspend fun setCreditNoteDetailRequestApi(setCreditNoteRequest: SetCreditNoteRequest): Flow<CreditModelResponse>

    suspend fun getEntregaDetalle(fecha:String, factura: String, usuario:String): Flow<DeliveryDetailResponseApi>
    suspend fun getDocumentosDiaActual(documentDayRequest: DocumentDayRequest): Flow<DocumentDayResponse>



}