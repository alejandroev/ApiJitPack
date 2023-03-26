package co.dito.abako.apijitpack.data.network

import co.dito.abako.apijitpack.data.model.request.favorite.APIArticleFavoriteRequest
import co.dito.abako.apijitpack.data.model.request.favorite.APIFavoriteRequest
import co.dito.abako.apijitpack.data.model.response.article.APIArticleMasterResponse
import co.dito.abako.apijitpack.data.model.response.article.APIPromotionArticleResponse
import co.dito.abako.apijitpack.data.model.response.favorite.APIFavoriteResponse
import co.dito.abako.apijitpack.data.model.response.price.APIPriceArticleResponse
import co.dito.abako.apijitpack.data.model.response.price.APIPriceMasterResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ArticleMobileAPIService {

    @GET("Articulos/RecuperarArticuloPromocion/{isAll}/{currentDate}/{companyId}")
    suspend fun fetchPromotionArticles(
        @Path("isAll") isAll: String,
        @Path("currentDate") currentDate: String,
        @Path("companyId") companyId: Int
    ): APIPromotionArticleResponse

    @GET("Inventario/RecuperarArticuloInventarioPromocion/{currentDate}/{companyId}/{agency}")
    fun fetchPromotionInventory(
        @Path("currentDate") currentDate: String,
        @Path("companyId") companyId: Int,
        @Path("agency") agency: String
    ): Call<ResponseBody?>

    @GET("Articulos/RecuperarArticuloClienteFiltro/{date}/{companyId}/{isAll}/{typeId}/{type}")
    suspend fun fetchArticleClientFilter(
        @Path("date") date: String,
        @Path("companyId") companyId: Int,
        @Path("isAll") isAll: String,
        @Path("typeId") typeId: Int,
        @Path("type") type: String,
    ): APIArticleMasterResponse?

    @GET("Precios/RecuperarPrecioClienteFiltro/{date}/{companyId}/{isAll}/{typeId}/{type}")
    suspend fun fetchPriceClientFilter(
        @Path("date") date: String,
        @Path("companyId") companyId: Int,
        @Path("isAll") isAll: String,
        @Path("typeId") typeId: Int,
        @Path("type") type: String,
    ): APIPriceMasterResponse?

    @GET("Inventario/RecuperarArticuloInventarioFiltro/{date}/{companyId}/{isAll}/{agency}/{typeId}/{type}")
    fun fetchInventoryClientFilter(
        @Path("date") date: String,
        @Path("companyId") companyId: Int,
        @Path("isAll") isAll: String,
        @Path("typeId") typeId: Int,
        @Path("type") type: String,
        @Path("agency") agency: String,
    ): Call<ResponseBody?>

    @GET("Articulos/RecuperarArticulo/{code}/{companyId}")
    suspend fun fetchArticleByCode(
        @Path("code") code: String,
        @Path("companyId") companyId: Int
    ): APIArticleMasterResponse?

    @GET("Precios/RecuperarPrecioCodigo/{code}/{companyId}")
    suspend fun fetchPriceCode(
        @Path("code") date: String,
        @Path("companyId") companyId: Int
    ): APIPriceMasterResponse?

    @GET("Articulos/RecuperarArticulo/{code}/{companyId}")
    suspend fun fetchBannerArticle(
        @Path("code") code: String,
        @Path("companyId") companyId: Int,
    ): APIArticleMasterResponse?

    @GET("Precios/RecuperarPrecioCodigo/{code}/{companyId}")
    suspend fun fetchBannerPrice(
        @Path("code") code: String,
        @Path("companyId") companyId: Int,
    ): APIPriceMasterResponse?

    @GET("Articulos/RecuperarArticuloClienteBusqueda/{date}/{companyId}/{search}")
    suspend fun searchArticle(
        @Path("search") search: String,
        @Path("date") date: String,
        @Path("companyId") companyId: Int,
    ): APIArticleMasterResponse?

    @GET("Precios/RecuperarPrecioClienteBusqueda/{date}/{companyId}/{search}")
    suspend fun searchPrices(
        @Path("search") search: String,
        @Path("date") date: String,
        @Path("companyId") companyId: Int,
    ): APIPriceMasterResponse?

    @GET("Inventario/RecuperarArticuloInventarioBusqueda/{date}/{companyId}/{agency}/{search}")
    fun searchInventory(
        @Path("search") search: String,
        @Path("date") date: String,
        @Path("companyId") companyId: Int,
        @Path("agency") agency: String
    ): Call<ResponseBody?>

    @POST("Favoritos/GetSet")
    suspend fun setDelFavorites(
        @Body apiFavoriteRequest: APIFavoriteRequest
    ): APIFavoriteResponse

    @POST("Articulos/RecuperarArticuloConIds")
    suspend fun recoverArticlesByIds(
        @Body apiArticleFavoriteRequest: APIArticleFavoriteRequest
    ): APIArticleMasterResponse?

    @POST("Inventario/RecuperarInventarioConIds")
    fun recoverInventoriesByIds(
        @Body apiArticleFavoriteRequest: APIArticleFavoriteRequest
    ): Call<ResponseBody?>

    @POST("Precios/RecuperarPreciosConIds")
    suspend fun recoverPricesByIds(
        @Body apiArticleFavoriteRequest: APIArticleFavoriteRequest
    ): APIPriceMasterResponse?

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