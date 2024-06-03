package co.dito.abako.apijitpack.data.model.response.delivery

import co.dito.abako.apijitpack.data.common.converters.DateJsonDeserialize
import co.dito.abako.apijitpack.data.common.converters.DateJsonDeserializeOld
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * @param id = Delivery id
 * @param doc = Payroll number
 * @param obs = Observation
 * @param fcEnt = Delivery date
 * @param fcCre = Creation date
 * @param facts = Number of invoices
 * @param ctd = Quantity invoices in cash
 * @param crdt = Quantity invoices in credit
 * @param rms = Referrals
 * @param ttl = Total load
 * @param nts = Notes
 * @param otCb = Other charges
 * @param ttLq = Total settlement
 * @param liq = Liquidation
 * @param des = Offset
 */

data class DeliverySyncResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("doc") val doc: String,
    @SerializedName("obs") val obs: String,
    @JsonAdapter(DateJsonDeserialize::class) @SerializedName("fcEnt") val fcEnt: Date,
    @JsonAdapter(DateJsonDeserialize::class) @SerializedName("fcCre") val fcCre: Date,
    @SerializedName("facts") val facts: Int,
    @SerializedName("ctd") val ctd: Double,
    @SerializedName("crdt") val crdt: Double,
    @SerializedName("rms") val rms: Double,
    @SerializedName("ttl") val ttl: Double,
    @SerializedName("nts") val nts: Double,
    @SerializedName("otCb") val otCb: Double,
    @SerializedName("ttLq") val ttLq: Double,
    @SerializedName("liq") val liq: Double,
    @SerializedName("des") val des: Double,
)