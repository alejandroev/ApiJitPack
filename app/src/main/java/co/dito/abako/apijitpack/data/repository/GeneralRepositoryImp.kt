package co.dito.abako.apijitpack.data.repository

import co.dito.abako.apijitpack.data.common.WrappedResponse
import co.dito.abako.apijitpack.data.common.utils.mappingTo
import co.dito.abako.apijitpack.data.model.request.general.CancelDocumentRequest
import co.dito.abako.apijitpack.data.model.request.general.GpsTourRequest
import co.dito.abako.apijitpack.data.model.request.offer.VirtualOfferRequest
import co.dito.abako.apijitpack.data.model.request.report.DocumentReportRequest
import co.dito.abako.apijitpack.data.model.response.delivery.GpsTourResponse
import co.dito.abako.apijitpack.data.model.response.delivery.GpsTourResponseOld
import co.dito.abako.apijitpack.data.model.response.general.ExchangeRateSyncResponse
import co.dito.abako.apijitpack.data.model.response.general.MessageResponse
import co.dito.abako.apijitpack.data.model.response.general.MessageResponseOld
import co.dito.abako.apijitpack.data.model.response.offer.VirtualOfferResponse
import co.dito.abako.apijitpack.data.model.response.report.*
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

    override suspend fun getVirtualOfferResponse(
        virtualOfferRequest: VirtualOfferRequest
    ): Flow<VirtualOfferResponse> {
        val response = try {
            generalMobileApiService.getVirtualOffer(virtualOfferRequest)
        }catch (ex: java.lang.Exception){
            VirtualOfferResponse(MessageResponse(-1, ex.message.toString()), listOf(), listOf(), listOf())
        }
        response.message.validResponse()
        return flow {
            emit(response)
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

    override suspend fun reportResponse(documentReportRequest: DocumentReportRequest): Flow<Resultado> {
        val response = try {
            val jsonString = generalMobileApiService.getReport(documentReportRequest)
            val payType = jsonString.xmlInforme.split("FormaPago>")[1].split("<")[0]
            val pending = jsonString.xmlInforme.split("<Pendiente>")[1].split("<")[0]
            val quota = jsonString.xmlInforme.split("<Cupo>")[1].split("<")[0]
            Resultado(payType, pending, quota)
        } catch (ex: Exception){
            Resultado(ex.message.toString(), "", "")
        }
        return flow {
            emit(response)
        }
    }

    private fun getItem(cod: String, doc: Document): String? {
        return doc.getElementsByTagName(cod).item(0).textContent
    }
}