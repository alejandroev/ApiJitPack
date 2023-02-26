package co.dito.abako.apijitpack.domain.article

import java.util.Date

interface ArticleRepository {

    suspend fun fetchPromotionArticles(
        isAll: Boolean,
        currentDate: Date,
        companyId: Int
    )
}