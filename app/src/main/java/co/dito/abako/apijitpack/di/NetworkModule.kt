package co.dito.abako.apijitpack.di

import co.dito.abako.apijitpack.data.network.DeliveryApiService
import co.dito.abako.apijitpack.data.network.GeneralApiService
import co.dito.abako.apijitpack.data.network.OrderApiService
import co.dito.abako.apijitpack.data.network.SupervisorApiService
import co.dito.abako.apijitpack.data.network.WorkShopApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val URL_FIREBASE_DEFAULT = "https://us-central1-codi-abako.cloudfunctions.net/"

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providerRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL_FIREBASE_DEFAULT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providerDeliveryApiService(retrofit: Retrofit): DeliveryApiService {
        return retrofit.create(DeliveryApiService::class.java)
    }

    @Singleton
    @Provides
    fun providerGeneralApiService(retrofit: Retrofit): GeneralApiService {
        return retrofit.create(GeneralApiService::class.java)
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