package co.dito.abako.apijitpack.domain.delivery

import co.dito.abako.apijitpack.data.common.WrappedResponse
import co.dito.abako.apijitpack.data.model.request.delivery.*
import co.dito.abako.apijitpack.data.model.response.delivery.*
import co.dito.abako.apijitpack.domain.BaseResult
import kotlinx.coroutines.flow.Flow

interface DeliveryRepository {

    suspend fun getDeliveryResponse(
        url: String,
        deliveryRequest: DeliveryRequest
    ): Flow<BaseResult<DeliveryResponse, WrappedResponse<DeliveryResponse>>>

    suspend fun getDeliveryDetailResponse(
        url: String,
        deliveryDetailRequest: DeliveryDetailRequest
    ): Flow<BaseResult<DeliveryDetailResponse, WrappedResponse<DeliveryDetailResponse>>>

    suspend fun getMasterDeliveryResponse(
        url: String,
        masterDeliveryRequest: MasterDeliveryRequest
    ): Flow<BaseResult<MasterDeliveryResponse, WrappedResponse<MasterDeliveryResponse>>>

    suspend fun getReasonReturnDeliveryResponse(
        url: String,
        reasonReturnDeliveryRequest: ReasonReturnDeliveryRequest
    ): Flow<BaseResult<ReasonReturnDeliveryResponse, WrappedResponse<ReasonReturnDeliveryResponse>>>

    suspend fun setCreditNoteDetailRequest(
        url: String,
        setCreditNoteRequest: SetCreditNoteRequest
    ): Flow<BaseResult<SetCreditNoteResponse, WrappedResponse<SetCreditNoteResponse>>>

    suspend fun settlementDeliveryResponse(
        url: String,
        settlementDeliveryRequest: SettlementDeliveryRequest
    ): Flow<BaseResult<SettlementDeliveryResponse, WrappedResponse<SettlementDeliveryResponse>>>

    suspend fun gpsTourResponse(
        url: String,
        gpsTourRequest: GpsTourRequest
    ): Flow<BaseResult<GpsTourResponse, WrappedResponse<GpsTourResponse>>>
}