package co.dito.abako.apijitpack.data.repository

import co.dito.abako.apijitpack.data.common.WrappedResponse
import co.dito.abako.apijitpack.data.common.utils.ZipUtils
import co.dito.abako.apijitpack.data.model.request.delivery.*
import co.dito.abako.apijitpack.data.model.response.delivery.*
import co.dito.abako.apijitpack.data.network.DeliveryApiService
import co.dito.abako.apijitpack.domain.BaseResult
import co.dito.abako.apijitpack.domain.delivery.DeliveryRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DeliveryRepositoryImp @Inject constructor(private val deliveryApiService: DeliveryApiService) :
    DeliveryRepository {

    override suspend fun getDeliveryResponse(
        url: String,
        deliveryRequest: DeliveryRequest
    ): Flow<BaseResult<DeliveryResponse, WrappedResponse<DeliveryResponse>>> {
        return flow {
            val response = deliveryApiService.getDeliveryResponse(url, deliveryRequest)
            if (response.isSuccessful && response.body() != null) {
                val deliveryResponse = Gson().fromJson(
                    ZipUtils.decompress(response.body()!!.content),
                    DeliveryResponse::class.java
                )
                emit(BaseResult.Success(deliveryResponse))
            } else {
                val type = object : TypeToken<WrappedResponse<DeliveryResponse>>() {}.type
                val err: WrappedResponse<DeliveryResponse> =
                    Gson().fromJson(response.errorBody()!!.charStream(), type)
                err.code = response.code()
                emit(BaseResult.Error(err))
            }
        }
    }

    override suspend fun getDeliveryDetailResponse(
        url: String,
        deliveryDetailRequest: DeliveryDetailRequest
    ): Flow<BaseResult<DeliveryDetailResponse, WrappedResponse<DeliveryDetailResponse>>> {
        return flow {
            val response = deliveryApiService.getDeliveryDetailResponse(url, deliveryDetailRequest)
            if (response.isSuccessful && response.body() != null) {
                val deliveryDetailResponse = Gson().fromJson(
                    ZipUtils.decompress(response.body()!!.content),
                    DeliveryDetailResponse::class.java
                )
                emit(BaseResult.Success(deliveryDetailResponse))
            } else {
                val type = object : TypeToken<WrappedResponse<DeliveryDetailResponse>>() {}.type
                val err: WrappedResponse<DeliveryDetailResponse> =
                    Gson().fromJson(response.errorBody()!!.charStream(), type)
                err.code = response.code()
                emit(BaseResult.Error(err))
            }
        }
    }

    override suspend fun getMasterDeliveryResponse(
        url: String,
        masterDeliveryRequest: MasterDeliveryRequest
    ): Flow<BaseResult<MasterDeliveryResponse, WrappedResponse<MasterDeliveryResponse>>> {
        return flow {
            val response = deliveryApiService.getMasterDeliveryResponse(url, masterDeliveryRequest)
            if (response.isSuccessful && response.body() != null) {
                val masterDeliveryResponse = Gson().fromJson(
                    ZipUtils.decompress(response.body()!!.content),
                    MasterDeliveryResponse::class.java
                )
                emit(BaseResult.Success(masterDeliveryResponse))
            } else {
                val type = object : TypeToken<WrappedResponse<MasterDeliveryResponse>>() {}.type
                val err: WrappedResponse<MasterDeliveryResponse> =
                    Gson().fromJson(response.errorBody()!!.charStream(), type)
                err.code = response.code()
                emit(BaseResult.Error(err))
            }
        }
    }

    override suspend fun getReasonReturnDeliveryResponse(
        url: String,
        reasonReturnDeliveryRequest: ReasonReturnDeliveryRequest
    ): Flow<BaseResult<ReasonReturnDeliveryResponse, WrappedResponse<ReasonReturnDeliveryResponse>>> {
        return flow {
            val response =
                deliveryApiService.getReasonReturnDeliveryResponse(url, reasonReturnDeliveryRequest)
            if (response.isSuccessful && response.body() != null) {
                val reasonReturnDeliveryResponse = Gson().fromJson(
                    ZipUtils.decompress(response.body()!!.content),
                    ReasonReturnDeliveryResponse::class.java
                )
                emit(BaseResult.Success(reasonReturnDeliveryResponse))
            } else {
                val type = object : TypeToken<WrappedResponse<MasterDeliveryResponse>>() {}.type
                val err: WrappedResponse<ReasonReturnDeliveryResponse> =
                    Gson().fromJson(response.errorBody()!!.charStream(), type)
                err.code = response.code()
                emit(BaseResult.Error(err))
            }
        }
    }

    override suspend fun setCreditNoteDetailRequest(
        url: String,
        setCreditNoteRequest: SetCreditNoteRequest,
    ): Flow<BaseResult<SetCreditNoteResponse, WrappedResponse<SetCreditNoteResponse>>> {
        return flow {
            val response = deliveryApiService.setCreditNoteResponse(url, setCreditNoteRequest)
            if (response.isSuccessful && response.body() != null) {
                val setCreditNoteResponse = Gson().fromJson(
                    ZipUtils.decompress(response.body()!!.content),
                    SetCreditNoteResponse::class.java
                )
                emit(BaseResult.Success(setCreditNoteResponse))
            } else {
                val type = object : TypeToken<WrappedResponse<SetCreditNoteResponse>>() {}.type
                val err: WrappedResponse<SetCreditNoteResponse> =
                    Gson().fromJson(response.errorBody()!!.charStream(), type)
                err.code = response.code()
                emit(BaseResult.Error(err))
            }
        }
    }

    override suspend fun settlementDeliveryResponse(
        url: String,
        settlementDeliveryRequest: SettlementDeliveryRequest,
    ): Flow<BaseResult<SettlementDeliveryResponse, WrappedResponse<SettlementDeliveryResponse>>>{
        return flow {
            val response = deliveryApiService.settlementDeliveryResponse(url, settlementDeliveryRequest)
            if (response.isSuccessful && response.body() != null) {
                val settlementDeliveryResponse = Gson().fromJson(
                    ZipUtils.decompress(response.body()!!.content),
                    SettlementDeliveryResponse::class.java
                )
                emit(BaseResult.Success(settlementDeliveryResponse))
            } else {
                val type = object : TypeToken<WrappedResponse<SettlementDeliveryResponse>>() {}.type
                val err: WrappedResponse<SettlementDeliveryResponse> =
                    Gson().fromJson(response.errorBody()!!.charStream(), type)
                err.code = response.code()
                emit(BaseResult.Error(err))
            }
        }
    }

    override suspend fun gpsTourResponse(
        url: String,
        gpsTourRequest: GpsTourRequest
    ): Flow<BaseResult<GpsTourResponse, WrappedResponse<GpsTourResponse>>> {
        return flow {
            val response = deliveryApiService.gpsTourResponse(url, gpsTourRequest)
            if (response.isSuccessful && response.body() != null) {
                val gpsTourResponse = Gson().fromJson(
                    ZipUtils.decompress(response.body()!!.content),
                    GpsTourResponse::class.java
                )
                emit(BaseResult.Success(gpsTourResponse))
            } else {
                val type = object : TypeToken<WrappedResponse<GpsTourResponse>>() {}.type
                val err: WrappedResponse<GpsTourResponse> =
                    Gson().fromJson(response.errorBody()!!.charStream(), type)
                err.code = response.code()
                emit(BaseResult.Error(err))
            }
        }
    }
}