package co.dito.abako.apijitpack.data.repository

import co.dito.abako.apijitpack.data.common.WrappedResponse
import co.dito.abako.apijitpack.data.network.GeneralApiService
import co.dito.abako.apijitpack.domain.BaseResult
import co.dito.abako.apijitpack.domain.general.GeneralRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GeneralRepositoryImp @Inject constructor(private val generalApiService: GeneralApiService) :
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
}