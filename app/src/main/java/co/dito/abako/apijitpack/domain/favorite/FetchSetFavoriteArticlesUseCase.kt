package co.dito.abako.apijitpack.domain.favorite

import co.dito.abako.apijitpack.data.model.request.favorite.APIFavoriteRequest
import co.dito.abako.apijitpack.data.model.response.favorite.APIFavoriteResponse
import co.dito.abako.apijitpack.domain.article.ArticleRepository
import javax.inject.Inject

class FetchSetFavoriteArticlesUseCase @Inject constructor(
    private val articleRepository: ArticleRepository
) {

    suspend operator fun invoke(apiFavoriteRequest: APIFavoriteRequest): APIFavoriteResponse =
        articleRepository.getSetFavoriteArticles(apiFavoriteRequest)
}