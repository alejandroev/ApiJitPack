package co.dito.abako.apijitpack.di

import co.dito.abako.apijitpack.data.network.ArticleMobileAPIService
import co.dito.abako.apijitpack.data.repository.ArticleRepositoryImp
import co.dito.abako.apijitpack.domain.RETROFIT_URL_MOBILE_API
import co.dito.abako.apijitpack.domain.article.ArticleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ArticleModule {

    @Singleton
    @Provides
    fun providerArticleMobileApiService(@Named(RETROFIT_URL_MOBILE_API) retrofit: Retrofit): ArticleMobileAPIService =
        retrofit.create(ArticleMobileAPIService::class.java)

    @Singleton
    @Provides
    fun providerArticleRepository(
        articleMobileAPIService: ArticleMobileAPIService
    ): ArticleRepository =
        ArticleRepositoryImp(
            articleMobileAPIService = articleMobileAPIService
        )
}