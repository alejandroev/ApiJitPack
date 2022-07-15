package co.dito.abako.apijitpack.data.network

import co.dito.abako.apijitpack.data.model.request.general.GpsTourRequestOld
import co.dito.abako.apijitpack.data.model.response.general.JsonCompress
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url

interface GeneralOldApiService {

    @GET
    suspend fun ping(@Url url: String): Response<String?>

    /**
     * @param gpsTourRequestOld Body of request
     * @return [JsonCompress]
     */
    @POST("SetRecorridoGPS")
    suspend fun gpsTourResponse(
        @Body gpsTourRequestOld: GpsTourRequestOld
    ): JsonCompress
}