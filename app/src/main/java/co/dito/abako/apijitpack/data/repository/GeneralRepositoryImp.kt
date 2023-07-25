package co.dito.abako.apijitpack.data.repository

import co.dito.abako.apijitpack.data.common.utils.REQUEST_DATE_FORMAT
import co.dito.abako.apijitpack.data.common.utils.dateFormat
import co.dito.abako.apijitpack.data.model.response.configuration.APIConfigurationResponse
import co.dito.abako.apijitpack.data.model.response.general.MasterTypeRequest
import co.dito.abako.apijitpack.data.network.GeneralBusinessApiService
import co.dito.abako.apijitpack.data.network.GeneralMobileApiService
import co.dito.abako.apijitpack.data.network.validResponse
import co.dito.abako.apijitpack.domain.general.GeneralRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.Date

class GeneralRepositoryImp(
    private val generalMobileApiService: GeneralMobileApiService,
    private val generalBusinessApiService: GeneralBusinessApiService
) : GeneralRepository {

    override suspend fun getConfiguration(date: Date, companyId: Int, isAll: Boolean): Flow<List<APIConfigurationResponse>> = flow {
        val response = generalMobileApiService.getConfiguration(
            date.dateFormat(REQUEST_DATE_FORMAT),
            companyId,
            if (isAll) "S" else "N",
        )
        emit(response)
    }

    override suspend fun fetchMasterId(type: MasterTypeRequest, master: String): Flow<String> = flow {
        val response = generalBusinessApiService.fetchMasterId(
            type = type.value,
            master = master
        )
        response.messageResponse.validResponse()
        if (response.masterId.isNullOrEmpty()) {
            throw MasterException.MasterNotFound
        }

        emit(response.masterId)
    }
}

sealed class MasterException(text: String = "") : Exception(text) {
    object MasterNotFound : MasterException()
}