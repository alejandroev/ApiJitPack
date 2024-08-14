package co.dito.abako.apijitpack.domain.article.usecase

import co.dito.abako.apijitpack.data.model.response.article.APIArticleMasterResponse
import co.dito.abako.apijitpack.data.model.response.article.PlatformType
import co.dito.abako.apijitpack.domain.article.ArticleRepository
import kotlinx.coroutines.flow.Flow
import java.util.*
import javax.inject.Inject

class SearchArticleUseCase @Inject constructor(
    private val articleRepository: ArticleRepository
) {

    suspend operator fun invoke(
        search: String,
        date: Date,
        companyId: Int,
        agency: String,
        platformType: PlatformType
    ): Flow<APIArticleMasterResponse?> =
        articleRepository.searchArticle(search, date, companyId, agency, platformType)
}