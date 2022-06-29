package co.dito.abako.apijitpack.data.network

import co.dito.abako.apijitpack.data.model.request.delivery.DeliveryDetailRequest
import co.dito.abako.apijitpack.data.model.request.delivery.DeliveryRequest
import co.dito.abako.apijitpack.data.model.request.delivery.MasterDeliveryRequest
import co.dito.abako.apijitpack.data.model.request.delivery.ReasonReturnDeliveryRequest
import co.dito.abako.apijitpack.data.model.request.delivery.SetCreditNoteRequest
import co.dito.abako.apijitpack.data.model.response.general.JsonCompress
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Url

interface DeliveryApiService {

    /**
     * @param url URL of services
     * @param deliveryRequest Body of request
     * @return [JsonCompress]
     */
    @POST
    suspend fun getDeliveryResponse(
        @Url url: String,
        @Body deliveryRequest: DeliveryRequest
    ): Response<JsonCompress>

    /**
     * @param url URL of services
     * @param deliveryDetailRequest Body of request
     * @return [JsonCompress]
     */
    @POST
    suspend fun getDeliveryDetailResponse(
        @Url url: String,
        @Body deliveryDetailRequest: DeliveryDetailRequest
    ): Response<JsonCompress>

    /**
     * @param url URL of services
     * @param masterDeliveryRequest Body of request
     * @return [JsonCompress]
     */
    @POST
    suspend fun getMasterDeliveryResponse(
        @Url url: String,
        @Body masterDeliveryRequest: MasterDeliveryRequest
    ): Response<JsonCompress>

    /**
     * @param url URL of services
     * @param reasonReturnDeliveryRequest Body of request
     * @return [JsonCompress]
     */
    @POST
    suspend fun getReasonReturnDeliveryResponse(
        @Url url: String,
        @Body reasonReturnDeliveryRequest: ReasonReturnDeliveryRequest
    ): Response<JsonCompress>

    /**
     * @param url URL of services
     * @param setCreditNoteDetailRequest Body of request
     * @return [JsonCompress]
     */
    @POST
    suspend fun setCreditNoteResponse(
        @Url url: String,
        @Body setCreditNoteDetailRequest: SetCreditNoteRequest
    ): Response<JsonCompress>
}