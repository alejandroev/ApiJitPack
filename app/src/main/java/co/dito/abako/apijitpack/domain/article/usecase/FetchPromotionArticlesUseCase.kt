package co.dito.abako.apijitpack.domain.article.usecase

import co.dito.abako.apijitpack.data.model.response.article.APIPromotionArticleResponse
import co.dito.abako.apijitpack.domain.article.ArticleRepository
import kotlinx.coroutines.flow.Flow
import java.util.*
import javax.inject.Inject

class FetchPromotionArticlesUseCase @Inject constructor(
    private val articleRepository: ArticleRepository
) {

    suspend operator fun invoke(companyId: Int, isAll: Boolean, currentDate: Date): Flow<APIPromotionArticleResponse> =
        articleRepository.fetchPromotionArticles(companyId = companyId, isAll = isAll, currentDate = currentDate)
}