package co.dito.abako.apijitpack.di

import co.dito.abako.apijitpack.data.network.GeneralOldApiService
import co.dito.abako.apijitpack.data.repository.GeneralRepositoryImp
import co.dito.abako.apijitpack.domain.RETROFIT_URL_OLD_API
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
    fun providerGeneralApiService(@Named(RETROFIT_URL_OLD_API) retrofit: Retrofit): GeneralOldApiService =
        retrofit.create(GeneralOldApiService::class.java)

    @Singleton
    @Provides
    fun providerGeneralRepository(generalApiService: GeneralOldApiService): GeneralRepository =
        GeneralRepositoryImp(generalApiService)
}