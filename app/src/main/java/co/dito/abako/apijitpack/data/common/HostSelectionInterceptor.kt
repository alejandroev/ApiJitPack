package co.dito.abako.apijitpack.data.common

import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.net.URISyntaxException
import javax.inject.Inject

class HostSelectionInterceptor @Inject constructor() : Interceptor {

    @Volatile
    private var host: HttpUrl? = null

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