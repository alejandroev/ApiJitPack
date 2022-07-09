package co.dito.abako.apijitpack.data.network

import co.dito.abako.apijitpack.data.model.request.general.GpsTourRequestOld
import co.dito.abako.apijitpack.data.model.request.general.UserRequest
import co.dito.abako.apijitpack.data.model.response.general.ExchangeRateSyncResponse
import co.dito.abako.apijitpack.data.model.response.general.JsonCompress
import co.dito.abako.apijitpack.data.model.response.general.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url

interface GeneralOldApiService {

    @GET
    suspend fun ping(@Url url: String): Response<String?>

    /**
     * @param url URL of services
     * @param gpsTourRequestOld Body of request
     * @return [JsonCompress]
     */
    @POST
    suspend fun gpsTourResponse(
        @Url url: String,
        @Body gpsTourRequestOld: GpsTourRequestOld
    ): Response<JsonCompress>
}