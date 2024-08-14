package co.dito.abako.apijitpack.domain.article.usecase

import co.dito.abako.apijitpack.data.model.response.article.APIArticleMasterResponse
import co.dito.abako.apijitpack.data.model.response.article.APIArticleResponse
import co.dito.abako.apijitpack.data.model.response.article.PlatformType
import co.dito.abako.apijitpack.domain.article.ArticleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchBannerArticleUseCase @Inject constructor(
    private val articleRepository: ArticleRepository
) {

    suspend operator fun invoke(
        code: String,
        companyId: Int,
        platformType: PlatformType
    ): Flow<APIArticleMasterResponse?> =
        articleRepository.getBannerArticle(code = code, companyId = companyId, platformType = platformType)
}