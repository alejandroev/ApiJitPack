package co.dito.abako.apijitpack.data.network

import co.dito.abako.apijitpack.data.model.response.article.APIPromotionArticleResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ArticleMobileAPIService {

    @GET("Articulos/RecuperarArticuloPromocion/{isAll}/{currentDate}/{companyId}")
    suspend fun fetchPromotionArticles(
        @Path("isAll") isAll: String,
        @Path("currentDate") currentDate: String,
        @Path("companyId") companyId: Int
    ): APIPromotionArticleResponse
}