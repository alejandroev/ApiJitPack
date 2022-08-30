package co.dito.abako.apijitpack.di

import co.dito.abako.apijitpack.data.network.FirebaseApiService
import co.dito.abako.apijitpack.data.repository.FirebaseRepositoryImp
import co.dito.abako.apijitpack.domain.RETROFIT_URL_FIREBASE_API
import co.dito.abako.apijitpack.domain.support.FirebaseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SupportModule {

    @Singleton
    @Provides
    fun providerFirebaseApiService(@Named(RETROFIT_URL_FIREBASE_API) retrofit: Retrofit): FirebaseApiService =
        retrofit.create(FirebaseApiService::class.java)

    @Singleton
    @Provides
    fun providerFirebaseRepository(apiService: FirebaseApiService): FirebaseRepository =
        FirebaseRepositoryImp(apiService)
}