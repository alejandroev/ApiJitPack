package co.dito.abako.apijitpack.data.network

import co.dito.abako.apijitpack.data.model.request.banner.APIBannerRequest
import co.dito.abako.apijitpack.data.model.response.banner.APIBannerResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface BannerShoppingCartAPIService {

    @POST("Banners/ModificarBanners")
    suspend fun getBanner(@Body bannerModelRequest: APIBannerRequest): APIBannerResponse?
}