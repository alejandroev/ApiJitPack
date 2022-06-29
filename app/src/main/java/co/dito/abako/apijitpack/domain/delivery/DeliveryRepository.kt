package co.dito.abako.apijitpack.domain.delivery

import co.dito.abako.apijitpack.data.common.WrappedResponse
import co.dito.abako.apijitpack.data.model.request.delivery.DeliveryDetailRequest
import co.dito.abako.apijitpack.data.model.request.delivery.DeliveryRequest
import co.dito.abako.apijitpack.data.model.request.delivery.MasterDeliveryRequest
import co.dito.abako.apijitpack.data.model.request.delivery.ReasonReturnDeliveryRequest
import co.dito.abako.apijitpack.data.model.request.delivery.SetCreditNoteRequest
import co.dito.abako.apijitpack.data.model.response.delivery.DeliveryDetailResponse
import co.dito.abako.apijitpack.data.model.response.delivery.DeliveryResponse
import co.dito.abako.apijitpack.data.model.response.delivery.MasterDeliveryResponse
import co.dito.abako.apijitpack.data.model.response.delivery.ReasonReturnDeliveryResponse
import co.dito.abako.apijitpack.data.model.response.delivery.SetCreditNoteResponse
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
}