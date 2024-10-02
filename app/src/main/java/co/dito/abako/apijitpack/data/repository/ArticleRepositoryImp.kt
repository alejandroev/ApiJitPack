package co.dito.abako.apijitpack.data.repository

import co.dito.abako.apijitpack.data.common.utils.REQUEST_DATE_FORMAT
import co.dito.abako.apijitpack.data.common.utils.dateFormat
import co.dito.abako.apijitpack.data.model.request.InquestRequest
import co.dito.abako.apijitpack.data.model.request.MessageServiceResponse
import co.dito.abako.apijitpack.data.model.request.ServiciosRequest
import co.dito.abako.apijitpack.data.model.request.banner.APIBannerRequest
import co.dito.abako.apijitpack.data.model.request.favorite.APIArticleFavoriteRequest
import co.dito.abako.apijitpack.data.model.request.favorite.APIFavoriteRequest
import co.dito.abako.apijitpack.data.model.response.InquestModelResponse
import co.dito.abako.apijitpack.data.model.response.article.APIArticleMasterResponse
import co.dito.abako.apijitpack.data.model.response.article.APIPromotionArticleResponse
import co.dito.abako.apijitpack.data.model.response.article.PlatformType
import co.dito.abako.apijitpack.data.model.response.asesor.PermisosAsesorMarca
import co.dito.abako.apijitpack.data.model.response.banner.APIBannerResponse
import co.dito.abako.apijitpack.data.model.response.category.APICategoryResponse
import co.dito.abako.apijitpack.data.model.response.favorite.APIDetailFavoriteRequestResponse
import co.dito.abako.apijitpack.data.model.response.favorite.APIFavoriteResponse
import co.dito.abako.apijitpack.data.model.response.inventory.APIInventoryResponse
import co.dito.abako.apijitpack.data.model.response.line.APILineResponse
import co.dito.abako.apijitpack.data.model.response.novelty.NoveltyModelResponse
import co.dito.abako.apijitpack.data.model.response.service.ProgrammingDetailResponse
import co.dito.abako.apijitpack.data.model.response.service.ProgrammingResponse
import co.dito.abako.apijitpack.data.network.ArticleMobileAPIService
import co.dito.abako.apijitpack.data.network.BannerShoppingCartAPIService
import co.dito.abako.apijitpack.domain.article.ArticleRepository
import co.dito.abako.apijitpack.utils.extractArray
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.awaitResponse
import java.util.Date

class ArticleRepositoryImp(
    private val articleMobileAPIService: ArticleMobileAPIService,
    private val shoppingCartAPIService: BannerShoppingCartAPIService
) : ArticleRepository {
    override suspend fun getNovelty(fecha: String, esTodo: String): Flow<NoveltyModelResponse> {
        return flow {
            val noveltyModelResponse = articleMobileAPIService.getNovelty(fecha, esTodo)
            emit(noveltyModelResponse)
        }
    }

    override suspend fun fetchInquest(inquestRequest: InquestRequest): Flow<InquestModelResponse> {
        return flow {
            val articleResponse = articleMobileAPIService.inquest(
                inquestRequest
            )
            emit(articleResponse)
        }
    }

    override suspend fun actualizarDetalleProgramacion(serviciosRequest: ServiciosRequest): Flow<MessageServiceResponse> {
        return flow {
            val response = articleMobileAPIService.actualizarDetalleProgramacion(
                serviciosRequest
            )
            emit(response)
        }
    }

    override suspend fun fetchProgramacion(IdPersona: String): Flow<ProgrammingResponse> {
        return flow {
            val articleResponse = articleMobileAPIService.fetchProgramacion(
                IdPersona
            )
            emit(articleResponse)
        }
    }

    override suspend fun fetchProgramacionDetail(id: String): Flow<ProgrammingDetailResponse> {
        return flow {
            val articleResponse = articleMobileAPIService.fetchProgrammingDetail(
                id
            )
            emit(articleResponse)
        }
    }

    override suspend fun fetchPromotionArticles(
        isAll: Boolean,
        currentDate: Date,
        companyId: Int,
        agency: String,
        platformType: PlatformType
    ): Flow<APIPromotionArticleResponse> {
        return flow {
            val articleResponse = articleMobileAPIService.fetchPromotionArticles(
                isAll = if (isAll) "S" else "N",
                currentDate = currentDate.dateFormat(REQUEST_DATE_FORMAT),
                companyId = companyId,
                platform = platformType.value
            )
            val inventoryResponse = articleMobileAPIService.fetchPromotionInventory(
                currentDate = currentDate.dateFormat(REQUEST_DATE_FORMAT),
                companyId = companyId,
                agency = agency
            ).awaitResponse().extractArray(
                Array<APIInventoryResponse>::class.java,
                "inventarios"
            )?.toList() ?: emptyList()

            emit(articleResponse.copy(inventory = inventoryResponse))
        }
    }

    override suspend fun fetchArticlesClientFilter(
        date: Date,
        companyId: Int,
        isAll: Boolean,
        typeId: Int,
        type: String,
        agency: String,
        platformType: PlatformType
    ): Flow<APIArticleMasterResponse?> =
        flow {
            val articlesResponse = articleMobileAPIService.fetchArticleClientFilter(
                date.dateFormat(REQUEST_DATE_FORMAT),
                companyId,
                if (isAll) "S" else "N",
                typeId,
                type,
                platform = platformType.value
            )
            val priceResponse = articleMobileAPIService.fetchPriceClientFilter(
                date.dateFormat(REQUEST_DATE_FORMAT),
                companyId,
                if (isAll) "S" else "N",
                typeId,
                type
            )
            val inventoryResponse = articleMobileAPIService.fetchInventoryClientFilter(
                date.dateFormat(REQUEST_DATE_FORMAT),
                companyId,
                if (isAll) "S" else "N",
                typeId,
                type,
                agency
            ).awaitResponse().extractArray(
                Array<APIInventoryResponse>::class.java,
                "inventarios"
            )?.toList() ?: emptyList()

            emit(
                articlesResponse?.copy(
                    pricesDetail = priceResponse?.pricesDetail ?: emptyList(),
                    metricUnits = priceResponse?.metricUnits ?: emptyList(),
                    inventories = inventoryResponse
                )
            )
        }

    override suspend fun fetchArticlesByCode(
        code: String,
        companyId: Int,
        platformType: PlatformType
    ): Flow<APIArticleMasterResponse?> = flow {
        val articleResponse = articleMobileAPIService.fetchArticleByCode(
            code,
            companyId,
            platform = platformType.value
        )
        val priceResponse = articleMobileAPIService.fetchPriceCode(code, companyId)

        emit(
            articleResponse?.copy(
                pricesDetail = priceResponse?.pricesDetail ?: emptyList(),
                metricUnits = priceResponse?.metricUnits ?: emptyList(),
                inventories = emptyList()
            )
        )
    }

    override suspend fun fetchLineArticle(
        date: Date,
        companyId: Int,
        isAll: Boolean,
        platformType: PlatformType
    ): Flow<List<APILineResponse>> {
        return flow {
            val response = articleMobileAPIService.fetchLineArticles(
                date = date.dateFormat(REQUEST_DATE_FORMAT),
                companyId = companyId,
                isAll = if (isAll) "S" else "N",
                platform = platformType.value
            )
            val apiLineResponse =
                response.awaitResponse().extractArray(Array<APILineResponse>::class.java, "lineas")
                    ?.toMutableList() ?: mutableListOf()
            apiLineResponse.forEachIndexed { index, line ->
                val categories = mutableListOf<APICategoryResponse>()
                line.categoriesList.forEach {
                    categories.add(it.copy(lineId = line.lineId))
                }
                apiLineResponse[index] = line.copy(categoriesList = categories)
            }
            emit(apiLineResponse)
        }
    }

    override suspend fun searchArticle(
        search: String,
        date: Date,
        companyId: Int,
        agency: String,
        platformType: PlatformType
    ): Flow<APIArticleMasterResponse?> = flow {
        val articleResponse =
            articleMobileAPIService.searchArticle(
                search = search,
                date = date.dateFormat(REQUEST_DATE_FORMAT),
                companyId = companyId,
                platform = platformType.value
            )
        val priceResponse = articleMobileAPIService.searchPrices(
            search = search,
            date = date.dateFormat(REQUEST_DATE_FORMAT),
            companyId = companyId
        )
        val inventoryResponse = articleMobileAPIService.searchInventory(
            search = search,
            date = date.dateFormat(REQUEST_DATE_FORMAT),
            companyId = companyId,
            agency = agency
        ).awaitResponse().extractArray(
            Array<APIInventoryResponse>::class.java,
            "inventarios"
        )?.toList() ?: emptyList()


        emit(
            articleResponse?.copy(
                pricesDetail = priceResponse?.pricesDetail ?: emptyList(),
                metricUnits = priceResponse?.metricUnits ?: emptyList(),
                inventories = inventoryResponse
            )
        )
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
            val apiCategoryResponse =
                response.awaitResponse()
                    .extractArray(Array<APICategoryResponse>::class.java, key = "categorias")
                    ?.toList() ?: emptyList()
            emit(apiCategoryResponse)
        }
    }

    override suspend fun getBanner(bannerModelRequest: APIBannerRequest): Flow<APIBannerResponse?> =
        flow {
            val response = shoppingCartAPIService.getBanner(bannerModelRequest = bannerModelRequest)
            emit(response)
        }

    override suspend fun getBannerArticle(
        code: String,
        companyId: Int,
        platformType: PlatformType
    ): Flow<APIArticleMasterResponse?> = flow {
        val articleResponse = articleMobileAPIService.fetchBannerArticle(
            code = code,
            companyId = companyId,
            platform = platformType.value
        )
        val priceResponse = articleMobileAPIService.fetchBannerPrice(
            code = code,
            companyId = companyId
        )

        emit(
            articleResponse?.copy(
                pricesDetail = priceResponse?.pricesDetail ?: emptyList(),
                metricUnits = priceResponse?.metricUnits ?: emptyList(),
                inventories = emptyList()
            )
        )
    }

    override suspend fun getSetFavoriteArticles(apiFavoriteRequest: APIFavoriteRequest): APIFavoriteResponse =
        articleMobileAPIService.setDelFavorites(apiFavoriteRequest = apiFavoriteRequest)

    override suspend fun permisosAsesorMarca(idEmpresa: Int): ArrayList<PermisosAsesorMarca> =
        articleMobileAPIService.permisosAsesorMarca(idEmpresa)


    override suspend fun getFavorites(
        date: Date,
        personId: Int,
        isAll: Boolean,
        agency: String,
        articles: List<APIDetailFavoriteRequestResponse>
    ): Flow<APIArticleMasterResponse?> = flow {
        val articleRequest = APIArticleFavoriteRequest(
            isAll = if (isAll) "S" else "N",
            date = date.dateFormat(REQUEST_DATE_FORMAT),
            agency = agency,
            personId = personId,
            articles = articles
        )

        val articleResponse = articleMobileAPIService.recoverArticlesByIds(articleRequest)
        if (articleResponse == null) {
            emit(null)
            return@flow
        }

        val priceResponse = articleMobileAPIService.recoverPricesByIds(articleRequest)
        val inventoryResponse =
            articleMobileAPIService.recoverInventoriesByIds(articleRequest).awaitResponse()
                .extractArray(
                    Array<APIInventoryResponse>::class.java,
                    "inventarios"
                )?.toList() ?: emptyList()

        emit(
            articleResponse.copy(
                pricesDetail = priceResponse?.pricesDetail ?: emptyList(),
                metricUnits = priceResponse?.metricUnits ?: emptyList(),
                inventories = inventoryResponse
            )
        )
    }


}