package co.dito.abako.apijitpack.domain.article.usecase

import co.dito.abako.apijitpack.data.model.response.line.APILineResponse
import co.dito.abako.apijitpack.domain.article.ArticleRepository
import kotlinx.coroutines.flow.Flow
import java.util.*
import javax.inject.Inject

class FetchLineArticlesUseCase @Inject constructor(
    private val articleRepository: ArticleRepository
) {

    suspend operator fun invoke(date: Date, companyId: Int, isAll: Boolean): Flow<List<APILineResponse>> =
        articleRepository.fetchLineArticle(date = date, companyId = companyId, isAll = isAll)
}