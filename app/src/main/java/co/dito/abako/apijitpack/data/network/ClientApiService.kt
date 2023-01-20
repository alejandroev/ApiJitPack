package co.dito.abako.apijitpack.data.network

import co.dito.abako.apijitpack.data.model.response.client.APIAbakoClientResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ClientApiService {

    @GET("CredencialesCliente/VerificarExistenciaCliente/{identification}")
    suspend fun verifyClientExist(@Path("identification") identification: String): Response<ResponseBody>

    @GET("CredencialesCliente/AbakoCliente/{identification}")
    suspend fun fetchClientResponse(@Path("identification") identification: String): APIAbakoClientResponse
}