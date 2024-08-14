package co.dito.abako.apijitpack.data.network

import co.dito.abako.apijitpack.data.model.request.favorite.APIArticleFavoriteRequest
import co.dito.abako.apijitpack.data.model.request.favorite.APIFavoriteRequest
import co.dito.abako.apijitpack.data.model.response.article.APIArticleMasterResponse
import co.dito.abako.apijitpack.data.model.response.article.APIPromotionArticleResponse
import co.dito.abako.apijitpack.data.model.response.asesor.PermisosAsesorMarca
import co.dito.abako.apijitpack.data.model.response.favorite.APIFavoriteResponse
import co.dito.abako.apijitpack.data.model.response.price.APIPriceMasterResponse
import co.dito.abako.apijitpack.data.model.response.service.ProgrammingResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ServiceMobileAPIService {

    @GET("Servicios/GetProgramacion/{IdPersona}")
    suspend fun fetchProgramacion(
        @Path("IdPersona") IdPersona: String,
    ): ProgrammingResponse


}