package co.dito.abako.apijitpack.data.network

import co.dito.abako.apijitpack.data.model.request.delivery.CreditNoteRequest
import co.dito.abako.apijitpack.data.model.request.general.GpsTourRequest
import co.dito.abako.apijitpack.data.model.request.general.UserRequest
import co.dito.abako.apijitpack.data.model.request.offer.VirtualOfferRequest
import co.dito.abako.apijitpack.data.model.request.report.DocumentReportRequest
import co.dito.abako.apijitpack.data.model.response.configuration.APIConfigurationResponse
import co.dito.abako.apijitpack.data.model.response.delivery.CreditModelResponse
import co.dito.abako.apijitpack.data.model.response.delivery.GpsTourResponse
import co.dito.abako.apijitpack.data.model.response.general.UserResponse
import co.dito.abako.apijitpack.data.model.response.offer.VirtualOfferResponse
import co.dito.abako.apijitpack.data.model.response.report.ReportResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface GeneralMobileApiService {

    @POST("Usuario")
    suspend fun loginUser(@Body userRequest: UserRequest): UserResponse

    @POST("/api/OfertasVirtuales/ValidarOferta")
    suspend fun getVirtualOffer(@Body virtualOfferRequest: VirtualOfferRequest): VirtualOfferResponse

    @POST("Geo/SetRecorridoGPS")
    suspend fun gpsTourResponse(@Body gpsTourRequest: GpsTourRequest): GpsTourResponse

    @POST("Informes/GetInforme")
    suspend fun getReport(@Body documentReportRequest: DocumentReportRequest): ReportResponse

    @GET("Configuracion/{date}/{companyId}/{isAll}")
    suspend fun getConfiguration(
        @Path("date") date: String,
        @Path("companyId") companyId: Int,
        @Path("isAll") isAll: String
    ): List<APIConfigurationResponse>

    @POST("NotasCredito/SetNotaCreditoaddasdsd")
    suspend fun setCreditNotes( @Body creditNoteRequest: CreditNoteRequest): CreditModelResponse

}