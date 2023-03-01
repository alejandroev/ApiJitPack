package co.dito.abako.apijitpack.domain.article.usecase

import co.dito.abako.apijitpack.data.model.response.article.APIArticleMasterResponse
import co.dito.abako.apijitpack.domain.article.ArticleRepository
import kotlinx.coroutines.flow.Flow
import java.util.*
import javax.inject.Inject

class FetchArticleClientFilterUseCase @Inject constructor(
    private val articleRepository: ArticleRepository
) {

    suspend operator fun invoke(
        date: Date,
        companyId: Int,
        isAll: Boolean,
        typeId: Int,
        type: String,
        agency: String
    ): Flow<APIArticleMasterResponse?> =
        articleRepository.fetchArticlesClientFilter(
            date, companyId, isAll, typeId, type, agency
        )
}