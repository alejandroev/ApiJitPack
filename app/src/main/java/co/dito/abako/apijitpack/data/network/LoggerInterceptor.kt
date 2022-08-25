package co.dito.abako.apijitpack.data.network

import android.util.Log
import co.dito.abako.apijitpack.utils.sendEmail.EmailSender
import co.dito.abako.apijitpack.utils.sendEmail.data.EmailBodyError
import co.dito.abako.apijitpack.utils.sendEmail.data.EmailData
import co.dito.abako.apijitpack.utils.sendEmail.data.EmailType
import com.google.gson.Gson
import java.net.HttpURLConnection
import java.net.URI
import kotlin.coroutines.Continuation
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.RequestBody
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import okio.Buffer

@OptIn(DelicateCoroutinesApi::class)
class LoggerInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        var responseBody = ""
        response.body?.let { responseBody = it.string() }

        val timeResponse = response.receivedResponseAtMillis - response.sentRequestAtMillis
        Log.i(EVENT_NAME_TAG, "<-- ${request.url.toUri()} $timeResponse ms")
        Log.i(EVENT_NAME_TAG, Gson().toJson(request.body.bodyToString()))
        Log.i(EVENT_NAME_TAG, response.code.toString())
        Log.i(EVENT_NAME_TAG, responseBody)
        Log.i(EVENT_NAME_TAG, "<-- END ${request.method}")

        if (validIfError(resultCode = response.code)) {
            sendNotificationError(request.url, request.body.bodyToString(), response.code, responseBody, timeResponse)
        }

        return response.newBuilder().body(responseBody.toResponseBody(response.body?.contentType())).build()
    }

    private fun validIfError(resultCode: Int) : Boolean {
        return resultCode == HttpURLConnection.HTTP_NOT_FOUND ||
                resultCode == HttpURLConnection.HTTP_NOT_ACCEPTABLE ||
                resultCode == HttpURLConnection.HTTP_BAD_REQUEST ||
                resultCode == HttpURLConnection.HTTP_INTERNAL_ERROR ||
                resultCode == HttpURLConnection.HTTP_FORBIDDEN
    }

     private fun sendNotificationError(url: HttpUrl, request: String, code: Int, responseBody: String, timeResponse: Long) {
        GlobalScope.launch {
            val data = EmailData(
                title = "Error Server",
                bodyError = EmailBodyError(
                    url = url.toString(),
                    request = request,
                    resultCode = code,
                    response = responseBody,
                    timeResponse = timeResponse
                ),
                type = EmailType.AUTOMATIC
            )

            EmailSender().sendEmail(data)
        }
    }

    private fun RequestBody?.bodyToString(): String {
        val buffer = Buffer()
        if (this != null) this.writeTo(buffer) else return ""
        return buffer.readUtf8()
    }
}

private const val EVENT_NAME_TAG = "Abako Request"