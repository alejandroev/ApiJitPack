package co.dito.abako.apijitpack.domain.article

import co.dito.abako.apijitpack.data.model.request.banner.APIBannerRequest
import co.dito.abako.apijitpack.data.model.response.article.APIArticleMasterResponse
import co.dito.abako.apijitpack.data.model.response.article.APIArticleResponse
import co.dito.abako.apijitpack.data.model.response.article.APIPromotionArticleResponse
import co.dito.abako.apijitpack.data.model.response.banner.APIBannerResponse
import co.dito.abako.apijitpack.data.model.response.category.APICategoryResponse
import co.dito.abako.apijitpack.data.model.response.line.APILineResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import java.util.Date

interface ArticleRepository {

    suspend fun fetchPromotionArticles(
        isAll: Boolean,
        currentDate: Date,
        companyId: Int,
        agency: String
    ): Flow<APIPromotionArticleResponse>

    suspend fun fetchArticlesClientFilter(
        date: Date,
        companyId: Int,
        isAll: Boolean,
        typeId: Int,
        type: String,
        agency: String
    ): Flow<APIArticleMasterResponse?>

    suspend fun fetchLineArticle(
        date: Date,
        companyId: Int,
        isAll: Boolean,
    ): Flow<List<APILineResponse>>

    suspend fun searchArticle(
        search: String,
        date: Date,
        companyId: Int,
        agency: String
    ): Flow<APIArticleMasterResponse?>

    suspend fun fetchCategoryArticle(
        date: Date,
        companyId: Int,
        isAll: Boolean,
        lineId: Int
    ): Flow<List<APICategoryResponse>>

    suspend fun getBanner(bannerModelRequest: APIBannerRequest): Flow<APIBannerResponse?>

    suspend fun getBannerArticle(
        code: String,
        companyId: Int,
    ): Flow<APIArticleMasterResponse?   >
}