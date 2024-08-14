package co.dito.abako.apijitpack.domain.article.usecase

import co.dito.abako.apijitpack.data.model.response.article.APIArticleMasterResponse
import co.dito.abako.apijitpack.data.model.response.article.PlatformType
import co.dito.abako.apijitpack.data.model.response.asesor.PermisosAsesorMarca
import co.dito.abako.apijitpack.domain.article.ArticleRepository
import kotlinx.coroutines.flow.Flow
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class PermiseMarcaUseCase @Inject constructor(
    private val articleRepository: ArticleRepository
) {

    suspend operator fun invoke(
        companyId: Int,
    ): ArrayList<PermisosAsesorMarca> =
        articleRepository.permisosAsesorMarca(
            companyId
        )
}