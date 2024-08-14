package co.dito.abako.apijitpack.di

import co.dito.abako.apijitpack.data.network.ClientAdministrationAPIService
import co.dito.abako.apijitpack.data.network.ClientBusinessApiService
import co.dito.abako.apijitpack.data.network.ClientMobileApiService
import co.dito.abako.apijitpack.data.repository.ClientRepositoryImp
import co.dito.abako.apijitpack.domain.RETROFIT_URL_ADMINISTRATION_API
import co.dito.abako.apijitpack.domain.RETROFIT_URL_BUSINESS_API
import co.dito.abako.apijitpack.domain.RETROFIT_URL_MOBILE_API
import co.dito.abako.apijitpack.domain.RETROFIT_URL_SHOPPING_CART_API
import co.dito.abako.apijitpack.domain.client.ClientRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ClientModule {
    @Singleton
    @Provides
    fun providerClientBusinessApiService(@Named(RETROFIT_URL_BUSINESS_API) retrofit: Retrofit): ClientBusinessApiService =
        retrofit.create(ClientBusinessApiService::class.java)

    @Singleton
    @Provides
    fun providerClientMobileApiService(@Named(RETROFIT_URL_MOBILE_API) retrofit: Retrofit): ClientMobileApiService =
        retrofit.create(ClientMobileApiService::class.java)

    @Singleton
    @Provides
    fun providerClientAdministrationApiService(@Named(RETROFIT_URL_ADMINISTRATION_API) retrofit: Retrofit): ClientAdministrationAPIService =
        retrofit.create(ClientAdministrationAPIService::class.java)

    @Singleton
    @Provides
    fun providerClientRepository(
        clientBusinessApiService: ClientBusinessApiService,
        clientMobileApiService: ClientMobileApiService,
        clientAdministrationAPIService: ClientAdministrationAPIService
    ): ClientRepository =
        ClientRepositoryImp(
            clientBusinessApiService = clientBusinessApiService,
            clientMobileApiService = clientMobileApiService,
            clientAdministrationAPIService = clientAdministrationAPIService
        )
}