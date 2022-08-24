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
import co.dito.abako.apijitpack.data.model.response.report.CreditNoteDetailResponse
import co.dito.abako.apijitpack.data.model.response.report.DocumentReportResponse
import co.dito.abako.apijitpack.data.model.response.report.DocumentReportResponseOld
import co.dito.abako.apijitpack.data.network.GeneralMobileApiService
import co.dito.abako.apijitpack.data.network.GeneralOldApiService
import co.dito.abako.apijitpack.data.network.validResponse
import co.dito.abako.apijitpack.data.repository.utils.mapper
import co.dito.abako.apijitpack.domain.BaseResult
import co.dito.abako.apijitpack.domain.general.GeneralRepository
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule
import com.fasterxml.jackson.dataformat.xml.XmlMapper
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

        val detail = "<DetalleFactura>\n" +
                "    <DetalleFactura>\n" +
                "        <IdDevolucionVenta>123</IdDevolucionVenta>\n" +
                "        <Codigo>CO1778</Codigo>\n" +
                "        <Descripcion>PACK QUITAMANCHAS COLOR + BLANCO LIQ 2X450ML</Descripcion>\n" +
                "        <Cantidad>2.00</Cantidad>\n" +
                "        <UM>UNI</UM>\n" +
                "        <Precio>4985</Precio>\n" +
                "        <SubTotal>9970</SubTotal>\n" +
                "    </DetalleFactura>\n" +
                "    <DetalleFactura>\n" +
                "        <IdDevolucionVenta>646</IdDevolucionVenta>\n" +
                "        <Codigo>67212690</Codigo>\n" +
                "        <Descripcion>SEDAL SH KERATINA ANTIOX 6X2X340ML</Descripcion>\n" +
                "        <Cantidad>2.00</Cantidad>\n" +
                "        <UM>UNI</UM>\n" +
                "        <Precio>18262</Precio>\n" +
                "        <SubTotal>36523</SubTotal>\n" +
                "    </DetalleFactura>\n" +
                "    <DetalleFactura>\n" +
                "        <IdDevolucionVenta>15040</IdDevolucionVenta>\n" +
                "        <Codigo>PPP6</Codigo>\n" +
                "        <Descripcion>PAPAS POLLO X6</Descripcion>\n" +
                "        <Cantidad>100.00</Cantidad>\n" +
                "        <UM>BO</UM>\n" +
                "        <Precio>10449</Precio>\n" +
                "        <SubTotal>1044878</SubTotal>\n" +
                "    </DetalleFactura>\n" +
                "</DetalleFactura>\n"
        try {
            val module = JacksonXmlModule()
            module.setDefaultUseWrapper(false)
            val xmlMapper = XmlMapper(module)
            xmlMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
            val value = xmlMapper.readValue(detail, CreditNoteDetailResponse::class.java)
            print(value)
        }catch (ex: Exception) {
            ex.printStackTrace()
        }
        /*try {
            var builder: DocumentBuilder? = null
            try {
                builder = DocumentBuilderFactory.newInstance().newDocumentBuilder()
            } catch (e: ParserConfigurationException) {
                e.printStackTrace()
            }
            val src = InputSource()
            src.characterStream = StringReader(response.detail)

            var doc: Document? = null
            try {
                doc = builder!!.parse(src)
            } catch (e: SAXException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: NullPointerException) {
                e.printStackTrace()
            }

            if (doc != null) {
                print(doc)
            }
        } catch (ex: Exception) {
            print(ex.message)
        }*/
        response.validResponse()
        return flow {
            emit(response)
        }
    }

    private fun getItem(cod: String, doc: Document): String? {
        return doc.getElementsByTagName(cod).item(0).textContent
    }
}