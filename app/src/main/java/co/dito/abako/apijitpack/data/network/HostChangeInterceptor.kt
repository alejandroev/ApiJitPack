package co.dito.abako.apijitpack.data.network

import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.net.URISyntaxException
import javax.inject.Inject

class HostChangeInterceptor @Inject constructor() : Interceptor {

    companion object {
        private var host: HttpUrl? = null
    }

    fun setHost(url: String) {
        host = url.toHttpUrlOrNull()
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()
        host?.let { host ->
            val newUrl: HttpUrl =
                try {
                    request.url.newBuilder()
                        .scheme(host.scheme)
                        .host(host.toUrl().toURI().host)
                        .port(host.port)
                        .build()
                } catch (e: URISyntaxException) {
                    null
                } ?: return chain.proceed(request)

            request = request.newBuilder()
                .url(newUrl)
                .build()
        }
        return chain.proceed(request)
    }
}