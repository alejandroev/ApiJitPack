package co.dito.abako.apijitpack.di

import co.dito.abako.apijitpack.data.network.GeneralBusinessApiService
import co.dito.abako.apijitpack.data.network.GeneralMobileApiService
import co.dito.abako.apijitpack.data.network.GeneralOldApiService
import co.dito.abako.apijitpack.data.repository.GeneralBackupBackupRepositoryImp
import co.dito.abako.apijitpack.data.repository.GeneralRepositoryImp
import co.dito.abako.apijitpack.domain.RETROFIT_URL_BUSINESS_API
import co.dito.abako.apijitpack.domain.RETROFIT_URL_MOBILE_API
import co.dito.abako.apijitpack.domain.RETROFIT_URL_OLD_API
import co.dito.abako.apijitpack.domain.general.GeneralBackupRepository
import co.dito.abako.apijitpack.domain.general.GeneralRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton
import retrofit2.Retrofit

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
object GeneralModule {

    @Singleton
    @Provides
    fun providerGeneralApiService(@Named(RETROFIT_URL_OLD_API) retrofit: Retrofit): GeneralOldApiService =
        retrofit.create(GeneralOldApiService::class.java)

    @Singleton
    @Provides
    fun providerBusinessApiService(@Named(RETROFIT_URL_BUSINESS_API) retrofit: Retrofit): GeneralBusinessApiService =
        retrofit.create(GeneralBusinessApiService::class.java)

    @Singleton
    @Provides
    fun providerMobileApiService(@Named(RETROFIT_URL_MOBILE_API) retrofit: Retrofit): GeneralMobileApiService =
        retrofit.create(GeneralMobileApiService::class.java)

    @Singleton
    @Provides
    fun providerGeneralBackupRepository(
        generalOldApiService: GeneralOldApiService,
        generalMobileApiService: GeneralMobileApiService
    ): GeneralBackupRepository =
        GeneralBackupBackupRepositoryImp(
            generalOldApiService,
            generalMobileApiService)

    @Singleton
    @Provides
    fun providerGeneralRepository(
        generalMobileApiService: GeneralMobileApiService
    ): GeneralRepository = GeneralRepositoryImp(generalMobileApiService)
}