package co.dito.abako.apijitpack.domain.general

import co.dito.abako.apijitpack.data.model.response.configuration.APIConfigurationResponse
import co.dito.abako.apijitpack.data.model.response.general.MasterIdResponse
import co.dito.abako.apijitpack.data.model.response.general.MasterTypeRequest
import kotlinx.coroutines.flow.Flow
import java.util.Date

interface GeneralRepository {

    suspend fun getConfiguration(
        date: Date,
        companyId: Int,
        isAll: Boolean
    ): Flow<List<APIConfigurationResponse>>

    suspend fun fetchMasterId(
        type: MasterTypeRequest,
        master: String
    ) : Flow<String>
}
