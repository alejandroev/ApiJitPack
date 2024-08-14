package co.dito.abako.apijitpack.domain.article.usecase


import co.dito.abako.apijitpack.data.model.response.service.ProgrammingDetailResponse
import co.dito.abako.apijitpack.domain.article.ArticleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchProgramacionDetailUseCase @Inject constructor(
    private val articleRepository: ArticleRepository
) {

    suspend operator fun invoke(
        id: String
    ): Flow<ProgrammingDetailResponse> =
        articleRepository.fetchProgramacionDetail(
            id
        )
}