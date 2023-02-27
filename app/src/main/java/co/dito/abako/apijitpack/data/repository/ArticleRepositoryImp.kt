package co.dito.abako.apijitpack.data.repository

import co.dito.abako.apijitpack.data.common.utils.REQUEST_DATE_FORMAT
import co.dito.abako.apijitpack.data.common.utils.dateFormat
import co.dito.abako.apijitpack.data.model.response.article.APIPromotionArticleResponse
import co.dito.abako.apijitpack.data.model.response.category.APICategoryResponse
import co.dito.abako.apijitpack.data.model.response.line.APILineResponse
import co.dito.abako.apijitpack.data.network.ArticleMobileAPIService
import co.dito.abako.apijitpack.domain.article.ArticleRepository
import co.dito.abako.apijitpack.utils.extractArray
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.awaitResponse
import java.util.*
import javax.inject.Inject

class ArticleRepositoryImp @Inject constructor(
    private val articleMobileAPIService: ArticleMobileAPIService
) : ArticleRepository {
    override suspend fun fetchPromotionArticles(
        isAll: Boolean,
        currentDate: Date,
        companyId: Int
    ): Flow<APIPromotionArticleResponse> {
        return flow {
            val response = articleMobileAPIService.fetchPromotionArticles(
                isAll = if (isAll) "S" else "N",
                currentDate = currentDate.dateFormat(REQUEST_DATE_FORMAT),
                companyId = companyId
            )
            emit(response)
        }
    }

    override suspend fun fetchLineArticle(
        date: Date,
        companyId: Int,
        isAll: Boolean
    ): Flow<List<APILineResponse>> {
        return flow {
            val response = articleMobileAPIService.fetchLineArticles(
                date = date.dateFormat(REQUEST_DATE_FORMAT),
                companyId = companyId,
                isAll = if (isAll) "S" else "N"
            )
            val apiLineResponse = response.awaitResponse().extractArray(Array<APILineResponse>::class.java, "lineas")?.toList() ?: emptyList()
            emit(apiLineResponse)
        }
    }

    override suspend fun fetchCategoryArticle(
        date: Date,
        companyId: Int,
        isAll: Boolean,
        lineId: Int
    ): Flow<List<APICategoryResponse>> {
        return flow {
            val response = articleMobileAPIService.fetchCategoryArticles(
                companyId = companyId,
                date = date.dateFormat(REQUEST_DATE_FORMAT),
                isAll = if (isAll) "S" else "N",
                lineId = lineId
            )
            val apiCategoryResponse = response.awaitResponse().extractArray(Array<APICategoryResponse>::class.java, key = "categorias")?.toList() ?: emptyList()
            emit(apiCategoryResponse)
        }
    }
}