package co.dito.abako.apijitpack.di

import android.content.Context
import co.dito.abako.apijitpack.BuildConfig
import co.dito.abako.apijitpack.data.common.HostSelectionInterceptor
import co.dito.abako.apijitpack.data.network.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val URL_FIREBASE_DEFAULT = "https://us-central1-codi-abako.cloudfunctions.net/"
private const val TIME_OUT_SECONDS: Long = 200


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(
        @ApplicationContext context: Context,
        hostSelectionInterceptor: HostSelectionInterceptor
    ): OkHttpClient {
        return if (BuildConfig.DEBUG) {
            OkHttpClient().newBuilder()
                .cache(Cache(context.cacheDir, (5 * 1024 * 1024).toLong()))
                .retryOnConnectionFailure(false)
                .connectTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
                .addInterceptor(hostSelectionInterceptor)
                .followRedirects(true)
                .followSslRedirects(true)
                /*.addInterceptor {
                    val response = it.proceed(it.request())
                    if (response.code() >= 400 || !response.isSuccessful)
                        throw DitoException("No se pudo conectar al servidor, revise su conexión a Internet.")
                    return@addInterceptor response
                }*/
                .build()
        } else {
            OkHttpClient().newBuilder()
                .connectTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
                .retryOnConnectionFailure(false)
                .followRedirects(true)
                .followSslRedirects(true)
                .addInterceptor(hostSelectionInterceptor)
                .build()
        }
    }

    @Singleton
    @Provides
    fun providerRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL_FIREBASE_DEFAULT)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providerOrderApiService(retrofit: Retrofit): OrderApiService {
        return retrofit.create(OrderApiService::class.java)
    }

    @Singleton
    @Provides
    fun providerSupervisorApiService(retrofit: Retrofit): SupervisorApiService {
        return retrofit.create(SupervisorApiService::class.java)
    }

    @Singleton
    @Provides
    fun providerWorkShopApiService(retrofit: Retrofit): WorkShopApiService {
        return retrofit.create(WorkShopApiService::class.java)
    }
}