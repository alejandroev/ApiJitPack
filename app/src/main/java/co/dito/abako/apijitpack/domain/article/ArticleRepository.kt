package co.dito.abako.apijitpack.domain.article

import co.dito.abako.apijitpack.data.model.response.article.APIPromotionArticleResponse
import co.dito.abako.apijitpack.data.model.response.category.APICategoryResponse
import co.dito.abako.apijitpack.data.model.response.line.APILineResponse
import kotlinx.coroutines.flow.Flow
import java.util.Date

interface ArticleRepository {

    suspend fun fetchPromotionArticles(
        isAll: Boolean,
        currentDate: Date,
        companyId: Int
    ): Flow<APIPromotionArticleResponse>

    suspend fun fetchLineArticle(
        date: Date,
        companyId: Int,
        isAll: Boolean,
    ): Flow<List<APILineResponse>>

    suspend fun fetchCategoryArticle(
        date: Date,
        companyId: Int,
        isAll: Boolean,
        lineId: Int
    ): Flow<List<APICategoryResponse>>
}