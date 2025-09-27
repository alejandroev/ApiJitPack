package co.dito.abako.apijitpack.data.network

import co.dito.abako.apijitpack.data.model.request.DocumentDayRequest
import co.dito.abako.apijitpack.data.model.request.DocumentDayResponse
import co.dito.abako.apijitpack.data.model.request.delivery.CreditNoteRequest
import co.dito.abako.apijitpack.data.model.request.delivery.DeliveryRequest
import co.dito.abako.apijitpack.data.model.request.delivery.SettlementDeliveryRequest
import co.dito.abako.apijitpack.data.model.request.general.GpsTourRequest
import co.dito.abako.apijitpack.data.model.request.general.UserRequest
import co.dito.abako.apijitpack.data.model.request.offer.VirtualOfferRequest
import co.dito.abako.apijitpack.data.model.request.report.DocumentReportRequest
import co.dito.abako.apijitpack.data.model.response.configuration.APIConfigurationResponse
import co.dito.abako.apijitpack.data.model.response.delivery.CreditModelResponse
import co.dito.abako.apijitpack.data.model.response.delivery.DeliveryDetailResponse
import co.dito.abako.apijitpack.data.model.response.delivery.DeliveryDetailResponseApi
import co.dito.abako.apijitpack.data.model.response.delivery.DeliveryResponse
import co.dito.abako.apijitpack.data.model.response.delivery.GpsTourResponse
import co.dito.abako.apijitpack.data.model.response.delivery.MasterDeliveryResponse
import co.dito.abako.apijitpack.data.model.response.delivery.ReasonReturnDeliveryResponse
import co.dito.abako.apijitpack.data.model.response.delivery.SettlementDeliveryResponse
import co.dito.abako.apijitpack.data.model.response.general.JsonCompress
import co.dito.abako.apijitpack.data.model.response.general.UserResponse
import co.dito.abako.apijitpack.data.model.response.offer.VirtualOfferResponse
import co.dito.abako.apijitpack.data.model.response.report.ReportResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Url

interface GeneralMobileApiService {

    @POST("Entregas/SetLiquidacionEntrega")
    suspend fun setSettlementDeliveryResponse(@Body requestSettlement: SettlementDeliveryRequest): SettlementDeliveryResponse


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

    @POST("NotasCredito/SetNotaCredito")
    suspend fun setCreditNotes( @Body creditNoteRequest: CreditNoteRequest): CreditModelResponse

    @GET("Entregas/GetEntregaDetalle/{fecha}/{factura}/{usuario}")
    suspend fun getEntregaDetalle(
        @Path("fecha") fecha: String,
        @Path("factura") factura: String,
        @Path("usuario") usuario: String
    ): DeliveryDetailResponseApi


    @GET("Entregas/GetEntregaDetalle/{fecha}/{factura}/{usuario}")
    suspend fun getDeliveryDetailResponse(
        @Path("fecha") fecha: String,
        @Path("factura") factura: String,
        @Path("usuario") usuario: String
    ): DeliveryDetailResponse

    @GET("NotasCredito/GetMotivosDevolucion/{esTodo}/{fecha}/{idPersona}")
    suspend fun getReasonReturnDeliveryResponse(
        @Path("esTodo") esTodo: String,
        @Path("fecha") fecha: String,
        @Path("idPersona") idPersona: Int
    ): ReasonReturnDeliveryResponse



    @POST("Informes/GetDocumentosDiaActual")
    suspend fun getDocumentosDiaActual(@Body documentDayRequest: DocumentDayRequest): DocumentDayResponse


    @GET("Entregas/GetEntregas/{fecha}/{idPersona}")
    suspend fun getDeliveryResponse( @Path("fecha") fecha: String,
                                      @Path("idPersona") idPersona: Int): DeliveryResponse

    @GET("Entregas/GetEntregasMaestros/{fecha}/{idPersona}/{esTodo}")
    suspend fun getMasterDeliveryResponse( @Path("fecha") fecha: String,
                                          @Path("idPersona") idPersona: Int,
                                           @Path("esTodo") esTodo: String,): MasterDeliveryResponse


}