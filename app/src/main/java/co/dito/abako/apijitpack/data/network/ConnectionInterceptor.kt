package co.dito.abako.apijitpack.data.network

import co.dito.abako.apijitpack.data.common.helper.NetworkHelper
import co.dito.abako.apijitpack.data.common.utils.NetworkErrorContent
import co.dito.abako.apijitpack.data.common.utils.NetworkException
import co.dito.abako.apijitpack.domain.NO_INTERNET_CONNECTION
import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.net.ConnectException
import java.net.HttpURLConnection

class ConnectionInterceptor(
    private val networkHelper: NetworkHelper,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        return if (networkHelper.isInternetAvailable()) {
            try {
                val response = chain.proceed(originalRequest)
                when (response.code()) {
                    HttpURLConnection.HTTP_NOT_FOUND -> throw NetworkException.NotFound(
                        getErrorFromResponse(response.body()?.string())
                    )
                    HttpURLConnection.HTTP_NOT_ACCEPTABLE,
                    HttpURLConnection.HTTP_BAD_REQUEST -> throw NetworkException.BadRequest(
                        getErrorFromResponse(response.body()?.string())
                    )
                    HttpURLConnection.HTTP_INTERNAL_ERROR -> throw NetworkException.ServerError(
                        getErrorFromResponse(response.body()?.string())
                    )
                    HttpURLConnection.HTTP_FORBIDDEN -> throw NetworkException.Unauthorized(
                        getErrorFromResponse(response.body()?.string())
                    )
                    else -> {
                        response
                    }
                }
            } catch (e: IOException) {
                throw when (e) {
                    is ConnectException -> NetworkException.Connection(e.message)
                    else -> NetworkException.TimeOut(NO_INTERNET_CONNECTION)
                }
            }
        } else
            throw NetworkException.NoInternet(NO_INTERNET_CONNECTION)
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