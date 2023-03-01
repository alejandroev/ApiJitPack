package co.dito.abako.apijitpack.domain.article.usecase

import co.dito.abako.apijitpack.data.model.request.banner.APIBannerRequest
import co.dito.abako.apijitpack.data.model.response.banner.APIBannerResponse
import co.dito.abako.apijitpack.domain.article.ArticleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchBannerUseCase @Inject constructor(
    private val articleRepository: ArticleRepository
) {

    suspend operator fun invoke(bannerModelRequest: APIBannerRequest): Flow<APIBannerResponse?> =
        articleRepository.getBanner(bannerModelRequest)
}