package co.dito.abako.apijitpack.di

import co.dito.abako.apijitpack.data.network.ClientApiService
import co.dito.abako.apijitpack.data.network.FirebaseApiService
import co.dito.abako.apijitpack.data.repository.ClientRepositoryImp
import co.dito.abako.apijitpack.data.repository.FirebaseRepositoryImp
import co.dito.abako.apijitpack.domain.RETROFIT_URL_BUSINESS_API
import co.dito.abako.apijitpack.domain.RETROFIT_URL_FIREBASE_API
import co.dito.abako.apijitpack.domain.client.ClientRepository
import co.dito.abako.apijitpack.domain.firebase.FirebaseRepository
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
    fun providerClientApiService(@Named(RETROFIT_URL_BUSINESS_API) retrofit: Retrofit): ClientApiService =
        retrofit.create(ClientApiService::class.java)

    @Singleton
    @Provides
    fun providerClientRepository(clientApiService: ClientApiService): ClientRepository =
        ClientRepositoryImp(clientApiService = clientApiService)
}