package co.dito.abako.apijitpack.di

import co.dito.abako.apijitpack.data.network.DeliveryApiService
import co.dito.abako.apijitpack.data.repository.DeliveryRepositoryImp
import co.dito.abako.apijitpack.domain.MOBILE_RETROFIT_API_JITPACK
import co.dito.abako.apijitpack.domain.delivery.DeliveryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
object DeliveryModule {

    @Singleton
    @Provides
    fun providerDeliveryApiService(@Named(MOBILE_RETROFIT_API_JITPACK) retrofit: Retrofit): DeliveryApiService =
        retrofit.create(DeliveryApiService::class.java)

    @Singleton
    @Provides
    fun providerDeliveryRepository(deliveryApiService: DeliveryApiService): DeliveryRepository =
        DeliveryRepositoryImp(deliveryApiService)
}