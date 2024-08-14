package co.dito.abako.apijitpack.di

import co.dito.abako.apijitpack.data.network.NotificationFCMApiService
import co.dito.abako.apijitpack.data.repository.NotificationFCMRepositoryImp
import co.dito.abako.apijitpack.domain.RETROFIT_URL_FCM_API
import co.dito.abako.apijitpack.domain.notification.NotificationFCMRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
object NotificationFCMModule {

    @Singleton
    @Provides
    fun providerNotificationFCMApiService(@Named(RETROFIT_URL_FCM_API) retrofit: Retrofit): NotificationFCMApiService =
        retrofit.create(NotificationFCMApiService::class.java)

    @Singleton
    @Provides
    fun providerNotificationFCMRepository(
        notificationFCMApiService: NotificationFCMApiService
    ) : NotificationFCMRepository = NotificationFCMRepositoryImp(service = notificationFCMApiService)
}