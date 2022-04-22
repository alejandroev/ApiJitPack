package co.dito.abako.apijitpack.data.model.response.delivery

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
    @SerializedName("Id") val id: Int,
    @SerializedName("Doc") val doc: String,
    @SerializedName("Obs") val obs: String,
    @SerializedName("FcEnt") val fcEnt: Date,
    @SerializedName("FcCre") val fcCre: Date,
    @SerializedName("Facts") val facts: Int,
    @SerializedName("Ctd") val ctd: Int,
    @SerializedName("Crdt") val crdt: Int,
    @SerializedName("Rms") val rms: Int,
    @SerializedName("Ttl") val ttl: Double,
    @SerializedName("Nts") val nts: Double,
    @SerializedName("OtCb") val otCb: Double,
    @SerializedName("TtLq") val ttLq: Double,
    @SerializedName("Liq") val liq: Double,
    @SerializedName("Des") val des: Double,
)