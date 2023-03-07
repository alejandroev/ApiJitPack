package co.dito.abako.apijitpack.data.network

import co.dito.abako.apijitpack.data.model.request.general.CancelDocumentRequest
import co.dito.abako.apijitpack.data.model.request.general.GpsTourRequest
import co.dito.abako.apijitpack.data.model.request.general.UserRequest
import co.dito.abako.apijitpack.data.model.request.offer.VirtualOfferRequest
import co.dito.abako.apijitpack.data.model.request.report.DocumentReportRequest
import co.dito.abako.apijitpack.data.model.response.delivery.GpsTourResponse
import co.dito.abako.apijitpack.data.model.response.general.MessageResponse
import co.dito.abako.apijitpack.data.model.response.general.UserResponse
import co.dito.abako.apijitpack.data.model.response.offer.VirtualOfferResponse
import co.dito.abako.apijitpack.data.model.response.report.DocumentReportResponse
import co.dito.abako.apijitpack.data.model.response.report.ReportResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface GeneralMobileApiService {

    @POST("Usuario")
    suspend fun loginUser(@Body userRequest: UserRequest): UserResponse

    @POST("/api/OfertasVirtuales/ValidarOferta")
    suspend fun getVirtualOffer(@Body virtualOfferRequest: VirtualOfferRequest): VirtualOfferResponse

    @POST("Geo/SetRecorridoGPS")
    suspend fun gpsTourResponse(@Body gpsTourRequest: GpsTourRequest): GpsTourResponse

    @POST("Informes/GetInformeDocumento")
    suspend fun getReportDocument(@Body documentReportRequest: DocumentReportRequest): DocumentReportResponse

    @POST("Informes/GetInforme")
    suspend fun getReport(@Body documentReportRequest: DocumentReportRequest): ReportResponse
}