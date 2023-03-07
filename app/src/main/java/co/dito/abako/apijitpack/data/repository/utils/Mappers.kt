package co.dito.abako.apijitpack.data.repository.utils

import co.dito.abako.apijitpack.data.model.request.general.CancelDocumentRequest
import co.dito.abako.apijitpack.data.model.request.general.CancelDocumentRequestOld
import co.dito.abako.apijitpack.data.model.request.general.GpsDetailRequest
import co.dito.abako.apijitpack.data.model.request.general.GpsDetailRequestOld
import co.dito.abako.apijitpack.data.model.request.general.GpsTourRequest
import co.dito.abako.apijitpack.data.model.request.general.GpsTourRequestOld
import co.dito.abako.apijitpack.data.model.request.report.DocumentReportRequest
import co.dito.abako.apijitpack.data.model.request.report.DocumentReportRequestOld
import co.dito.abako.apijitpack.data.model.response.delivery.GpsTourResponse
import co.dito.abako.apijitpack.data.model.response.delivery.GpsTourResponseOld
import co.dito.abako.apijitpack.data.model.response.general.MessageResponse
import co.dito.abako.apijitpack.data.model.response.general.MessageResponseOld
import co.dito.abako.apijitpack.data.model.response.report.DocumentReportResponse
import co.dito.abako.apijitpack.data.model.response.report.DocumentReportResponseOld

fun GpsTourRequest.mapper(): GpsTourRequestOld = GpsTourRequestOld(
    idUser = idUser,
    dll = dll.map { it.mapper() }
)

fun CancelDocumentRequest.mapper(): CancelDocumentRequestOld =
    CancelDocumentRequestOld(
        movement = movement,
        idUser = idUser,
        document = document,
        validationReference = validationReference
    )

fun GpsDetailRequest.mapper(): GpsDetailRequestOld = GpsDetailRequestOld(
    idBusiness = idBusiness,
    longitude = longitude,
    latitude = latitude,
    creationDate = creationDate,
    type = type
)

fun GpsTourResponseOld.mapper(): GpsTourResponse = GpsTourResponse(
    state = state.mapper(),
    msgId = msgId,
    msgStr = msgStr
)

fun MessageResponseOld.mapper(): MessageResponse = MessageResponse(
    msgId = msgId,
    msgStr = msgStr
)

fun DocumentReportResponseOld.mapper(): DocumentReportResponse =
    DocumentReportResponse(
        header = header,
        detail = detail
    )