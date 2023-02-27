package co.dito.abako.apijitpack.data.network

import co.dito.abako.apijitpack.data.model.response.article.APIPromotionArticleResponse
import co.dito.abako.apijitpack.data.model.response.category.APICategoryResponse
import co.dito.abako.apijitpack.data.model.response.line.APILineResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ArticleMobileAPIService {

    @GET("Articulos/RecuperarArticuloPromocion/{isAll}/{currentDate}/{companyId}")
    suspend fun fetchPromotionArticles(
        @Path("isAll") isAll: String,
        @Path("currentDate") currentDate: String,
        @Path("companyId") companyId: Int
    ): APIPromotionArticleResponse

    @GET("Lineas/{Fecha}/{IdEmpresa}/{EsTodo}")
    fun fetchLineArticles(
        @Path("Fecha") date: String,
        @Path("IdEmpresa") companyId: Int,
        @Path("EsTodo") isAll: String
    ): Call<ResponseBody?>

    @GET("Categorias/{Fecha}/{IdEmpresa}/{EsTodo}/{IdLinea}")
    fun fetchCategoryArticles(
        @Path("Fecha") date: String,
        @Path("IdEmpresa") companyId: Int,
        @Path("EsTodo") isAll: String,
        @Path("IdLinea") lineId: Int
    ): Call<ResponseBody?>
}