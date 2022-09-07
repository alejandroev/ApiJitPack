package co.dito.abako.apijitpack.di

import android.content.Context
import android.content.SharedPreferences
import co.dito.abako.apijitpack.API_SHARE_PREFERENCES
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharePreferenceModule {

    @Named(API_SHARE_PREFERENCES)
    @Provides
    @Singleton
    fun providerSharedPreferences(@ApplicationContext appContext: Context): SharedPreferences =
        appContext.getSharedPreferences(API_SHARE_PREFERENCES, Context.MODE_PRIVATE)
}