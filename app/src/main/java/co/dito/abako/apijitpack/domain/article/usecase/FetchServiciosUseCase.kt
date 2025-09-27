package co.dito.abako.apijitpack.domain.article.usecase


import co.dito.abako.apijitpack.data.model.request.MessageServiceResponse
import co.dito.abako.apijitpack.data.model.request.ServiciosRequest
import co.dito.abako.apijitpack.domain.article.ArticleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchServiciosUseCase @Inject constructor(
    private val articleRepository: ArticleRepository
) {
    suspend operator fun invoke(
        serviciosRequest: ServiciosRequest
    ): Flow<MessageServiceResponse> =
        articleRepository.actualizarDetalleProgramacion(
            serviciosRequest
        )
}