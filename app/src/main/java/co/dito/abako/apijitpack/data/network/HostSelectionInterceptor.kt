package co.dito.abako.apijitpack.data.network

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class HostSelectionInterceptor : Interceptor {

    @Volatile
    private var host = HttpUrl.parse("")

    fun setHost(url: String) {
        host = HttpUrl.parse(url)
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()
        return chain.proceed(request)
    }
}