package co.dito.abako.apijitpack.data.repository

import co.dito.abako.apijitpack.data.common.WrappedResponse
import co.dito.abako.apijitpack.data.common.utils.mappingTo
import co.dito.abako.apijitpack.data.model.request.general.CancelDocumentRequest
import co.dito.abako.apijitpack.data.model.request.general.GpsTourRequest
import co.dito.abako.apijitpack.data.model.request.report.DocumentReportRequest
import co.dito.abako.apijitpack.data.model.response.delivery.GpsTourResponse
import co.dito.abako.apijitpack.data.model.response.delivery.GpsTourResponseOld
import co.dito.abako.apijitpack.data.model.response.general.ExchangeRateSyncResponse
import co.dito.abako.apijitpack.data.model.response.general.MessageResponse
import co.dito.abako.apijitpack.data.model.response.general.MessageResponseOld
import co.dito.abako.apijitpack.data.model.response.report.DocumentReportResponse
import co.dito.abako.apijitpack.data.model.response.report.DocumentReportResponseOld
import co.dito.abako.apijitpack.data.network.GeneralMobileApiService
import co.dito.abako.apijitpack.data.network.GeneralOldApiService
import co.dito.abako.apijitpack.data.network.validResponse
import co.dito.abako.apijitpack.data.repository.utils.mapper
import co.dito.abako.apijitpack.domain.BaseResult
import co.dito.abako.apijitpack.domain.general.GeneralRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.w3c.dom.Document


class GeneralRepositoryImp @Inject constructor(
    private val generalOldApiService: GeneralOldApiService,
    private val generalMobileApiService: GeneralMobileApiService,
) : GeneralRepository {

    override suspend fun ping(url: String): Flow<BaseResult<String, WrappedResponse<String>>> {
        return flow {
            val response = generalOldApiService.ping(url)
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

    override suspend fun gpsTourResponse(
        gpsTourRequest: GpsTourRequest,
    ): Flow<GpsTourResponse> {
        val response = try {
            generalMobileApiService.gpsTourResponse(gpsTourRequest)
        } catch (ex: Exception) {
            generalOldApiService.gpsTourResponse(gpsTourRequest.mapper()).mappingTo(GpsTourResponseOld::class.java).mapper()
        }
        response.state.validResponse()
        return flow {
            emit(response)
        }
    }

    override suspend fun cancelDocumentResponse(cancelDocumentRequest: CancelDocumentRequest): Flow<MessageResponse> {
        val response = try {
            throw Exception()
            generalMobileApiService.cancelDocument(cancelDocumentRequest)
        } catch (ex: Exception) {
            generalOldApiService.cancelDocument(cancelDocumentRequest.mapper()).mappingTo(MessageResponseOld::class.java).mapper()
        }
        response.validResponse()
        return flow {
            emit(response)
        }
    }

    override suspend fun reportDocument(documentReportRequest: DocumentReportRequest): Flow<DocumentReportResponse> {
        val response = try {
            generalMobileApiService.getReportDocument(documentReportRequest)
        } catch (ex: Exception) {
            generalOldApiService.getReportDocument(documentReportRequest.mapper())
                .mappingTo(DocumentReportResponseOld::class.java).mapper()
        }

        response.validResponse()
        return flow {
            emit(response)
        }
    }

    private fun getItem(cod: String, doc: Document): String? {
        return doc.getElementsByTagName(cod).item(0).textContent
    }
}