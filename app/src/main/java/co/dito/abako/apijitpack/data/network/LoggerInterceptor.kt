package co.dito.abako.apijitpack.data.network

import android.util.Log
import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.RequestBody
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import okio.Buffer

class LoggerInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        var responseBody = ""
        response.body?.let { responseBody = it.string() }

        Log.i(EVENT_NAME_TAG, "<-- ${request.url.toUri()} ${response.receivedResponseAtMillis - response.sentRequestAtMillis}ms")
        Log.i(EVENT_NAME_TAG, Gson().toJson(request.body.bodyToString()))
        Log.i(EVENT_NAME_TAG, responseBody)
        Log.i(EVENT_NAME_TAG, "<-- END ${request.method}")
        return response.newBuilder().body(responseBody.toResponseBody(response.body?.contentType())).build()
    }

    private fun RequestBody?.bodyToString(): String {
        val buffer = Buffer()
        if (this != null) this.writeTo(buffer) else return ""
        return buffer.readUtf8()
    }
}

private const val EVENT_NAME_TAG = "Abako Request"