package co.dito.abako.apijitpack.data.model.response.delivery

import co.dito.abako.apijitpack.data.model.response.article.ArticleSyncResponse
import co.dito.abako.apijitpack.data.model.response.client.ChannelSyncResponse
import co.dito.abako.apijitpack.data.model.response.client.ClientSyncResponse
import co.dito.abako.apijitpack.data.model.response.client.ZoneSyncResponse
import co.dito.abako.apijitpack.data.model.response.contact.ContactSyncResponse
import co.dito.abako.apijitpack.data.model.response.invoice.InvoiceSyncResponse
import co.dito.abako.apijitpack.data.model.response.route.AdviserSyncResponse
import com.google.gson.annotations.SerializedName

/**
 * @param invoices = list of invoices
 * @param clients = list of clients
 * @param contacts = list of contacts
 * @param channels = list of channels
 * @param zones = list of zones
 * @param advisers = list of advisers
 * @param articles = list of articles
 */

data class DeliveryDetailSyncResponse(
    @SerializedName("facturas") val invoices: List<InvoiceSyncResponse>,
    @SerializedName("clientes") val clients: List<ClientSyncResponse>,
    @SerializedName("contactos") val contacts: List<ContactSyncResponse>,
    @SerializedName("canales") val channels: List<ChannelSyncResponse>,
    @SerializedName("zonas") val zones: List<ZoneSyncResponse>,
    @SerializedName("asesores") val advisers: List<AdviserSyncResponse>,
    @SerializedName("articulos") val articles: List<ArticleSyncResponse>,
)