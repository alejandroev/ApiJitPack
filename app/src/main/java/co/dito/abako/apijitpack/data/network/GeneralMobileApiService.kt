package co.dito.abako.apijitpack.data.network

import co.dito.abako.apijitpack.data.model.request.general.CancelDocumentRequest
import co.dito.abako.apijitpack.data.model.request.general.GpsTourRequest
import co.dito.abako.apijitpack.data.model.request.general.UserRequest
import co.dito.abako.apijitpack.data.model.request.report.DocumentReportRequest
import co.dito.abako.apijitpack.data.model.request.report.DocumentReportRequestOld
import co.dito.abako.apijitpack.data.model.response.delivery.GpsTourResponse
import co.dito.abako.apijitpack.data.model.response.general.JsonCompress
import co.dito.abako.apijitpack.data.model.response.general.MessageResponse
import co.dito.abako.apijitpack.data.model.response.general.UserResponse
import co.dito.abako.apijitpack.data.model.response.report.DocumentReportResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface GeneralMobileApiService {

    @POST("Usuario")
    suspend fun loginUser(@Body userRequest: UserRequest): UserResponse

    @POST("Geo/SetRecorridoGPS")
    suspend fun gpsTourResponse(@Body gpsTourRequest: GpsTourRequest): GpsTourResponse

    @POST("OperacionesDocumentos/AnularDocumentos")
    suspend fun cancelDocument(@Body cancelDocumentRequest: CancelDocumentRequest): MessageResponse

    @POST("Informes/GetInformeDocumento")
    suspend fun getReportDocument(@Body documentReportRequest: DocumentReportRequest): DocumentReportResponse
}