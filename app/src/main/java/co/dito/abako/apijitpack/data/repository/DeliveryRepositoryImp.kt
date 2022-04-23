package co.dito.abako.apijitpack.data.repository

import co.dito.abako.apijitpack.data.common.WrappedResponse
import co.dito.abako.apijitpack.data.common.utils.ZipUtils
import co.dito.abako.apijitpack.data.model.request.delivery.DeliveryDetailRequest
import co.dito.abako.apijitpack.data.model.request.delivery.DeliveryRequest
import co.dito.abako.apijitpack.data.model.request.delivery.MasterDeliveryRequest
import co.dito.abako.apijitpack.data.model.request.delivery.ReasonReturnDeliveryRequest
import co.dito.abako.apijitpack.data.model.response.delivery.DeliveryDetailResponse
import co.dito.abako.apijitpack.data.model.response.delivery.DeliveryResponse
import co.dito.abako.apijitpack.data.model.response.delivery.MasterDeliveryResponse
import co.dito.abako.apijitpack.data.model.response.delivery.ReasonReturnDeliveryResponse
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
        val response = deliveryApiService.getDeliveryResponse(url, deliveryRequest)
        return flow {
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
        val response = deliveryApiService.getDeliveryDetailResponse(url, deliveryDetailRequest)
        return flow {
            if (response.isSuccessful && response.body() != null){
                val deliveryDetailResponse = Gson().fromJson(
                    ZipUtils.decompress(response.body()!!.content),
                    DeliveryDetailResponse::class.java
                )
                emit(BaseResult.Success(deliveryDetailResponse))
            }else{
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
        val response = deliveryApiService.getMasterDeliveryResponse(url, masterDeliveryRequest)
        return flow {
            if (response.isSuccessful && response.body() != null){
                val masterDeliveryResponse = Gson().fromJson(
                    ZipUtils.decompress(response.body()!!.content),
                    MasterDeliveryResponse::class.java
                )
                emit(BaseResult.Success(masterDeliveryResponse))
            }else{
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
        val response = deliveryApiService.getReasonReturnDeliveryResponse(url, reasonReturnDeliveryRequest)
        return flow {
            if (response.isSuccessful && response.body() != null){
                val reasonReturnDeliveryResponse = Gson().fromJson(
                    ZipUtils.decompress(response.body()!!.content),
                    ReasonReturnDeliveryResponse::class.java
                )
                emit(BaseResult.Success(reasonReturnDeliveryResponse))
            }else{
                val type = object : TypeToken<WrappedResponse<MasterDeliveryResponse>>() {}.type
                val err: WrappedResponse<ReasonReturnDeliveryResponse> =
                    Gson().fromJson(response.errorBody()!!.charStream(), type)
                err.code = response.code()
                emit(BaseResult.Error(err))
            }
        }
    }
}