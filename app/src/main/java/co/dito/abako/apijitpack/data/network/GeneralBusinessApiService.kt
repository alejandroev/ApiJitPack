package co.dito.abako.apijitpack.data.network

import co.dito.abako.apijitpack.data.model.request.general.MaestroRecuperarRequest
import co.dito.abako.apijitpack.data.model.response.general.MaestroRecuperarItem
import co.dito.abako.apijitpack.data.model.response.general.ExchangeRateSyncResponse
import co.dito.abako.apijitpack.data.model.response.general.MasterIdResponse
import co.dito.abako.apijitpack.data.model.response.notification.SetNotificationReadResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * Cliente Retrofit de **ApiNegocio** (API de negocio): Retrofit inyectado con `RETROFIT_URL_BUSINESS_API`
 * y base URL desde `GetURLBusinessUseCase` (p. ej. `.../ApiNegocio/api/`).
 */
interface GeneralBusinessApiService {

    @GET("TasaCambio/GetTasaActual")
    suspend fun getExchangeRateSync(): ExchangeRateSyncResponse

    @GET("Maestros/GetIdMaestro/{type}/{master}")
    suspend fun fetchMasterId(
        @Path("type") type: String,
        @Path("master") master: String
    ): MasterIdResponse

    /** `POST .../ApiNegocio/api/Maestros/Recuperar` (misma base que el resto de este servicio). */
    @POST("Maestros/Recuperar")
    suspend fun recuperarMaestros(@Body body: MaestroRecuperarRequest): List<MaestroRecuperarItem>

    @POST("Notificacion/SetNotificacionMensajeLeida")
    suspend fun setNotificationRead(@Body notificationId: Int) : SetNotificationReadResponse
}