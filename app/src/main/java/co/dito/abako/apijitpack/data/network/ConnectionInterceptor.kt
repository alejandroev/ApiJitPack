package co.dito.abako.apijitpack.data.network

import co.dito.abako.apijitpack.data.common.helper.NetworkHelper
import co.dito.abako.apijitpack.data.common.utils.BadRequest
import co.dito.abako.apijitpack.data.common.utils.NetworkErrorContent
import co.dito.abako.apijitpack.data.common.utils.NoInternet
import co.dito.abako.apijitpack.data.common.utils.NotFound
import co.dito.abako.apijitpack.data.common.utils.ServerError
import co.dito.abako.apijitpack.data.common.utils.Unauthorized
import co.dito.abako.apijitpack.domain.NO_INTERNET_CONNECTION
import com.google.gson.Gson
import java.net.HttpURLConnection
import okhttp3.Interceptor
import okhttp3.Response

class ConnectionInterceptor(
    private val networkHelper: NetworkHelper,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        return if (networkHelper.isInternetAvailable()) {
            val response = chain.proceed(originalRequest)
            when (response.code) {
                HttpURLConnection.HTTP_NOT_FOUND ->
                    throw NotFound(getErrorFromResponse(response.body?.string()))
                HttpURLConnection.HTTP_NOT_ACCEPTABLE, HttpURLConnection.HTTP_BAD_REQUEST ->
                    throw BadRequest(getErrorFromResponse(response.body?.string()))
                HttpURLConnection.HTTP_INTERNAL_ERROR ->
                    throw ServerError(getErrorFromResponse(response.body?.string()))
                HttpURLConnection.HTTP_FORBIDDEN ->
                    throw Unauthorized(getErrorFromResponse(response.body?.string()))
                else -> response
            }
        } else
            throw NoInternet(NO_INTERNET_CONNECTION)
    }

    private fun getErrorFromResponse(responseAsString: String?): String? {
        val errorString = responseAsString ?: return null
        return try {
            Gson().fromJson(errorString, NetworkErrorContent::class.java).error
        } catch (e: Exception) {
            null
        }
    }
}