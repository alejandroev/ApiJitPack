package co.dito.abako.apijitpack.data.model.response.invoice

import co.dito.abako.apijitpack.data.common.converters.DateJsonDeserializeOld
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import java.util.Date

data class InvoiceSyncResponse(
    @SerializedName("IdPedidoVenta") val idPed: Int,
    @JsonAdapter(DateJsonDeserializeOld::class) @SerializedName("Fc") val fc: Date,
) {
}

/*  /// <summary>
        /// IdPedidoVenta
        /// </summary>
        [DataMember]
        public decimal IdPed { get; set; }
        /// <summary>
        /// IdVenta
        /// </summary>
        [DataMember]
        public decimal IdVnt { get; set; }
        /// <summary>
        /// NumeroVenta
        /// </summary>
        [DataMember]
        public decimal Fctr { get; set; }
        /// <summary>
        /// FechaCreacion de la factura
        /// </summary>
        [DataMember]
        public DateTime Fc { get; set; }
        /// <summary>
        /// Id Empresa
        /// </summary>
        [DataMember]
        public decimal IdEmp { get; set; }
        /// <summary>
        /// Id Asesor
        /// </summary>
        [DataMember]
        public decimal IdAssr { get; set; }
        /// <summary>
        /// IdFormaPago
        /// </summary>
        [DataMember]
        public decimal FP { get; set; }
        /// <summary>
        /// OtrosValores
        /// </summary>
        [DataMember]
        public decimal OtrosValores { get; set; }
        /// <summary>
        /// IdArticulos
        /// </summary>
        [DataMember]
        public decimal IdArt { get; set; }
        /// <summary>
        /// CantidadVenta
        /// </summary>
        [DataMember]
        public decimal Cant { get; set; }
        /// <summary>
        /// Precio
        /// </summary>
        [DataMember]
        public decimal Precio { get; set; }
        /// <summary>
        /// Subtotal
        /// </summary>
        [DataMember]
        public decimal Subtotal { get; set; }*/