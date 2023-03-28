package co.dito.abako.apijitpack.data.repository

import co.dito.abako.apijitpack.data.common.utils.REQUEST_DATE_FORMAT
import co.dito.abako.apijitpack.data.common.utils.dateFormat
import co.dito.abako.apijitpack.data.model.response.configuration.APIConfigurationResponse
import co.dito.abako.apijitpack.data.network.GeneralMobileApiService
import co.dito.abako.apijitpack.domain.general.GeneralRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.w3c.dom.Document
import java.util.Date

class GeneralRepositoryImp @Inject constructor(
    private val generalMobileApiService: GeneralMobileApiService,
) : GeneralRepository {

    override suspend fun getConfiguration(date: Date, companyId: Int, isAll: Boolean): Flow<List<APIConfigurationResponse>> = flow {
        val response = generalMobileApiService.getConfiguration(
            date.dateFormat(REQUEST_DATE_FORMAT),
            companyId,
            if (isAll) "S" else "N",
        )
        emit(response)
    }
}