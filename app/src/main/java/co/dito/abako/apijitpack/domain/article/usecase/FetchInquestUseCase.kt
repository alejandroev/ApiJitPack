package co.dito.abako.apijitpack.domain.article.usecase


import co.dito.abako.apijitpack.data.model.request.InquestRequest
import co.dito.abako.apijitpack.data.model.response.InquestModelResponse
import co.dito.abako.apijitpack.domain.article.ArticleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchInquestUseCase @Inject constructor(
    private val articleRepository: ArticleRepository
) {
    suspend operator fun invoke(
        inquestRequest: InquestRequest
    ): Flow<InquestModelResponse> =
        articleRepository.fetchInquest(
            inquestRequest
        )
}