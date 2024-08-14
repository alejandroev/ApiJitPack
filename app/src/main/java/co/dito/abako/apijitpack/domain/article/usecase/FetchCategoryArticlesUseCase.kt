package co.dito.abako.apijitpack.domain.article.usecase

import co.dito.abako.apijitpack.data.model.response.category.APICategoryResponse
import co.dito.abako.apijitpack.domain.article.ArticleRepository
import kotlinx.coroutines.flow.Flow
import java.util.Date
import javax.inject.Inject

class FetchCategoryArticlesUseCase @Inject constructor(
    private val articleRepository: ArticleRepository
) {

    suspend operator fun invoke(date: Date, companyId: Int, isAll: Boolean, lineId: Int): Flow<List<APICategoryResponse>> =
        articleRepository.fetchCategoryArticle(date = date, companyId = companyId, isAll = isAll, lineId = lineId)


}