package co.dito.abako.apijitpack.di

import co.dito.abako.apijitpack.data.network.WompiAPIService
import co.dito.abako.apijitpack.data.repository.WompiRepositoryImp
import co.dito.abako.apijitpack.domain.RETROFIT_URL_BUSINESS_API
import co.dito.abako.apijitpack.domain.wompi.WompiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
object WompiModule {

    @Singleton
    @Provides
    fun providerWompiAPIService(@Named(RETROFIT_URL_BUSINESS_API) retrofit: Retrofit): WompiAPIService = retrofit.create(WompiAPIService::class.java)

    @Singleton
    @Provides
    fun providerWompiRepository(wompiAPIService: WompiAPIService): WompiRepository = WompiRepositoryImp(wompiAPIService = wompiAPIService)
}