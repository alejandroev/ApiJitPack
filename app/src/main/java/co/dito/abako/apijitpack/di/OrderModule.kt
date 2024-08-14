package co.dito.abako.apijitpack.di

import co.dito.abako.apijitpack.data.network.OrderMobileApiService
import co.dito.abako.apijitpack.data.repository.OrderRepositoryImp
import co.dito.abako.apijitpack.domain.RETROFIT_URL_MOBILE_API
import co.dito.abako.apijitpack.domain.order.OrderRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
object OrderModule {

    @Singleton
    @Provides
    fun providerMobileApiService(@Named(RETROFIT_URL_MOBILE_API) retrofit: Retrofit): OrderMobileApiService =
        retrofit.create(OrderMobileApiService::class.java)

    @Singleton
    @Provides
    fun providerOrderRepository(orderMobileApiService: OrderMobileApiService): OrderRepository =
        OrderRepositoryImp(orderMobileApiService)
}