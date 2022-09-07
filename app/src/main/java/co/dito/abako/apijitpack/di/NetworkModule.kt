package co.dito.abako.apijitpack.di

import android.content.Context
import co.dito.abako.apijitpack.BuildConfig
import co.dito.abako.apijitpack.data.common.helper.NetworkHelper
import co.dito.abako.apijitpack.data.common.helper.NetworkHelperImp
import co.dito.abako.apijitpack.data.network.ConnectionInterceptor
import co.dito.abako.apijitpack.data.network.LoggerInterceptor
import co.dito.abako.apijitpack.data.repository.utils.ErrorProcessor
import co.dito.abako.apijitpack.data.repository.utils.ErrorProcessorImp
import co.dito.abako.apijitpack.domain.ERROR_PROCESSOR_API
import co.dito.abako.apijitpack.domain.RETROFIT_OK_HTTP_CLIENT
import co.dito.abako.apijitpack.domain.RETROFIT_OK_HTTP_CLIENT_FIREBASE
import co.dito.abako.apijitpack.domain.RETROFIT_URL_FIREBASE_API
import co.dito.abako.apijitpack.domain.support.usecase.SendSupportResponseUseCase
import co.dito.abako.apijitpack.utils.ApiSharedPreference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Named(RETROFIT_OK_HTTP_CLIENT_FIREBASE)
    @Provides
    @Singleton
    fun provideOkHttpClientFirebase(
        @ApplicationContext context: Context,
        networkHelper: NetworkHelper
    ): OkHttpClient {
        return if (BuildConfig.DEBUG) {
            OkHttpClient().newBuilder()
                .cache(Cache(context.cacheDir, (5 * 1024 * 1024).toLong()))
                .connectTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .followRedirects(true)
                .followSslRedirects(true)
                .addInterceptor(ConnectionInterceptor(networkHelper))
                .build()
        } else {
            OkHttpClient().newBuilder()
                .connectTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .followRedirects(true)
                .followSslRedirects(true)
                .addInterceptor(ConnectionInterceptor(networkHelper))
                .build()
        }
    }

    @Named(RETROFIT_OK_HTTP_CLIENT)
    @Provides
    @Singleton
    fun provideOkHttpClient(
        @ApplicationContext context: Context,
        networkHelper: NetworkHelper,
        sendSupportResponseUseCase: SendSupportResponseUseCase,
        apiSharedPreference: ApiSharedPreference
    ): OkHttpClient {
        return if (BuildConfig.DEBUG) {
            OkHttpClient().newBuilder()
                .cache(Cache(context.cacheDir, (5 * 1024 * 1024).toLong()))
                .connectTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .followRedirects(true)
                .followSslRedirects(true)
                .addInterceptor(ConnectionInterceptor(networkHelper))
                .addInterceptor(LoggerInterceptor(sendSupportResponseUseCase, apiSharedPreference))
                .build()
        } else {
            OkHttpClient().newBuilder()
                .connectTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .followRedirects(true)
                .followSslRedirects(true)
                .addInterceptor(ConnectionInterceptor(networkHelper))
                .addInterceptor(LoggerInterceptor(sendSupportResponseUseCase, apiSharedPreference))
                .build()
        }
    }

    @Named(RETROFIT_URL_FIREBASE_API)
    @Singleton
    @Provides
    fun providerRetrofit(@Named(RETROFIT_OK_HTTP_CLIENT_FIREBASE) okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL_FIREBASE_DEFAULT)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providerHelper(@ApplicationContext context: Context): NetworkHelper =
        NetworkHelperImp(context)

    @Named(ERROR_PROCESSOR_API)
    @Singleton
    @Provides
    fun providerErrorProcessor(): ErrorProcessor = ErrorProcessorImp()
}

private const val URL_FIREBASE_DEFAULT = "https://us-central1-codi-abako.cloudfunctions.net/"
private const val TIME_OUT_SECONDS: Long = 200