package br.com.fiap.lanchonetefilura.api.model.pedido

import br.com.fiap.lanchonetefilura.api.model.cliente.ClienteResponse
import br.com.fiap.lanchonetefilura.api.model.produto.ProdutoResponse
import java.util.*

data class PedidoResponse (
    val id: UUID,
    val senha: Int? = null,
    val etapa: String,
    val cliente: ClienteResponse? = null,
    val produtos: List<ProdutoResponse>,
    val preco: Double? = 0.0,
    val pago: Boolean
)
