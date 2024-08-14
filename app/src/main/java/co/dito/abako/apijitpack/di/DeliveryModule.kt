package co.dito.abako.apijitpack.di

import co.dito.abako.apijitpack.data.network.DeliveryOldApiService
import co.dito.abako.apijitpack.data.network.GeneralBusinessApiService
import co.dito.abako.apijitpack.data.network.GeneralMobileApiService
import co.dito.abako.apijitpack.data.repository.DeliveryRepositoryImp
import co.dito.abako.apijitpack.data.repository.GeneralRepositoryImp
import co.dito.abako.apijitpack.domain.RETROFIT_URL_OLD_API
import co.dito.abako.apijitpack.domain.delivery.DeliveryRepository
import co.dito.abako.apijitpack.domain.general.GeneralRepository
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
    fun providerDeliveryApiService(@Named(RETROFIT_URL_OLD_API) retrofit: Retrofit): DeliveryOldApiService =
        retrofit.create(DeliveryOldApiService::class.java)

    @Singleton
    @Provides
    fun providerDeliveryRepository(
        deliveryApiService: DeliveryOldApiService,
        generalMobileApiService: GeneralMobileApiService
    ): DeliveryRepository = DeliveryRepositoryImp(
        deliveryApiService = deliveryApiService,
        generalMobileApiService = generalMobileApiService
    )
}