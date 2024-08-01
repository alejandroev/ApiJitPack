package co.dito.abako.apijitpack.domain.article.usecase


import co.dito.abako.apijitpack.data.model.response.service.ProgrammingResponse
import co.dito.abako.apijitpack.domain.article.ArticleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchProgramacionUseCase @Inject constructor(
    private val articleRepository: ArticleRepository
) {

    suspend operator fun invoke(
        idPersona: String
    ): Flow<ProgrammingResponse> =
        articleRepository.fetchProgramacion(
            idPersona
        )
}