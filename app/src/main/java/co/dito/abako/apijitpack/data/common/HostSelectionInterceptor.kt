package co.dito.abako.apijitpack.data.common

import java.net.URISyntaxException
import javax.inject.Inject
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class HostSelectionInterceptor @Inject constructor() : Interceptor {

    fun setHost(url: String) {
        host = url.toHttpUrlOrNull()
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()
        if (host != null) {
            val newUrl: HttpUrl =
                try {
                    var controller = ""
                    request.url.pathSegments.forEach {
                        if (!it.contains("ServicioMovilDITO")) controller += "$it/"
                    }
                    (host.toString() + controller).toHttpUrlOrNull()
                } catch (e: URISyntaxException) {
                    null
                } ?: return chain.proceed(request)

            request = request.newBuilder()
                .url(newUrl)
                .build()
        }
        return chain.proceed(request)
    }

    companion object {
        private var host: HttpUrl? = null
    }
}