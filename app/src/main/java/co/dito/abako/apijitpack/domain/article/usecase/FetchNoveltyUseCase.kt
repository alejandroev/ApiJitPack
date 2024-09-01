package co.dito.abako.apijitpack.domain.article.usecase


import co.dito.abako.apijitpack.data.model.response.novelty.NoveltyModelResponse
import co.dito.abako.apijitpack.domain.article.ArticleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchNoveltyUseCase @Inject constructor(
    private val articleRepository: ArticleRepository
) {
    suspend operator fun invoke(
        fecha: String, esTodo: String
    ): Flow<NoveltyModelResponse> =
        articleRepository.getNovelty(
            fecha, esTodo
        )
}