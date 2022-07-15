package co.dito.abako.testsample

import co.dito.abako.apijitpack.domain.RETROFIT_OK_HTTP_CLIENT
import co.dito.abako.apijitpack.domain.RETROFIT_URL_BUSINESS_API
import co.dito.abako.apijitpack.domain.RETROFIT_URL_MOBILE_API
import co.dito.abako.apijitpack.domain.RETROFIT_URL_OLD_API
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Named(RETROFIT_URL_OLD_API)
    @Singleton
    @Provides
    fun providerRetrofitOld(@Named(RETROFIT_OK_HTTP_CLIENT) okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL_EXAMPLE_OLD)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Named(RETROFIT_URL_MOBILE_API)
    @Singleton
    @Provides
    fun providerRetrofitMobile(@Named(RETROFIT_OK_HTTP_CLIENT) okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL_MOBILE_API)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Named(RETROFIT_URL_BUSINESS_API)
    @Singleton
    @Provides
    fun providerRetrofitBusiness(@Named(RETROFIT_OK_HTTP_CLIENT) okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL_BUSINESS_API)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

private const val URL_EXAMPLE_OLD = "http://abako.ditosas.com/ServicioMovilDITO/ServicioMovilDITO.svc/"
private const val URL_MOBILE_API = "https://clouderp.abakoerp.com:9480/ApiMovil/api/"
private const val URL_BUSINESS_API = "https://clouderp.abakoerp.com:9480/ApiNegocio/api/"