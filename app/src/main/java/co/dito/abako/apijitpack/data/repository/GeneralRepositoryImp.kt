package co.dito.abako.apijitpack.data.repository

import co.dito.abako.apijitpack.data.common.WrappedResponse
import co.dito.abako.apijitpack.data.common.utils.ZipUtils
import co.dito.abako.apijitpack.data.model.request.general.GpsTourRequestOld
import co.dito.abako.apijitpack.data.model.response.delivery.GpsTourResponse
import co.dito.abako.apijitpack.data.model.response.general.ExchangeRateSyncResponse
import co.dito.abako.apijitpack.data.network.GeneralOldApiService
import co.dito.abako.apijitpack.domain.BaseResult
import co.dito.abako.apijitpack.domain.general.GeneralRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GeneralRepositoryImp @Inject constructor(private val generalApiService: GeneralOldApiService) :
    GeneralRepository {

    override suspend fun ping(url: String): Flow<BaseResult<String, WrappedResponse<String>>> {
        return flow {
            val response = generalApiService.ping(url)
            if (response.isSuccessful && response.body() != null) {
                emit(BaseResult.Success(response.body()!!))
            } else {
                val type = object : TypeToken<WrappedResponse<String>>() {}.type
                val err: WrappedResponse<String> =
                    Gson().fromJson(response.errorBody()!!.charStream(), type)
                err.code = response.code()
                emit(BaseResult.Error(err))
            }
        }
    }

    override suspend fun fetchExchangeRate(): Flow<BaseResult<ExchangeRateSyncResponse, WrappedResponse<String>>> {
        TODO("Not yet implemented")
    }

    /*  override suspend fun fetchExchangeRate(): Flow<BaseResult<ExchangeRateSyncResponse, WrappedResponse<String>>> {
          return flow {
              val response = generalApiService.getExchangeRateSync()
              if (response.isSuccessful && response.body() != null) {
                  emit(BaseResult.Success(response.body()!!))
              } else {
                  val type = object : TypeToken<WrappedResponse<String>>() {}.type
                  val err: WrappedResponse<String> =
                      Gson().fromJson(response.errorBody()!!.charStream(), type)
                  err.code = response.code()
                  emit(BaseResult.Error(err))
              }
          }
      }*/

    override suspend fun gpsTourResponse(
        url: String,
        gpsTourRequestOld: GpsTourRequestOld
    ): Flow<BaseResult<GpsTourResponse, WrappedResponse<GpsTourResponse>>> {
        return flow {
            val response = generalApiService.gpsTourResponse(url, gpsTourRequestOld)
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