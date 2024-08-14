package co.dito.abako.apijitpack.domain.favorite

import co.dito.abako.apijitpack.data.model.response.article.APIArticleMasterResponse
import co.dito.abako.apijitpack.data.model.response.favorite.APIDetailFavoriteRequestResponse
import co.dito.abako.apijitpack.domain.article.ArticleRepository
import kotlinx.coroutines.flow.Flow
import java.util.Date
import javax.inject.Inject

class FetchFavoriteArticlesUseCase @Inject constructor(
    private val articleRepository: ArticleRepository
) {

    suspend operator fun invoke(
        date: Date,
        personId: Int,
        isAll: Boolean,
        agency: String,
        articles: List<APIDetailFavoriteRequestResponse>
    ): Flow<APIArticleMasterResponse?> = articleRepository.getFavorites(date, personId, isAll, agency, articles)
}