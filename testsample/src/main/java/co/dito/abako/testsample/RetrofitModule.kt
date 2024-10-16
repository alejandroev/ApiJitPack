package co.dito.abako.testsample

import android.content.Context
import co.dito.abako.apijitpack.data.common.helper.NetworkHelper
import co.dito.abako.apijitpack.data.network.ConnectionInterceptor
import co.dito.abako.apijitpack.data.network.LoggerInterceptor
import co.dito.abako.apijitpack.domain.RETROFIT_OK_HTTP_CLIENT
import co.dito.abako.apijitpack.domain.RETROFIT_OK_HTTP_CLIENT_FCM
import co.dito.abako.apijitpack.domain.RETROFIT_URL_OLD_API
import co.dito.abako.apijitpack.domain.firebase.usecase.SendSupportResponseUseCase
import co.dito.abako.apijitpack.utils.ApiSharedPreference
import co.dito.abako.apijitpack.utils.backupDocument.BackupDocument
import co.dito.abako.apijitpack.utils.backupDocument.BackupDocumentImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import javax.inject.Named
import javax.inject.Singleton
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

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

    @Singleton
    @Provides
    fun providerBackupDocument(@ApplicationContext context: Context): BackupDocument<BackupOrden> = BackupDocumentImp(context)

    @Named(RETROFIT_OK_HTTP_CLIENT_FCM)
    @Provides
    @Singleton
    fun provideOkHttpClientFCM(
        networkHelper: NetworkHelper,
        sendSupportResponseUseCase: SendSupportResponseUseCase,
        apiSharedPreference: ApiSharedPreference
    ): OkHttpClient =
        OkHttpClient().newBuilder()
            .connectTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
            .readTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .followRedirects(true)
            .followSslRedirects(true)
            .addInterceptor(ConnectionInterceptor(networkHelper))
            .addInterceptor(LoggerInterceptor(sendSupportResponseUseCase, apiSharedPreference))
            .addInterceptor(Interceptor {
                val request = it.request().newBuilder().addHeader(
                    "Authorization",
                    "key=AAAA-UbFDd8:APA91bFGbP-NOX2bznSc15F1rXvBb6RU_mZ6UcsQ3CGaKKH_nfMDa4fGOpACdsYJCc0bH6KLq1TDvLGK1z3E_EJ2zP2f4RStHMsxYlCsUmXezyKw0ttzc5o4b2RH1PnITVg_324w4Wds"
                ).build()
                return@Interceptor it.proceed(request)
            }).build()
}

private const val URL_EXAMPLE_OLD = "http://abako.ditosas.com/ServicioMovilDITO/ServicioMovilDITO.svc/"
private const val URL_MOBILE_API = "https://clouderp.abakoerp.com:9480/ApiMovil/api/"
private const val URL_BUSINESS_API = "https://clouderp.abakoerp.com:9480/ApiNegocio/api/"
private const val TIME_OUT_SECONDS: Long = 200