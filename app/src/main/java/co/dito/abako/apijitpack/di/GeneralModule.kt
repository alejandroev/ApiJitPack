package co.dito.abako.apijitpack.di

import co.dito.abako.apijitpack.data.network.GeneralApiService
import co.dito.abako.apijitpack.data.repository.GeneralRepositoryImp
import co.dito.abako.apijitpack.domain.MOBILE_RETROFIT_API_JITPACK
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
object GeneralModule {

    @Singleton
    @Provides
    fun providerGeneralApiService(@Named(MOBILE_RETROFIT_API_JITPACK) retrofit: Retrofit): GeneralApiService =
        retrofit.create(GeneralApiService::class.java)

    @Singleton
    @Provides
    fun providerGeneralRepository(generalApiService: GeneralApiService): GeneralRepository =
        GeneralRepositoryImp(generalApiService)
}