package co.dito.abako.apijitpack.data.network

import co.dito.abako.apijitpack.data.model.request.wompi.WompiRequest
import co.dito.abako.apijitpack.data.model.response.wompi.WompiResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface WompiAPIService {

    @POST("Wompi")
    suspend fun getWompi(@Body wompiRequest: WompiRequest): WompiResponse

    @GET("Wompi/VerificarTransacciones/{validationReference}/{date}")
    fun transactionValidation(
        @Path("validationReference") validationReference: String, @Path("date") date: String
    ): Call<ResponseBody?>

    @GET("Wompi/VerificarTransacciones/{id}")
    fun transactionValidationById(
        @Path("id") id: String
    ): Call<ResponseBody?>
}