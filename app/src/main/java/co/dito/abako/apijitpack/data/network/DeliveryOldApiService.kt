package co.dito.abako.apijitpack.data.network

import co.dito.abako.apijitpack.data.model.request.delivery.DeliveryDetailRequest
import co.dito.abako.apijitpack.data.model.request.delivery.DeliveryRequest
import co.dito.abako.apijitpack.data.model.request.delivery.MasterDeliveryRequest
import co.dito.abako.apijitpack.data.model.request.delivery.ReasonReturnDeliveryRequest
import co.dito.abako.apijitpack.data.model.request.delivery.SetCreditNoteRequest
import co.dito.abako.apijitpack.data.model.request.delivery.SettlementDeliveryRequest
import co.dito.abako.apijitpack.data.model.response.general.JsonCompress
import retrofit2.http.Body
import retrofit2.http.POST

interface DeliveryOldApiService {


    /**
     * @param deliveryDetailRequest Body of request
     * @return [JsonCompress]
     */
    @POST("GetEntregaDetalle")
    suspend fun getDeliveryDetailResponse(@Body deliveryDetailRequest: DeliveryDetailRequest): JsonCompress

    /**
     * @param masterDeliveryRequest Body of request
     * @return [JsonCompress]
     */
    @POST("GetEntregasMaestros")
    suspend fun getMasterDeliveryResponse(@Body masterDeliveryRequest: MasterDeliveryRequest): JsonCompress

    /**
     * @param reasonReturnDeliveryRequest Body of request
     * @return [JsonCompress]
     */
    @POST("GetMotivosDevolucion")
    suspend fun getReasonReturnDeliveryResponse(@Body reasonReturnDeliveryRequest: ReasonReturnDeliveryRequest): JsonCompress

    /**
     * @param setCreditNoteDetailRequest Body of request
     * @return [JsonCompress]
     */
    @POST("SetNotaCredito")
    suspend fun setCreditNoteResponse(@Body setCreditNoteDetailRequest: SetCreditNoteRequest): JsonCompress

    /**
     * @param requestSettlement Body of request
     * @return [JsonCompress]
     */
    @POST("SetLiquidacionEntrega")
    suspend fun setSettlementDeliveryResponse(@Body requestSettlement: SettlementDeliveryRequest): JsonCompress
}